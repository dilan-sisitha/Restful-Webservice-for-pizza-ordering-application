package pizzaloop;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CardPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cardPayId;
    private String cardName;
    private String cardNum;
    private String expDate;
    private String veriNum;

    public Integer getCardPayId() {
        return cardPayId;
    }

    public void setCardPayId(Integer cardPayId) {
        this.cardPayId = cardPayId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getVeriNum() {
        return veriNum;
    }

    public void setVeriNum(String veriNum) {
        this.veriNum = veriNum;
    }
}
