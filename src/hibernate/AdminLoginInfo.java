package hibernate;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "adminLoginInfo")
public class AdminLoginInfo implements Serializable {

    private static final long serialVersionUID = -8672544757621103828L;

    @Column
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id_admin;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    public AdminLoginInfo() {
    }

    public AdminLoginInfo(String login, String password) {
        this.login = login;
        this.password = password;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
