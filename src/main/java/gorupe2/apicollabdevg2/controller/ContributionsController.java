package gorupe2.apicollabdevg2.controller;

import gorupe2.apicollabdevg2.entity.Contributeurs;
import gorupe2.apicollabdevg2.entity.Contributions;
import gorupe2.apicollabdevg2.service.ContributeursService;
import gorupe2.apicollabdevg2.service.ContributionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Contributions")
public class ContributionsController {


    // Injection automatique du service qui contient la logique métier liée aux contributeurs
    @Autowired
    private ContributionsService contributionsService;

    /**
     * Méthode pour ajouter un contributeur
     * Reçoit les données d'un contributeur dans le corps de la requête en format JSON
     * Méthode HTTP : POST => utilisée pour créer une nouvelle ressource
     */
    @PostMapping
    public Contributions AjouterContributions(@RequestBody Contributions contributions) {
        return contributionsService.AjouterContributions(contributions);
    }

    /**
     * Méthode pour récupérer la liste de tous les contributeurs
     * Méthode HTTP : GET => récupération d'une ressource
     */
    @GetMapping
    public List<Contributions> ListerContributions() {
        return contributionsService.ListerContributions();
    }
    /**
     * Méthode pour récupérer un contributeur par son identifiant
     * @param id identifiant du contributeur
     * Méthode HTTP : GET avec paramètre dans l'URL
     */
    @GetMapping("/{id}")
    public Optional<Contributions> AfficherContributionsParId(@PathVariable int id) {
        return contributionsService.AfficherContributionsParId(id);
    }

    /**
     * Méthode pour modifier un contributeur par son identifiant
     * @param id identifiant du contributeur
     * Méthode HTTP : PUT avec paramètre dans l'URL
     */
    @PutMapping("/{id}") // Correction : ici on utilise PUT pour mettre à jour une ressource existante
    public Contributions Modifier(@PathVariable int id, @RequestBody Contributions contributions) {
        return contributionsService.ModifierContributions(id, contributions);
    }

/**  * Méthode pour supprimer un contributeur par son identifiant
 * Méthode HTTP : DELETE
 */
@DeleteMapping("/{id}")
public void supprimerContributeur(@PathVariable int id) {
    contributionsService.SupprimerContributions(id);
    }
}
