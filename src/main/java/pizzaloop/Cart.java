package pizzaloop;

import javax.persistence.*;

@Entity
@Table(name= "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private int order_id;
    @Column(name = "pizza_type")
    private String pizza_type;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "price")
    private Double price;


    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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
