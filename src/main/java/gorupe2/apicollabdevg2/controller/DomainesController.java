package gorupe2.apicollabdevg2.controller;

import gorupe2.apicollabdevg2.entity.Domaines;
import gorupe2.apicollabdevg2.service.DomaineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Domaines")
public class DomainesController {

        // Injection automatique du service qui contient la logique métier liée aux contributeurs
        @Autowired
        private DomaineService domainesService;

        /**
         * Méthode pour ajouter un contributeur
         * Reçoit les données d'un contributeur dans le corps de la requête en format JSON
         * Méthode HTTP : POST => utilisée pour créer une nouvelle ressource
         */
        @PostMapping
        public Domaines AjouterDomaines(@RequestBody Domaines domaines) {
        return domainesService.AjouterDomaines(domaines);
    }

        /**
         * Méthode pour récupérer la liste de tous les contributeurs
         * Méthode HTTP : GET => récupération d'une ressource
         */
        @GetMapping
        public List<Domaines> ListerDomaines() {
        return domainesService.ListerDomaines();
    }
        /**
         * Méthode pour récupérer un contributeur par son identifiant
         * @param id identifiant du contributeur
         * Méthode HTTP : GET avec paramètre dans l'URL
         */
        @GetMapping("/{id}")
        public Optional<Domaines> AfficherDomainesParId(@PathVariable int id) {
        return domainesService.AfficherDomainesParId(id);
    }

        /**
         * Méthode pour modifier un contributeur par son identifiant
         * @param id identifiant du contributeur
         * Méthode HTTP : PUT avec paramètre dans l'URL
         */
        @PutMapping("/{id}") // Correction : ici on utilise PUT pour mettre à jour une ressource existante
        public Domaines ModifierDomaines(@PathVariable int id, @RequestBody Domaines domaines) {
        return domainesService.ModifierDomaines(id, domaines);
    }

        /**  * Méthode pour supprimer un contributeur par son identifiant
         * Méthode HTTP : DELETE
         */
        @DeleteMapping("/{id}")
        public void SupprimerDomaines(@PathVariable int id) {
            domainesService.SupprimerDomaines(id);
    }


}
