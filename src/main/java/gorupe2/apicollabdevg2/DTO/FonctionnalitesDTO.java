package gorupe2.apicollabdevg2.DTO;

public class FonctionnalitesDTO {
    private int id;
    private String pointFonctionnalite;
    private String statut;

    public FonctionnalitesDTO() {
    }

    public FonctionnalitesDTO(int id, String pointFonctionnalite, String statut) {
        this.id = id;
        this.pointFonctionnalite = pointFonctionnalite;
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPointFonctionnalite() {
        return pointFonctionnalite;
    }

    public void setPointFonctionnalite(String pointFonctionnalite) {
        this.pointFonctionnalite = pointFonctionnalite;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
