package Trynio.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orderItems")
public class orderItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "itemName")
    private String itemName;

    @Column(name = "price")
    private float price;

    @Column(name = "containsAlcohol")
    private Boolean containsAlcohol;


    public orderItem(){}

    public orderItem(String itemName, float price, boolean containsAlcohol)
    {
        this.itemName= itemName;
        this.price = price;
        this.containsAlcohol = containsAlcohol;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Boolean getContainsAlcohol() {
        return containsAlcohol;
    }

    public void setContainsAlcohol(Boolean containsAlcohol) {
        this.containsAlcohol = containsAlcohol;
    }


    @ManyToMany
    @JoinTable(
            name="orderPositions",
            joinColumns = @JoinColumn(name="orderItem_Id"),
            inverseJoinColumns = @JoinColumn(name="order_id")
    )
    private Set<order> orders;
    public void addOrder(order o){
        if (orders == null)
            orders = new HashSet<>();

        orders.add(o);
    }
    public void removeOrder(order o){
        if (orders == null)
            return;
        orders.remove(o);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
