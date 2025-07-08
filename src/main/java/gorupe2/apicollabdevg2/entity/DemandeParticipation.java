package gorupe2.apicollabdevg2.entity;

import gorupe2.apicollabdevg2.Enum.StatutDemande;
import gorupe2.apicollabdevg2.Enum.TypeDemande;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "DemandeParticipation")
public class DemandeParticipation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    @Enumerated(EnumType.STRING)
    private StatutDemande statutD;
    @Enumerated(EnumType.STRING)
    private TypeDemande typeD;
    private LocalDateTime dateDemande;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatutDemande getStatutD() {
        return statutD;
    }

    public void setStatutD(StatutDemande statutD) {
        this.statutD = statutD;
    }

    public TypeDemande getTypeD() {
        return typeD;
    }

    public void setTypeD(TypeDemande typeD) {
        this.typeD = typeD;
    }

    public LocalDateTime getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(LocalDateTime dateDemande) {
        this.dateDemande = dateDemande;
    }
}

