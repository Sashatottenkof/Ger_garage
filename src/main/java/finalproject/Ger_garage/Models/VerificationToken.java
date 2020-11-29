package finalproject.Ger_garage.Models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "VERIFICATION_TOKEN")
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private String token;

    private Timestamp expiryDate;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    public VerificationToken() {

    }

    /**
     * We need only token and user for Constructor
     * @param user
     * @param token
     */
    public VerificationToken( User user, String token) {
        this.token = token;
        this.user = user;
    }



    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
