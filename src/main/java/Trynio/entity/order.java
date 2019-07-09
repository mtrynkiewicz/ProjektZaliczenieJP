package Trynio.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Orders")
public class order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private employee employee;

    @Column(name = "discountPercent")
    private float discountPercent;

    @Column(name = "totalValue")
    private float totalValue;

//    @OneToMany(fetch = FetchType.LAZY,mappedBy = "singleOrder",
//            cascade = CascadeType.ALL)
//    private List<orderPosition> orderPositions;
//
//    public void setOrderPositions(List<orderPosition> positions) {
//        this.orderPositions= positions;
//    }
//
//    public void addEmployees(orderPosition position)
//    {
//        if(orderPositions== null)
//        {
//            orderPositions= new ArrayList<>();
//        }
//        orderPositions.add(position);
//    }
//
//    public List<orderPosition> getOrderPositions() {
//        return orderPositions;
//    }


    @ManyToMany
    @JoinTable(
            name="orderPositions",
            joinColumns = @JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name="orderItem_Id")
    )
    private Set<orderItem> items;
    public void addItem(orderItem item){
        if (items == null)
            items = new HashSet<>();
        //autor.addKsiazka(this);
        items.add(item);
    }
    public void removeItem(orderItem item){
        if (items == null)
            return;
        //autor.addKsiazka(this);
        items.remove(item);
    }

    public order(Trynio.entity.employee employee, float discountPercent, float totalValue) {
        this.employee = employee;
        this.discountPercent = discountPercent;
        this.totalValue = totalValue;
    }

    public order() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Trynio.entity.employee getEmployee() {
        return employee;
    }

    public void setEmployee(Trynio.entity.employee employee) {
        this.employee = employee;
    }

    public float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }

    public float getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(float discountPercent) {
        this.discountPercent = discountPercent;
    }
}
