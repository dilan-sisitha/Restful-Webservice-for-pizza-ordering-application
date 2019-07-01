package pizzaloop;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name= "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  // @Column(name = "orderId")
    private Integer orderId;
 //   @Column(name = "pizza_type")
    private String pizza_type;
 //   @Column(name = "quantity")
    private String quantity;
//   @Column(name = "price")
    private Double price;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getPizza_type() {
        return pizza_type;
    }

    public void setPizza_type(String pizza_type) {
        this.pizza_type = pizza_type;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
