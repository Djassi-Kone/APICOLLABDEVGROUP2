package gorupe2.apicollabdevg2.controller;

import gorupe2.apicollabdevg2.entity.Domaines;
import gorupe2.apicollabdevg2.entity.Fonctionnalites;
import gorupe2.apicollabdevg2.service.DomaineService;
import gorupe2.apicollabdevg2.service.FonctionnalitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Fonctionnalites")
public class FonctionnalitesController {


    // Injection automatique du service qui contient la logique métier liée aux contributeurs
    @Autowired
    private FonctionnalitesService fonctionnalitesService;

    /**
     * Méthode pour ajouter un contributeur
     * Reçoit les données d'un contributeur dans le corps de la requête en format JSON
     * Méthode HTTP : POST => utilisée pour créer une nouvelle ressource
     */
    @PostMapping
    public Fonctionnalites AjouterFonctionnalites(@RequestBody Fonctionnalites fonctionnalites) {
        return fonctionnalitesService.AjouterFonctionnalites(fonctionnalites);
    }

    /**
     * Méthode pour récupérer la liste de tous les contributeurs
     * Méthode HTTP : GET => récupération d'une ressource
     */
    @GetMapping
    public List<Fonctionnalites> ListerFonctionnalites() {
        return fonctionnalitesService.ListerFonctionnalites();
    }
    /**
     * Méthode pour récupérer un contributeur par son identifiant
     * @param id identifiant du contributeur
     * Méthode HTTP : GET avec paramètre dans l'URL
     */
    @GetMapping("/{id}")
    public Optional<Fonctionnalites> AfficherFonctionnalitesParId(@PathVariable int id) {
        return fonctionnalitesService.AfficherFonctionnalitesParId(id);
    }

    /**
     * Méthode pour modifier un contributeur par son identifiant
     * @param id identifiant du contributeur
     * Méthode HTTP : PUT avec paramètre dans l'URL
     */
    @PutMapping("/{id}") // Correction : ici on utilise PUT pour mettre à jour une ressource existante
    public Fonctionnalites ModifierFonctionnalites(@PathVariable int id, @RequestBody Fonctionnalites fonctionnalites) {
        return fonctionnalitesService.ModifierFonctionnalites(id, fonctionnalites);
    }

    /**  * Méthode pour supprimer un contributeur par son identifiant
     * Méthode HTTP : DELETE
     */
    @DeleteMapping("/{id}")
    public void SupprimerFonctionnalites(@PathVariable int id) {
        fonctionnalitesService.SupprimerFonctionnalites(id);
    }
}
