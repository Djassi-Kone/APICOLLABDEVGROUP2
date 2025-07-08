package gorupe2.apicollabdevg2.service;

import gorupe2.apicollabdevg2.entity.IdeeProjet;
import gorupe2.apicollabdevg2.entity.Notifications;
import gorupe2.apicollabdevg2.repository.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationsService {

    @Autowired
    private NotificationsRepository notificationsRepository;

    public Notifications AjouterNotifications(Notifications notifications) {
        return notificationsRepository.save(notifications);
    }

    public List<Notifications> ListerNotifications() {
        return notificationsRepository.findAll();
    }

    public Optional<Notifications> AfficherNotificationsParId(int id) {
        return notificationsRepository.findById(id);
    }

    public Notifications ModifierNotifications(int id, Notifications notifications) {
        notifications.setId(id);
        return notificationsRepository.save(notifications);
    }

    public void SupprimerNotifications(int id) {

        notificationsRepository.deleteById(id);
    }

    public Notifications envoyerNotification(Gestionnaires destinataire, String message, String type) {
        Notifications notif = new Notifications();
        notif.setContributeurs(destinataire);
        notif.setContenu(message);
        notif.setTypeNotif(type);
        notif.setDateCreation(LocalDateTime.now());
        return notificationsRepository.save(notif)
    }

    public List<Notifications> getNotificationsUtilisateur(Contributeurs contributeurs)  {
        return notificationsRepository.findByDestinataire(contributeurs);
    }
}
