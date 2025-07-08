package gorupe2.apicollabdevg2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Envoyer")
public class Envoyer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime dateEnvoi;

    @OneToOne
    @JoinColumn(
            name="contributeur_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Contributeurs contributeurs;

}
