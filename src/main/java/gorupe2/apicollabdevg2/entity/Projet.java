package gorupe2.apicollabdevg2.entity;

import gorupe2.apicollabdevg2.Enum.Niveau;
import gorupe2.apicollabdevg2.Enum.StatutProjet;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Projet")
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String titre;
    private boolean cahierCharge;
    private StatutProjet statutP;
    private Niveau niveau;
    private int nbrcoins;
    private String historique;

    @Size(min = 10, max = 500)
    private String description;

    @ManyToOne
    @JoinColumn(
            name="projet_id",
            referencedColumnName="id",
            nullable=false
    )
    private Gestionnaires gestionnaire;

    @OneToMany(mappedBy = "projet")
    private List<Contributeurs> contributeur;

    @OneToOne
    @JoinColumn(name = "ideeProjet_id",
            referencedColumnName = "id",
            nullable=false)
    private IdeeProjet ideeProjet;

    @OneToOne
    @JoinColumn(name = "domaine_id",
            referencedColumnName = "id",
            nullable=false)
    private Domaines domaines;

    @OneToMany(mappedBy = "projet")
    private List<Contributions> contributions;

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

    public boolean isCahierCharge() {
        return cahierCharge;
    }

    public void setCahierCharge(boolean cahierCharge) {
        this.cahierCharge = cahierCharge;
    }

    public StatutProjet getStatutP() {
        return statutP;
    }

    public void setStatutP(StatutProjet statutP) {
        this.statutP = statutP;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public int getNbrcoins() {
        return nbrcoins;
    }

    public void setNbrcoins(int nbrcoins) {
        this.nbrcoins = nbrcoins;
    }

    public String getHistorique() {
        return historique;
    }

    public void setHistorique(String historique) {
        this.historique = historique;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Gestionnaires getGestionnaire() {
        return gestionnaire;
    }

    public void setGestionnaire(Gestionnaires gestionnaire) {
        this.gestionnaire = gestionnaire;
    }

    public List<Contributeurs> getContributeur() {
        return contributeur;
    }

    public void setContributeur(List<Contributeurs> contributeur) {
        this.contributeur = contributeur;
    }

    public IdeeProjet getIdeeProjet() {
        return ideeProjet;
    }

    public void setIdeeProjet(IdeeProjet ideeProjet) {
        this.ideeProjet = ideeProjet;
    }

    public Domaines getDomaines() {
        return domaines;
    }

    public void setDomaines(Domaines domaines) {
        this.domaines = domaines;
    }

    public List<Contributions> getContributions() {
        return contributions;
    }

    public void setContributions(List<Contributions> contributions) {
        this.contributions = contributions;
    }
}


