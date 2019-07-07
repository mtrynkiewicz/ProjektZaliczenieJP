package Trynio.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderItem")
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
}
