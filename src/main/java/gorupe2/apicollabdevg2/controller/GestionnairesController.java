package gorupe2.apicollabdevg2.controller;

import gorupe2.apicollabdevg2.entity.Fonctionnalites;
import gorupe2.apicollabdevg2.entity.Gestionnaires;
import gorupe2.apicollabdevg2.service.FonctionnalitesService;
import gorupe2.apicollabdevg2.service.GestionnairesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Gestionnaires")
public class GestionnairesController {



    // Injection automatique du service qui contient la logique métier liée aux contributeurs
    @Autowired
    private GestionnairesService gestionnairesService;

    /**
     * Méthode pour ajouter un contributeur
     * Reçoit les données d'un contributeur dans le corps de la requête en format JSON
     * Méthode HTTP : POST => utilisée pour créer une nouvelle ressource
     */
    @PostMapping
    public Gestionnaires AjouterGestionnaires(@RequestBody Gestionnaires gestionnaires) {
        return gestionnairesService.AjouterGestionnaires(gestionnaires);
    }

    /**
     * Méthode pour récupérer la liste de tous les contributeurs
     * Méthode HTTP : GET => récupération d'une ressource
     */
    @GetMapping
    public List<Gestionnaires> ListerGestionnaires() {
        return gestionnairesService.ListerGestionnaires();
    }
    /**
     * Méthode pour récupérer un contributeur par son identifiant
     * @param id identifiant du contributeur
     * Méthode HTTP : GET avec paramètre dans l'URL
     */
    @GetMapping("/{id}")
    public Optional<Gestionnaires> AfficherGestionnairesParId(@PathVariable int id) {
        return gestionnairesService.AfficherGestionnairesParId(id);
    }

    /**
     * Méthode pour modifier un contributeur par son identifiant
     * @param id identifiant du contributeur
     * Méthode HTTP : PUT avec paramètre dans l'URL
     */
    @PutMapping("/{id}") // Correction : ici on utilise PUT pour mettre à jour une ressource existante
    public Gestionnaires ModifierGestionnaires(@PathVariable int id, @RequestBody Gestionnaires gestionnaires) {
        return gestionnairesService.ModifierGestionnaires(id, gestionnaires);
    }

    /**  * Méthode pour supprimer un contributeur par son identifiant
     * Méthode HTTP : DELETE
     */
    @DeleteMapping("/{id}")
    public void SupprimerGestionnaires(@PathVariable int id) {
        gestionnairesService.SupprimerGestionnaires(id);
    }

}
