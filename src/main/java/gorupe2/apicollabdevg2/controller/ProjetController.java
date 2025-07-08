package gorupe2.apicollabdevg2.controller;


import gorupe2.apicollabdevg2.entity.Projet;
import gorupe2.apicollabdevg2.service.ProjetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Projet")
public class ProjetController {


        // Injection automatique du service qui contient la logique métier liée aux contributeurs
        @Autowired
        private ProjetsService projetService;

        /**
         * Méthode pour ajouter un contributeur
         * Reçoit les données d'un contributeur dans le corps de la requête en format JSON
         * Méthode HTTP : POST => utilisée pour créer une nouvelle ressource
         */
        @PostMapping
        public Projet AjouterProjet(@RequestBody Projet projet) {
        return projetService.AjouterProjet(projet);
    }

        /**
         * Méthode pour récupérer la liste de tous les contributeurs
         * Méthode HTTP : GET => récupération d'une ressource
         */
        @GetMapping
        public List<Projet> ListerProjet() {
        return projetService.ListerProjet();
    }
        /**
         * Méthode pour récupérer un contributeur par son identifiant
         * @param id identifiant du contributeur
         * Méthode HTTP : GET avec paramètre dans l'URL
         */
        @GetMapping("/{id}")
        public Optional<Projet> AfficherProjetParId(@PathVariable int id) {
        return projetService.AfficherProjetParId(id);
    }

        /**
         * Méthode pour modifier un contributeur par son identifiant
         * @param id identifiant du contributeur
         * Méthode HTTP : PUT avec paramètre dans l'URL
         */
        @PutMapping("/{id}") // Correction : ici on utilise PUT pour mettre à jour une ressource existante
        public Projet ModifierProjet(@PathVariable int id, @RequestBody Projet projet) {
        return projetService.ModifierProjet(id, projet);
    }

        /**  * Méthode pour supprimer un contributeur par son identifiant
         * Méthode HTTP : DELETE
         */
        @DeleteMapping("/{id}")
        public void SupprimerProjet(@PathVariable int id) {
            projetService.SupprimerProjet(id);
    }


}
