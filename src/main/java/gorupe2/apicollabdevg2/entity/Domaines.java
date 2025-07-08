package gorupe2.apicollabdevg2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Domaines")
public class Domaines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String titre;

    @Size(min = 10, max = 500)
    private String description;

    @OneToMany(mappedBy = "domaines")
    private List<IdeeProjet> ideeProjet;

    @OneToOne
    private Projet projet;

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

    public @Size(min = 10, max = 500) String getDescription() {
        return description;
    }

    public void setDescription(@Size(min = 10, max = 500) String description) {
        this.description = description;
    }

    public List<IdeeProjet> getIdeeProjet() {
        return ideeProjet;
    }

    public void setIdeeProjet(List<IdeeProjet> ideeProjet) {
        this.ideeProjet = ideeProjet;
    }
}
