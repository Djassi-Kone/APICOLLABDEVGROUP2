package gorupe2.apicollabdevg2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Coins")
public class Coins {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private int nbrCoins;

    @ManyToOne
    @JoinColumn(name="contributeur_id", referencedColumnName = "id", nullable = false)
    private Contributeurs contributeurs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getMontant() {
    }
}
