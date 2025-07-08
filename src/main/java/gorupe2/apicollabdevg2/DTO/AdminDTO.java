package gorupe2.apicollabdevg2.DTO;

public class AdminDTO {
    private int id;
    private String email;
    private String password;

    public AdminDTO() {
    }
    public AdminDTO(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    }

}
