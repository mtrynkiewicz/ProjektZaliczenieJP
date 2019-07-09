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
    public orderItem(){}

    public orderItem(String itemName, float price, boolean containsAlcohol)
    {
        this.itemName= itemName;
        this.price = price;
        this.containsAlcohol = containsAlcohol;
    }

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

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "singleOrderItem",
            cascade = CascadeType.ALL)
    private List<orderPosition> orderPositions;

    public void setOrderPositions(List<orderPosition> positions) {
        this.orderPositions= positions;
    }

    public void addEmployees(orderPosition position)
    {
        if(orderPositions== null)
        {
            orderPositions= new ArrayList<>();
        }
        orderPositions.add(position);
    }

    public List<orderPosition> getOrderPositions() {
        return orderPositions;
    }


//    @ManyToMany
//    @JoinTable(
//            name="orderPositions",
//            joinColumns = @JoinColumn(name="orderItem_Id"),
//            inverseJoinColumns = @JoinColumn(name="order_id")
//    )
//    private Set<order> orders;
//    public void addOrder(order o){
//        if (orders == null)
//            orders = new HashSet<>();
//        //autor.addKsiazka(this);
//        orders.add(o);
//    }
//    public void removeOrder(order o){
//        if (orders == null)
//            return;
//        //autor.addKsiazka(this);
//        orders.remove(o);
//    }


}
