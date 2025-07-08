package gorupe2.apicollabdevg2.controller;

import gorupe2.apicollabdevg2.DTO.AuthDTO;
import gorupe2.apicollabdevg2.DTO.ContributeursDTO;
import gorupe2.apicollabdevg2.entity.*;
import gorupe2.apicollabdevg2.repository.ContributeursRepository;
import gorupe2.apicollabdevg2.service.ContributeursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Annotation qui rend cette classe un contrôleur REST, les méthodes retourneront directement les données JSON ou XML
@RestController
// Définition de l'URL de base pour toutes les requêtes de ce contrôleur
@RequestMapping("/api/contributeurs")
public class contributeursController {

    // Injection automatique du service qui contient la logique métier liée aux contributeurs
    @Autowired
    private ContributeursService contributeursService;
    @Autowired
    private ContributeursRepository contributeursRepository;




    @GetMapping("/{id}")
    public Optional<Contributeurs> AfficherContributeurParId(@PathVariable int id) {
        return contributeursService.AfficherContributeurParId(id);
    }



    @PostMapping("/contributeurs")
    @ResponseStatus(HttpStatus.CREATED)
    public Contributeurs creerContributeur(@RequestBody ContributeursDTO contributeursDTO) {
        return contributeursService.AjouterContributeur(contributeursDTO);
    }


    @PutMapping("/contributeurs/{id}")
    public Contributeurs ContributeursModifier(@PathVariable int id, @RequestBody ContributeursDTO contributeursDTO) {
        return contributeursService.ContributeursModifier(id, contributeursDTO);
    }

    @GetMapping("/contributeurs")
    public List<ContributeursDTO> getAllcontributeurs() {
        return contributeursService.ListerContributeurs();
    }

    @DeleteMapping("/contributeurs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void supprimerContributeur(@PathVariable int id) {

        contributeursService.SupprimerContributeur(id);
    }

    @PostMapping("/contributeurs/{id}/connexion")
    public Contributeurs connecter(@RequestBody AuthDTO authDTO) {
        return contributeursService.Contributeurconect(authDTO.getEmail(), authDTO.getPassword());
    }

    @PostMapping("/contributeurs/{id}/deconnexion")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deconnecter(@PathVariable int id) {
        contributeursService.deconnecter(id);
    }
}
// Ajoutez ces endpoints à votre classe existante ContributeursController

        @PostMapping("/{contributeurId}/idees-projet")
        @ResponseStatus(HttpStatus.CREATED)
        public IdeeProjet creerIdeeProjet(
                @PathVariable int contributeurId,
                @RequestParam String titre,
                @RequestParam String description) {
            return ContributeursService.creerIdeeProjet(contributeurId, titre, description);
        }

        @PostMapping("/{contributeurId}/commentaires")
        @ResponseStatus(HttpStatus.CREATED)
        public Commentaires commenterProjet(
                @PathVariable int contributeurId,
                @RequestParam int projetId,
                @RequestParam String contenu) {
            return ContributeursService.commenterProjet(contributeurId, projetId, contenu);
        }

        @PostMapping("/{contributeurId}/debloquer-projet")
        @ResponseStatus(HttpStatus.CREATED)
        public DebloquerProjet debloquerProjet(
                @PathVariable int contributeurId,
                @RequestParam int projetId,
                @RequestParam double montant) {
            return ContributeursService.debloquerProjet(contributeurId, projetId, montant);
        }

        @PostMapping("/{contributeurId}/contributions")
        @ResponseStatus(HttpStatus.CREATED)
        public Contributions contribuerAuProjet(
                @PathVariable int contributeurId,
                @RequestParam int projetId,
                @RequestParam String typeContribution,
                @RequestParam String description) {
            return ContributeursService.contribuerAuProjet(contributeurId, projetId, typeContribution, description);
        }
