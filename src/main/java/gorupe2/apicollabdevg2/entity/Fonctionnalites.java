package gorupe2.apicollabdevg2.entity;

import gorupe2.apicollabdevg2.Enum.StatutProjet;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Fonctionnamites")
public class Fonctionnalites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int pointFonctionnalite;
    @Enumerated(EnumType.STRING)
    private StatutProjet statutP;

    @OneToOne
    @JoinColumn(name = "projet_id", referencedColumnName = "id", nullable = false)
    private Projet projet;
    @ManyToOne
    @JoinColumn(name = "gestionnaire_id", referencedColumnName = "id", nullable = false)
    private Gestionnaires gestionnaires;

    @ManyToOne
    @JoinColumn(name = "contributeur_id")  // Nom de la colonne de jointure
    private Contributeurs contributeurs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPointFonctionnalite() {
        return pointFonctionnalite;
    }

    public void setPointFonctionnalite(int pointFonctionnalite) {
        this.pointFonctionnalite = pointFonctionnalite;
    }

    public StatutProjet getStatutP() {
        return statutP;
    }

    public void setStatutP(StatutProjet statutP) {
        this.statutP = statutP;
    }

    public Gestionnaires getGestionnaires() {
        return gestionnaires;
    }

    public void setGestionnaires(Gestionnaires gestionnaires) {
        this.gestionnaires = gestionnaires;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

}

