package gorupe2.apicollabdevg2.DTO;

public class CommentairesDTO {
    private int id;
    private String contenu;

    public CommentairesDTO() {
    }
    public CommentairesDTO(int id, String contenu) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getContenu() {
        return contenu;
    }
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}
