package gorupe2.apicollabdevg2.DTO;

import java.time.LocalDateTime;

public class NotificationsDTO {
        private int id;
        private String description;
        private LocalDateTime dateCreation;
        private String typeNotification;

    public NotificationsDTO() {
    }

    public NotificationsDTO(int id, String description, LocalDateTime dateCreation, String typeNotification) {
        this.id = id;
        this.description = description;
        this.dateCreation = dateCreation;
        this.typeNotification = typeNotification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeNotification() {
        return typeNotification;
    }

    public void setTypeNotification(String typeNotification) {
        this.typeNotification = typeNotification;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
