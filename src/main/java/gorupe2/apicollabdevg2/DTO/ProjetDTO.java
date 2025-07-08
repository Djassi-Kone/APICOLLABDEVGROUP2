package gorupe2.apicollabdevg2.DTO;

public class ProjetDTO {
    private int id;
    private String titre;
    private String description;
    private boolean cahierCharge;
    private String statut;

    public ProjetDTO() {
    }

    public ProjetDTO(int id, String titre, String description, boolean cahierCharge, String statut) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.cahierCharge = cahierCharge;
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCahierCharge() {
        return cahierCharge;
    }

    public void setCahierCharge(boolean cahierCharge) {
        this.cahierCharge = cahierCharge;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
