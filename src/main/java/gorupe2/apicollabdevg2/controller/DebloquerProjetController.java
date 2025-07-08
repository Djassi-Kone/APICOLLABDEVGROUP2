package gorupe2.apicollabdevg2.controller;

import gorupe2.apicollabdevg2.entity.Contributions;
import gorupe2.apicollabdevg2.entity.DebloquerProjet;
import gorupe2.apicollabdevg2.service.ContributionsService;
import gorupe2.apicollabdevg2.service.DebloquerProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/DebloquerProjet")
public class DebloquerProjetController {

    // Injection automatique du service qui contient la logique métier liée aux contributeurs
    @Autowired
    private  DebloquerProjetService debloquerProjetService;

    /**
     * Méthode pour ajouter un contributeur
     * Reçoit les données d'un contributeur dans le corps de la requête en format JSON
     * Méthode HTTP : POST => utilisée pour créer une nouvelle ressource
     */
    @PostMapping
    public DebloquerProjet AjouterDebloquerProjet(@RequestBody DebloquerProjet debloquerProjet) {
        return debloquerProjetService.AjouterDebloquerProjet(debloquerProjet);
    }

    /**
     * Méthode pour récupérer la liste de tous les contributeurs
     * Méthode HTTP : GET => récupération d'une ressource
     */
    @GetMapping
    public List<DebloquerProjet> ListerDebloquerProjet() {
        return debloquerProjetService.ListerDebloquerProjet();
    }
    /**
     * Méthode pour récupérer un contributeur par son identifiant
     * @param id identifiant du contributeur
     * Méthode HTTP : GET avec paramètre dans l'URL
     */
    @GetMapping("/{id}")
    public Optional<DebloquerProjet> AfficherDebloquerProjetParId(@PathVariable int id) {
        return debloquerProjetService.AfficherDebloquerProjetParId(id);
    }

    /**
     * Méthode pour modifier un contributeur par son identifiant
     * @param id identifiant du contributeur
     * Méthode HTTP : PUT avec paramètre dans l'URL
     */
    @PutMapping("/{id}") // Correction : ici on utilise PUT pour mettre à jour une ressource existante
    public DebloquerProjet ModifierDebloquerProjet(@PathVariable int id, @RequestBody DebloquerProjet debloquerProjet) {
        return debloquerProjetService.ModifierDebloquerProjet(id, debloquerProjet);
    }

    /**  * Méthode pour supprimer un contributeur par son identifiant
     * Méthode HTTP : DELETE
     */
    @DeleteMapping("/{id}")
    public void SupprimerDebloquerProjet(@PathVariable int id) {
        debloquerProjetService.SupprimerDebloquerProjet(id);
    }
}
