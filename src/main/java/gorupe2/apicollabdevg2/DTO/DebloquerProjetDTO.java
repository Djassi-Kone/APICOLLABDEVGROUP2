package gorupe2.apicollabdevg2.DTO;

public class DebloquerProjetDTO {
    private int id;
    private boolean visibilite;
    private int nbrCoins;

    public DebloquerProjetDTO() {
    }

    public DebloquerProjetDTO(int id, int nbrCoins, boolean visibilite) {
        this.id = id;
        this.nbrCoins = nbrCoins;
        this.visibilite = visibilite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVisibilite() {
        return visibilite;
    }

    public void setVisibilite(boolean visibilite) {
        this.visibilite = visibilite;
    }

    public int getNbrCoins() {
        return nbrCoins;
    }

    public void setNbrCoins(int nbrCoins) {
        this.nbrCoins = nbrCoins;
    }
}
