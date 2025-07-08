package gorupe2.apicollabdevg2.DTO;

public class CoinsDTO {
    private int id;
    private int nbrCoins;

    public CoinsDTO() {
    }

    public CoinsDTO(int id, int nbrCoins) {
        this.id = id;
        this.nbrCoins = nbrCoins;
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
}
