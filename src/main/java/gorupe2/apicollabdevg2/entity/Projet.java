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
    @Column(name = "projet_id") // Explicitement nommer la colonne ID
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

    // Correction des relations pour éviter la duplication de colonne
    @ManyToOne
    @JoinColumn(name="gestionnaire_id", referencedColumnName="id", nullable=false)
    private Gestionnaires gestionnaire;

    @ManyToOne
    @JoinColumn(name="contributeur_id", referencedColumnName = "id", nullable = false)
    private Contributeurs contributeur;

    @OneToOne
    @JoinColumn(name = "ideeProjet_id", referencedColumnName = "id", nullable=false)
    private IdeeProjet ideeProjet;

    @OneToOne
    @JoinColumn(name = "domaine_id", referencedColumnName = "id", nullable=false)
    private Domaines domaine;

    @OneToMany(mappedBy = "projet")
    private List<Contributions> contributions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank String getTitre() {
        return titre;
    }

    public void setTitre(@NotBlank String titre) {
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

    public @Size(min = 10, max = 500) String getDescription() {
        return description;
    }

    public void setDescription(@Size(min = 10, max = 500) String description) {
        this.description = description;
    }

    public Gestionnaires getGestionnaire() {
        return gestionnaire;
    }

    public void setGestionnaire(Gestionnaires gestionnaire) {
        this.gestionnaire = gestionnaire;
    }

    public Contributeurs getContributeur() {
        return contributeur;
    }

    public void setContributeur(Contributeurs contributeur) {
        this.contributeur = contributeur;
    }

    public IdeeProjet getIdeeProjet() {
        return ideeProjet;
    }

    public void setIdeeProjet(IdeeProjet ideeProjet) {
        this.ideeProjet = ideeProjet;
    }

    public Domaines getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaines domaine) {
        this.domaine = domaine;
    }

    public List<Contributions> getContributions() {
        return contributions;
    }

    public void setContributions(List<Contributions> contributions) {
        this.contributions = contributions;
    }

    public Object getMontantCollecte() {
    }

    public void setMontantCollecte(double v) {
    }
}