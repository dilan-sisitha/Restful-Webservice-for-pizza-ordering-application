package pizzaloop;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CashPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer DiliveryId;
    private String userName;
    private String address;
    private String telephone;
    private String comment;

    public Integer getDiliveryId() {
        return DiliveryId;
    }

    public void setDiliveryId(Integer diliveryId) {
        DiliveryId = diliveryId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
