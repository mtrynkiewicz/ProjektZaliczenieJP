package Trynio.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class employee
{
    public employee(String name, String surname, float rating, float dailyIncome){
        this.name = name;
        this.surname = surname;
        this.rating = rating;
        this.dailyIncome = dailyIncome;
    }

    public employee() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "rating")
    private float rating;

    @Column(name = "dailyIncome")
    private float dailyIncome;

    @ManyToOne
    @JoinColumn(name = "proffession_id")
    private proffession proffession;

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public float getRating() {
        return this.rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getDailyIncome() {
        return this.dailyIncome;
    }

    public void setDailyIncome(float dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public proffession getProffession() {
        return this.proffession;
    }

    public void setProffession(proffession proffession)
    {
        this.proffession = proffession;
    }

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "employee",
            cascade = CascadeType.ALL)
    private List<order> orders;

    public void setOrders(List<order> orders) {
        this.orders = orders;
    }

    public void addOrder(order order)
    {
        if(orders == null)
        {
            orders = new ArrayList<>();
        }
        orders.add(order);
    }

    public List<order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "Sprzedawca{" +
                "id=" + id +
                ", imie=" + name +
                ", nazwisko=" + surname+
                " " + proffession +
                '}';
    }
}
