package gorupe2.apicollabdevg2.controller;

import gorupe2.apicollabdevg2.entity.Badges;
import gorupe2.apicollabdevg2.entity.Coins;
import gorupe2.apicollabdevg2.service.BadgesService;
import gorupe2.apicollabdevg2.service.CoinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/Coins")
public class CoinsController {

    // Injection automatique du service qui contient la logique métier liée aux contributeurs
    @Autowired
    private CoinsService coinsService;

    /**
     * Méthode pour ajouter un contributeur
     * Reçoit les données d'un contributeur dans le corps de la requête en format JSON
     * Méthode HTTP : POST => utilisée pour créer une nouvelle ressource
     */
    @PostMapping
    public Coins AjouterCoins(@RequestBody Coins coins) {
        return coinsService.AjouterCoins(coins);
    }

    @GetMapping
    public List<Coins> ListerCoins() {
        return coinsService.ListerCoins();
    }

    /**
     * Méthode pour récupérer un contributeur par son identifiant
     * @param id identifiant du contributeur
     * Méthode HTTP : GET avec paramètre dans l'URL
     */
    @GetMapping("/{id}")
    public Optional<Coins> AfficherCoinsParId(@PathVariable int id) {
        return coinsService.AfficherCoinsParId(id);
    }

    @PutMapping("/{id}") // Correction : ici on utilise PUT pour mettre à jour une ressource existante
    public Coins Modifier(@PathVariable int id, @RequestBody Coins coins) {
        return coinsService.ModifierCoins(id, coins);
    }

    /**
     * Méthode pour supprimer un contributeur par son identifiant
     * Méthode HTTP : DELETE
     */
    @DeleteMapping("/{id}")
    public void supprimerCoins(@PathVariable int id) {
        coinsService.SupprimerCoins(id);
    }
}
