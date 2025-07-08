package gorupe2.apicollabdevg2.controller;

import gorupe2.apicollabdevg2.entity.Fonctionnalites;
import gorupe2.apicollabdevg2.entity.IdeeProjet;
import gorupe2.apicollabdevg2.service.FonctionnalitesService;
import gorupe2.apicollabdevg2.service.IdeeProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/IdeeProjet")
public class IdeeProjetController {



    // Injection automatique du service qui contient la logique métier liée aux contributeurs
    @Autowired
    private IdeeProjetService ideeProjetService;

    /**
     * Méthode pour ajouter un contributeur
     * Reçoit les données d'un contributeur dans le corps de la requête en format JSON
     * Méthode HTTP : POST => utilisée pour créer une nouvelle ressource
     */
    @PostMapping
    public IdeeProjet AjouterIdeeProjet(@RequestBody IdeeProjet ideeProjet) {
        return ideeProjetService.AjouterIdeeProjet(ideeProjet);
    }

    /**
     * Méthode pour récupérer la liste de tous les contributeurs
     * Méthode HTTP : GET => récupération d'une ressource
     */
    @GetMapping
    public List<IdeeProjet> ListerIdeeProjet() {
        return ideeProjetService.ListerIdeeProjet();
    }
    /**
     * Méthode pour récupérer un contributeur par son identifiant
     * @param id identifiant du contributeur
     * Méthode HTTP : GET avec paramètre dans l'URL
     */
    @GetMapping("/{id}")
    public Optional<IdeeProjet> AfficherIdeeProjetParId(@PathVariable int id) {
        return ideeProjetService.AfficherIdeeProjetParId(id);
    }

    /**
     * Méthode pour modifier un contributeur par son identifiant
     * @param id identifiant du contributeur
     * Méthode HTTP : PUT avec paramètre dans l'URL
     */
    @PutMapping("/{id}") // Correction : ici on utilise PUT pour mettre à jour une ressource existante
    public IdeeProjet ModifierIdeeProjet(@PathVariable int id, @RequestBody IdeeProjet ideeProjet) {
        return ideeProjetService.ModifierIdeeProjet(id, ideeProjet);
    }

    /**  * Méthode pour supprimer un contributeur par son identifiant
     * Méthode HTTP : DELETE
     */
    @DeleteMapping("/{id}")
    public void SupprimerIdeeProjet(@PathVariable int id) {
        ideeProjetService.SupprimerIdeeProjet(id);
    }

}
