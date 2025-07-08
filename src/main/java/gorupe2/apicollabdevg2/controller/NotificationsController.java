package gorupe2.apicollabdevg2.controller;


import gorupe2.apicollabdevg2.entity.Gestionnaires;
import gorupe2.apicollabdevg2.entity.Notifications;
import gorupe2.apicollabdevg2.service.GestionnairesService;
import gorupe2.apicollabdevg2.service.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Notifications")
public class NotificationsController {


        // Injection automatique du service qui contient la logique métier liée aux contributeurs
        @Autowired
        private NotificationsService notificationsService;

        /**
         * Méthode pour ajouter un contributeur
         * Reçoit les données d'un contributeur dans le corps de la requête en format JSON
         * Méthode HTTP : POST => utilisée pour créer une nouvelle ressource
         */
        @PostMapping
        public Notifications AjouterNotifications(@RequestBody Notifications notifications) {
        return notificationsService.AjouterNotifications(notifications);
    }

        /**
         * Méthode pour récupérer la liste de tous les contributeurs
         * Méthode HTTP : GET => récupération d'une ressource
         */
        @GetMapping
        public List<Notifications> ListerNotifications() {
        return notificationsService.ListerNotifications();
    }
        /**
         * Méthode pour récupérer un contributeur par son identifiant
         * @param id identifiant du contributeur
         * Méthode HTTP : GET avec paramètre dans l'URL
         */
        @GetMapping("/{id}")
        public Optional<Notifications> AfficherNotificationsParId(@PathVariable int id) {
        return notificationsService.AfficherNotificationsParId(id);
    }

        /**
         * Méthode pour modifier un contributeur par son identifiant
         * @param id identifiant du contributeur
         * Méthode HTTP : PUT avec paramètre dans l'URL
         */
        @PutMapping("/{id}") // Correction : ici on utilise PUT pour mettre à jour une ressource existante
        public Notifications ModifierNotifications(@PathVariable int id, @RequestBody Notifications notifications) {
        return notificationsService.ModifierNotifications(id, notifications);
    }

        /**  * Méthode pour supprimer un contributeur par son identifiant
         * Méthode HTTP : DELETE
         */
        @DeleteMapping("/{id}")
        public void SupprimerNotifications(@PathVariable int id) {
            notificationsService.SupprimerNotifications(id);
    }

    }

