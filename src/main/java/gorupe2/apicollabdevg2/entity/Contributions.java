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
    private Long idContribution;

    private String titre;

    private String contenu;

    private String type; // Exemple : "code", "design", "idée", etc.

    private LocalDateTime dateSoumission;

    @ManyToOne
    @JoinColumn(name = "id_projet", nullable = true)
    private Projet projet;

    @ManyToOne
    @JoinColumn(name = "id_contributeur", nullable = true)
    private Contributeurs contributeur;
}

