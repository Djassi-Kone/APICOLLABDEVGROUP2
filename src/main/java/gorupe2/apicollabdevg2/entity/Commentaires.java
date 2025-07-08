package gorupe2.apicollabdevg2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Commentaires")
public class Commentaires {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String contenu;

    @ManyToOne
    @JoinColumn(
            name="contributeur_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Contributeurs contributeurs;

    @OneToOne
    @JoinColumn(
            name="projet_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Projet projet;


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

    public Contributeurs getContributeurs() {
        return contributeurs;
    }

    public void setContributeurs(Contributeurs contributeurs) {
        this.contributeurs = contributeurs;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public void setDateCreation(LocalDateTime now) {
    }

    public void setContributeur(Contributeurs contributeur) {
    }
}
