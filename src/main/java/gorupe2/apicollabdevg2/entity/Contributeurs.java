package gorupe2.apicollabdevg2.entity;

import gorupe2.apicollabdevg2.Enum.Niveau;
import gorupe2.apicollabdevg2.Enum.Profil;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Contributeurs")
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

    @ManyToOne
    @JoinColumn(name="projet_id", referencedColumnName = "id", nullable = false)
    private Projet projet;

    @OneToMany(mappedBy = "contributeurs")
    private List<Notifications> notifications;

    @OneToMany(mappedBy = "contributeurs")
    private List<Contributions> contributions;

    @OneToMany(mappedBy = "contributeurs")
    private List<DebloquerProjet> debloquerProjet;

    @OneToMany(mappedBy = "contributeurs")
    private List<IdeeProjet> ideeProjet;

    @OneToMany(mappedBy = "contributeurs")
    private List<Badges> badges;

    @OneToMany(mappedBy = "contributeurs")
    private List<Coins> coins;

    @OneToMany(mappedBy = "contributeurs")
    private List<Commentaires> commentaires;

    @OneToMany(mappedBy = "contributeurs")
    private List<Fonctionnalites> fonctionnalites;

    @OneToMany(mappedBy = "contributeurs")
    private List<Projet> projet;









    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public List<Contributions> getContributions() {
        return contributions;
    }

    public void setContributions(List<Contributions> contributions) {
        this.contributions = contributions;
    }

    public List<Notifications> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notifications> notifications) {
        this.notifications = notifications;
    }
}

