package gorupe2.apicollabdevg2.controller;

import gorupe2.apicollabdevg2.entity.Contributeurs;
import gorupe2.apicollabdevg2.service.ContributeursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Annotation qui rend cette classe un contrôleur REST, les méthodes retourneront directement les données JSON ou XML
@RestController
// Définition de l'URL de base pour toutes les requêtes de ce contrôleur
@RequestMapping("/api/contributeurs")
public class ContributeursController {

    // Injection automatique du service qui contient la logique métier liée aux contributeurs
    @Autowired
    private ContributeursService contributeursService;

    /**
     * Méthode pour ajouter un contributeur
     * Reçoit les données d'un contributeur dans le corps de la requête en format JSON
     * Méthode HTTP : POST => utilisée pour créer une nouvelle ressource
     */
    @PostMapping
    public Contributeurs AjouterContributeurs(@RequestBody Contributeurs contributeurs) {
        return contributeursService.AjouterContributeur(contributeurs);
    }

    /**
     * Méthode pour récupérer la liste de tous les contributeurs
     * Méthode HTTP : GET => récupération d'une ressource
     */
    @GetMapping
    public List<Contributeurs> ListerContributeurs() {
        return contributeursService.ListerContributeurs();
    }

    /**
     * Méthode pour récupérer un contributeur par son identifiant
     * @param id identifiant du contributeur
     * Méthode HTTP : GET avec paramètre dans l'URL
     */
    @GetMapping("/{id}")
    public Optional<Contributeurs> AfficherContributeurParId(@PathVariable int id) {
        return contributeursService.AfficherContributeurParId(id);
    }

    /**
     * Méthode pour modifier un contributeur par son identifiant
     * @param id identifiant du contributeur
     * Méthode HTTP : PUT avec paramètre dans l'URL
     */
    @PutMapping("/{id}") // Correction : ici on utilise PUT pour mettre à jour une ressource existante
    public Contributeurs Modifier(@PathVariable int id, @RequestBody Contributeurs contributeur) {
        return contributeursService.ModifierContributeur(id, contributeur);
    }

    /**
     * Méthode pour supprimer un contributeur par son identifiant
     * Méthode HTTP : DELETE
     */
    @DeleteMapping("/{id}")
    public void supprimerContributeur(@PathVariable int id) {
        contributeursService.SupprimerContributeur(id);
    }

   /* @PostMapping
    public Contributeur ajouterContributeur(@RequestBody ContributeurDTO dto) {

        Contributeur contributeur = ContributeurService.convertirEnEntite(dto);
        Contributeur saved = contributeurService.AjouterContributeur(contributeur);
        return ContributeurService.convertirEnDTO(saved);
    }*/
}
