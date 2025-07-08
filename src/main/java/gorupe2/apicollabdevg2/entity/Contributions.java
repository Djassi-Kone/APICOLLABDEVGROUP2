package gorupe2.apicollabdevg2.entity;

import gorupe2.apicollabdevg2.Enum.StatutProjet;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Contributions")
public class Contributions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id_contribution ;
    private int nbrCoins;
    private String contenu;
    @Enumerated(EnumType.STRING)
    private StatutProjet statutP;
    private LocalDateTime DateContribution;
    //private String setTypeContribution;


    @ManyToOne
    @JoinColumn(name = "contibuteur_id", referencedColumnName = "id", nullable = false)
    private Contributeurs contributeurs;

    @ManyToOne
    @JoinColumn(name = "projet_id", referencedColumnName = "id", nullable = false)
    private Projet projet;


    public int getId_contribution() {
        return id_contribution;
    }

    public void setId_contribution(int id_contribution) {
        this.id_contribution = id_contribution;
    }

    public int getNbrCoins() {
        return nbrCoins;
    }

    public void setNbrCoins(int nbrCoins) {
        this.nbrCoins = nbrCoins;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public StatutProjet getStatutP() {
        return statutP;
    }

    public void setStatutP(StatutProjet statutP) {
        this.statutP = statutP;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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

    public void setDescription(String description) {
    }

    public void setContributeur(Contributeurs contributeur) {
    }

    public void setTypeContribution(String typeContribution) {
    }
}

