package gorupe2.apicollabdevg2.controller;

import gorupe2.apicollabdevg2.entity.Coins;
import gorupe2.apicollabdevg2.entity.Commentaires;
import gorupe2.apicollabdevg2.service.CoinsService;
import gorupe2.apicollabdevg2.service.CommentairesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Commentaire")
public class CommentairesController {

    // Injection automatique du service qui contient la logique métier liée aux contributeurs
    @Autowired
    private CommentairesService commentaireService;

    /**
     * Méthode pour ajouter un contributeur
     * Reçoit les données d'un contributeur dans le corps de la requête en format JSON
     * Méthode HTTP : POST => utilisée pour créer une nouvelle ressource
     */
    @PostMapping
    public Commentaires AjouterCommentaires(@RequestBody Commentaires commentaire) {
        return commentaireService.AjouterCommentaires(commentaire);
    }

    @GetMapping
    public List<Commentaires> ListerCommentaires() {
        return commentaireService.ListerCommentaires();
    }

    /**
     * Méthode pour récupérer un contributeur par son identifiant
     * @param id identifiant du contributeur
     * Méthode HTTP : GET avec paramètre dans l'URL
     */
    @GetMapping("/{id}")
    public Optional<Commentaires> AfficherCommentairesParId(@PathVariable int id) {
        return commentaireService.AfficherCommentairesParId(id);
    }

    @PutMapping("/{id}") // Correction : ici on utilise PUT pour mettre à jour une ressource existante
    public Commentaires Modifier(@PathVariable int id, @RequestBody Commentaires commentaire) {
        return commentaireService.ModifierCommentaire(id, commentaire);
    }

    /**
     * Méthode pour supprimer un contributeur par son identifiant
     * Méthode HTTP : DELETE
     */
    @DeleteMapping("/{id}")
    public void supprimerCoins(@PathVariable int id) {
        commentaireService.SupprimerCommentaires(id);
    }
}
