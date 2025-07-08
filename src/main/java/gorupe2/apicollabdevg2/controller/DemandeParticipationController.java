package gorupe2.apicollabdevg2.controller;

import gorupe2.apicollabdevg2.entity.DebloquerProjet;
import gorupe2.apicollabdevg2.entity.DemandeParticipation;
import gorupe2.apicollabdevg2.service.DebloquerProjetService;
import gorupe2.apicollabdevg2.service.DemandeParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/DemandeParticipation")
public class DemandeParticipationController {


    // Injection automatique du service qui contient la logique métier liée aux contributeurs
    @Autowired
    private DemandeParticipationService demandeParticipationService;

    /**
     * Méthode pour ajouter un contributeur
     * Reçoit les données d'un contributeur dans le corps de la requête en format JSON
     * Méthode HTTP : POST => utilisée pour créer une nouvelle ressource
     */
    @PostMapping
    public DemandeParticipation AjouterDemandeParticipation(@RequestBody DemandeParticipation demandeParticipation) {
        return demandeParticipationService.AjouterDemandeParticipation(demandeParticipation);
    }

    /**
     * Méthode pour récupérer la liste de tous les contributeurs
     * Méthode HTTP : GET => récupération d'une ressource
     */
    @GetMapping
    public List<DemandeParticipation> ListerDemandeParticipation() {
        return demandeParticipationService.ListerDemandeParticipation();
    }
    /**
     * Méthode pour récupérer un contributeur par son identifiant
     * @param id identifiant du contributeur
     * Méthode HTTP : GET avec paramètre dans l'URL
     */
    @GetMapping("/{id}")
    public Optional<DemandeParticipation> AfficherDemandeParticipationParId(@PathVariable int id) {
        return demandeParticipationService.AfficherDemandeParticipationParId(id);
    }

    /**
     * Méthode pour modifier un contributeur par son identifiant
     * @param id identifiant du contributeur
     * Méthode HTTP : PUT avec paramètre dans l'URL
     */
    @PutMapping("/{id}") // Correction : ici on utilise PUT pour mettre à jour une ressource existante
    public DemandeParticipation Modifier(@PathVariable int id, @RequestBody DemandeParticipation demandeParticipation) {
        return demandeParticipationService.ModifierDemandeParticipation(id, demandeParticipation);
    }

    /**  * Méthode pour supprimer un contributeur par son identifiant
     * Méthode HTTP : DELETE
     */
    @DeleteMapping("/{id}")
    public void SupprimerDemandeParticipation(@PathVariable int id) {
        demandeParticipationService.SupprimerDemandeParticipation(id);
    }

}
