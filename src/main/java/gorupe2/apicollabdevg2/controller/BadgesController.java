package gorupe2.apicollabdevg2.controller;


import gorupe2.apicollabdevg2.entity.Badges;
import gorupe2.apicollabdevg2.service.BadgesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/Badges")
public class BadgesController {


    // Injection automatique du service qui contient la logique métier liée aux contributeurs
    @Autowired
    private BadgesService badgesService;

    /**
     * Méthode pour ajouter un contributeur
     * Reçoit les données d'un contributeur dans le corps de la requête en format JSON
     * Méthode HTTP : POST => utilisée pour créer une nouvelle ressource
     */
    @PostMapping
    public Badges AjouterBadges(@RequestBody Badges badges) {
        return badgesService.AjouterBadges(badges);
    }

    @GetMapping
    public List<Badges> ListerBadges() {
        return badgesService.ListerBadges();
    }

    /**
     * Méthode pour récupérer un contributeur par son identifiant
     * @param id identifiant du contributeur
     * Méthode HTTP : GET avec paramètre dans l'URL
     */
    @GetMapping("/{id}")
    public Optional<Badges> AfficherBadgesParId(@PathVariable int id) {
        return badgesService.AfficherBadgesParId(id);
    }

    @PutMapping("/{id}") // Correction : ici on utilise PUT pour mettre à jour une ressource existante
    public Badges Modifier(@PathVariable int id, @RequestBody Badges badges) {
        return badgesService.ModifierBadges(id, badges);
    }

    /**
     * Méthode pour supprimer un contributeur par son identifiant
     * Méthode HTTP : DELETE
     */
    @DeleteMapping("/{id}")
    public void supprimerBadges(@PathVariable int id) {
        badgesService.SupprimerBadges(id);
    }
}
