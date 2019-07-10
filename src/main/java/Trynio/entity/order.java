package Trynio.entity;

import org.springframework.security.core.parameters.P;

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
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private employee employee;

    @Column(name = "discountPercent")
    private float discountPercent;

    @Column(name = "totalValue")
    private float totalValue;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="orderPositions",
            joinColumns = @JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name="orderItem_Id")
    )
    private Set<orderItem> items;
    public void addItem(orderItem item){
        if (items == null)
            items = new HashSet<>();
        items.add(item);
    }
    public void removeItem(orderItem item){
        if (items == null)
            return;
        items.remove(item);
    }

    public Set<orderItem> getItems()
    {
        return items;
    }

    public order(Trynio.entity.employee employee, float discountPercent, float totalValue) {
        this.employee = employee;
        this.discountPercent = discountPercent;
        this.totalValue = totalValue;
    }

    public order() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
