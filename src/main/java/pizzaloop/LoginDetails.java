package pizzaloop;


import javax.persistence.*;

@Entity
@Table(name= "login_details")
public class LoginDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "loginId")
    private Integer loginId;

    @Column(name = "email")
    private String email;

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
