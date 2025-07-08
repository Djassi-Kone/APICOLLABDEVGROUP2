package gorupe2.apicollabdevg2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "IdeeProjet")
public class IdeeProjet {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private String description;
    private String niveau;
    private LocalDateTime dateCreation;

    @OneToOne
    @JoinColumn(
            name="contributeur_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Contributeurs contributeurs;
    @ManyToOne
    @JoinColumn(
            name="domaine_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Domaines domaines;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Contributeurs getContributeurs() {
        return contributeurs;
    }

    public void setContributeurs(Contributeurs contributeurs) {
        this.contributeurs = contributeurs;
    }
}
