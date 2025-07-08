package gorupe2.apicollabdevg2.DTO;

import java.time.LocalDateTime;

public class ContributionsDTO {
    private int id;
    private int nbrCoins;
    private LocalDateTime dateContribution;
    private String statut;
    private String contenu;

    public ContributionsDTO() {
    }

    public ContributionsDTO(int id,
                            int nbrCoins,
                            LocalDateTime dateContribution, String statut, String contenu) {
        this.id = id;
        this.nbrCoins = nbrCoins;
        this.dateContribution = dateContribution;
        this.statut = statut;
        this.contenu = contenu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbrCoins() {
        return nbrCoins;
    }

    public void setNbrCoins(int nbrCoins) {
        this.nbrCoins = nbrCoins;
    }

    public LocalDateTime getDateContribution() {
        return dateContribution;
    }

    public void setDateContribution(LocalDateTime dateContribution) {
        this.dateContribution = dateContribution;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}
