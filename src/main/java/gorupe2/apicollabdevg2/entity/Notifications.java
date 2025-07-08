package gorupe2.apicollabdevg2.entity;

import gorupe2.apicollabdevg2.Enum.TypeNotification;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Notifications")
public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String contenu;
    private LocalDateTime DateCreation;
    private TypeNotification typeNotif;

    @ManyToOne
    @JoinColumn(
            name="contributeur_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Contributeurs contributeurs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public LocalDateTime getDateCreation() {
        return DateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        DateCreation = dateCreation;
    }

    public TypeNotification getTypeNotif() {
        return typeNotif;
    }

    public void setTypeNotif(TypeNotification typeNotif) {
        this.typeNotif = typeNotif;
    }

    public Contributeurs getContributeurs() {
        return contributeurs;
    }

    public void setContributeurs(Contributeurs contributeurs) {
        this.contributeurs = contributeurs;
    }
}
