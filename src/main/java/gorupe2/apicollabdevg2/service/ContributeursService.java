package gorupe2.apicollabdevg2.service;


import gorupe2.apicollabdevg2.DTO.ContributeursDTO;
import gorupe2.apicollabdevg2.entity.*;
import gorupe2.apicollabdevg2.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContributeursService {


    @Autowired
    private IdeeProjetRepository ideeProjetRepository;

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Autowired
    private DebloquerProjetRepository debloquerProjetRepository;

    @Autowired
    private ContributionsRepository contributionRepository;

    @Autowired
    private ProjetsRepository projetRepository;

    @Autowired
    private ContributeursRepository contributeursRepository;
// Afficher Contributeurs
    public Contributeurs afficher(int id) {
        return contributeursRepository.findById(id).orElseThrow();
    }

// Ajouter contributeurs
    public Contributeurs AjouterContributeur(ContributeursDTO contributeursDTO) {
        if (contributeursRepository.existsContributeursByEmail(contributeursDTO.getEmail())) {
            throw new RuntimeException("Cet email est déjà utilisé");
        }

        Contributeurs contributeur = new Contributeurs();
        contributeur.setEmail(contributeursDTO.getEmail());
        contributeur.setPassword(contributeursDTO.getPassword());
        contributeur.setNom(contributeursDTO.getNom());
        contributeur.setPrenom(contributeursDTO.getPrenom());
        contributeur.setNiveau(contributeursDTO.getNiveau());
        contributeur.setProfil(contributeursDTO.getProfil());

        return contributeursRepository.save(contributeur);
    }

// Lister contributeurs
    public List<ContributeursDTO> ListerContributeurs() {

        List<ContributeursDTO> contributeurs = new ArrayList<>();
        List<Contributeurs> contributeursList = contributeursRepository.findAll();
        for (Contributeurs contributeur : contributeursList) {
            ContributeursDTO contributeurDTO = new ContributeursDTO();
            contributeurDTO.setEmail(contributeur.getEmail());
            contributeurDTO.setNom(contributeur.getNom());
            contributeurDTO.setPrenom(contributeur.getPrenom());
            contributeurDTO.setNiveau(contributeur.getNiveau());
            contributeurDTO.setProfil(contributeur.getProfil());
        }
        return contributeurs;
    }

    // Afficher le contributeur par ID
    public Optional<Contributeurs> AfficherContributeurParId(int id) {
        return contributeursRepository.findById(id);
    }

// Modifier contributeurs
    public Contributeurs ContributeursModifier(int id, ContributeursDTO contributeurDTO) {
        Contributeurs contributeur = afficher(id);

        contributeur.setNom(contributeurDTO.getNom());
        contributeur.setPrenom(contributeurDTO.getPrenom());
        contributeur.setEmail(contributeurDTO.getEmail());
        contributeur.setPassword(contributeurDTO.getPassword());
        contributeur.setProfil(contributeurDTO.getProfil());
        contributeur.setNiveau(contributeurDTO.getNiveau());

        return contributeursRepository.save(contributeur);

    }

    // supression de contributeur
    public void SupprimerContributeur(int id) {
        if (!contributeursRepository.existsById(id)){
            throw new RuntimeException("Cette contributeur n'existe pas");
        }

        contributeursRepository.deleteById(id);
    }

    //contributeur est connecter
    public Contributeurs Contributeurconect(String email, String password) {
        Optional<Contributeurs> Contributeur = contributeursRepository.findByEmail(email);
        if (Contributeur.isEmpty() || !Contributeur.get().getPassword().equals(password)) {
            throw new RuntimeException("Email ou mot de passe incorrect");
        }

        Contributeurs contributeurs = Contributeur.get();
        contributeurs.setConnected(true);
        return contributeursRepository.save(contributeurs);
    }
// contributeur est deconnecter
    public void deconnecter(int id) {
        Contributeurs contributeurs = afficher(id);
        contributeurs.setConnected(false);
        contributeursRepository.save(contributeurs);

    }

    public ContributeursDTO convertirEnDTO(Contributeurs contributeurs) {

        ContributeursDTO contributeurDTO = new ContributeursDTO();

        return new ContributeursDTO(
                contributeurDTO.getId(),
                contributeurDTO.getNom(),
                contributeurDTO.getPrenom(),
                contributeurDTO.getEmail(),
                contributeurDTO.getPassword(),
                contributeurDTO.getProfil(),
                contributeurDTO.getNiveau()

        );
    }
    public Contributeurs convertirEnEntite(ContributeursDTO dto){
        Contributeurs contributeurs = new Contributeurs();
        contributeurs.setId(dto.getId());
        contributeurs.setNom(dto.getNom());
        contributeurs.setEmail(dto.getEmail());
        contributeurs.setProfil(dto.getProfil());
        contributeurs.setNiveau(dto.getNiveau());
        return contributeurs;
    }
    // Ajoutez ces méthodes à votre classe existante ContributeursService

    public IdeeProjet creerIdeeProjet(int contributeurId, String titre, String description) {
        Contributeurs contributeur = afficher(contributeurId);

        if (!contributeur.isConnected()) {
            throw new RuntimeException("Le contributeur doit être connecté pour créer une idée");
        }

        IdeeProjet ideeProjet = new IdeeProjet();
        ideeProjet.setTitre(titre);
        ideeProjet.setDescription(description);
        ideeProjet.setDateCreation(LocalDateTime.now());
        ideeProjet.setContributeurs(contributeur);

        return ideeProjetRepository.save(ideeProjet);
    }

    public Commentaires commenterProjet(int contributeurId, int projetId, String contenu) {
        Contributeurs contributeur = afficher(contributeurId);
        Projet projet = projetRepository.findById(projetId)
                .orElseThrow(() -> new RuntimeException("Projet non trouvé"));

        if (!contributeur.isConnected()) {
            throw new RuntimeException("Le contributeur doit être connecté pour commenter");
        }

        Commentaires commentaire = new Commentaires();
        commentaire.setContenu(contenu);
        commentaire.setDateCreation(LocalDateTime.now());
        commentaire.setContributeur(contributeur);
        commentaire.setProjet(projet);

        return commentaireRepository.save(commentaire);
    }

    public DebloquerProjet debloquerProjet(int contributeurId, int projetId, double montant) {
        Contributeurs contributeur = afficher(contributeurId);
        Projet projet = projetRepository.findById(projetId)
                .orElseThrow(() -> new RuntimeException("Projet non trouvé"));

        if (!contributeur.isConnected()) {
            throw new RuntimeException("Le contributeur doit être connecté pour débloquer un projet");
        }

        // Vérifier si le contributeur a assez de coins
        double coinsDisponibles = contributeur.getCoins().stream()
                .mapToDouble(Coins::getMontant)
                .sum();

        if (coinsDisponibles < montant) {
            throw new RuntimeException("Fonds insuffisants");
        }

        DebloquerProjet debloquerProjet = new DebloquerProjet();
        debloquerProjet.setMontant(montant);
        debloquerProjet.setDateDebloquage(LocalDateTime.now());
        debloquerProjet.setContributeur(contributeur);
        debloquerProjet.setProjet(projet);

        // Mettre à jour le montant collecté du projet
        projet.setMontantCollecte(projet.getMontantCollecte() + montant);
        projetRepository.save(projet);

        return debloquerProjetRepository.save(debloquerProjet);
    }

    public Contributions contribuerAuProjet(int contributeurId, int projetId, String typeContribution, String description) {
        Contributeurs contributeur = afficher(contributeurId);
        Projet projet = projetRepository.findById(projetId)
                .orElseThrow(() -> new RuntimeException("Projet non trouvé"));

        if (!contributeur.isConnected()) {
            throw new RuntimeException("Le contributeur doit être connecté pour contribuer");
        }

        Contributions contribution = new Contributions();
        contribution.setTypeContribution(typeContribution);
        contribution.setDescription(description);
        contribution.setDateContribution(LocalDateTime.now());
        contribution.setContributeur(contributeur);
        contribution.setProjet(projet);

        return contributionRepository.save(contribution);
    }
}

