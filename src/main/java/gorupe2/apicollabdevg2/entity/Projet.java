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

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
    private List<Contributions> contributions;
}


