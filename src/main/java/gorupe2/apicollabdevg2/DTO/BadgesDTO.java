package gorupe2.apicollabdevg2.DTO;

public class BadgesDTO {

    private int id;
    private String nomBadge;
    private String description;
    private int nombreBadge;
    private String image;

    public BadgesDTO() {

    }
    public BadgesDTO(int id,
                     String nomBadge,
                     String description,
                     int nombreBadge,
                     String image) {
        this.id = id;
        this.nomBadge = nomBadge;
        this.description = description;
        this.nombreBadge = nombreBadge;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomBadge() {
        return nomBadge;
    }

    public void setNomBadge(String nomBadge) {
        this.nomBadge = nomBadge;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNombreBadge() {
        return nombreBadge;
    }

    public void setNombreBadge(int nombreBadge) {
        this.nombreBadge = nombreBadge;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
