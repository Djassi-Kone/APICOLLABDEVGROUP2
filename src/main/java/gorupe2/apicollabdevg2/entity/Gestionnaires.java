package gorupe2.apicollabdevg2.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Gestionnaires")
public class Gestionnaires extends Contributeurs{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "gestionnaires")
    private List<Projet> projet;

    @OneToMany(mappedBy = "gestionnaires")
    private List<Fonctionnalites> fonctionnalites;


    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }



    public void setProjet(List<Projet> projet) {
        this.projet = projet;
    }

    public List<Fonctionnalites> getFonctionnalites() {
        return fonctionnalites;
    }

    public void setFonctionnalites(List<Fonctionnalites> fonctionnalites) {
        this.fonctionnalites = fonctionnalites;
    }
}

