package gorupe2.apicollabdevg2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DebloquerProjet")
public class DebloquerProjet {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private boolean visibilite;
    private int nbrCoins;

    @ManyToOne
    @JoinColumn(name = "contibuteur_id",
            referencedColumnName = "id",
            nullable = false)
    private Contributeurs contributeurs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVisibilite() {
        return visibilite;
    }

    public void setVisibilite(boolean visibilite) {
        this.visibilite = visibilite;
    }

    public int getNbrCoins() {
        return nbrCoins;
    }

    public void setNbrCoins(int nbrCoins) {
        this.nbrCoins = nbrCoins;
    }

    public Contributeurs getContributeurs() {
        return contributeurs;
    }

    public void setContributeurs(Contributeurs contributeurs) {
        this.contributeurs = contributeurs;
    }
}
