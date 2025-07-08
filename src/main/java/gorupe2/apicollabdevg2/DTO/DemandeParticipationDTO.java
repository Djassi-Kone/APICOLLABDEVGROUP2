package gorupe2.apicollabdevg2.DTO;

public class DemandeParticipationDTO {
    private int id;
    private String statut;
    private String description;
    private String typeDemande;

    public DemandeParticipationDTO() {
    }
    public DemandeParticipationDTO(String statut, String description, String typeDemande) {
        this.statut = statut;
        this.description = description;
        this.typeDemande = typeDemande;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeDemande() {
        return typeDemande;
    }

    public void setTypeDemande(String typeDemande) {
        this.typeDemande = typeDemande;
    }
}
