package gorupe2.apicollabdevg2.entity;

import gorupe2.apicollabdevg2.Enum.Niveau;
import gorupe2.apicollabdevg2.Enum.Profil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Contributeurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Profil profil;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;

        @OneToMany(mappedBy = "contributeurs")
        private List<Notifications> notifications;

    @OneToMany(mappedBy = "contributeur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contributions> contributions;

        @OneToMany(mappedBy = "contributeurs")
        private List<DebloquerProjet> debloquerProjet;

}

