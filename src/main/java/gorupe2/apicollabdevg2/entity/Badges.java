package gorupe2.apicollabdevg2.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Badges")
public class Badges {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nomBadge;
    private String description;
    private int nombreBadge;
    private String image;

    @ManyToOne
    @JoinColumn(name = "contributeur_id")  // nom de colonne au choix
    private Contributeurs contributeurs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomBadge() {
        return nomBadge;
    }

    public void setNomBadge(String nomBadge) {
        this.nomBadge = nomBadge;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNombreBadge() {
        return nombreBadge;
    }

    public void setNombreBadge(int nombreBadge) {
        this.nombreBadge = nombreBadge;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
