package Trynio.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class employee
{
    public employee(String name, String surname, float rating, float dailyIncome){
        this.name = name;
        this.surname = surname;
        this.rating = rating;
        this.dailyIncome = dailyIncome;
    };

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

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "proffession_id")
    private proffession proffession;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(float dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public proffession getProffession() {
        return proffession;
    }

    public void setProffession(proffession proffession) {
        this.proffession = proffession;
    }

    @Override
    public String toString() {
        return "Sprzedawca{" +
                "id=" + id +
                ", imie='" + name +
                ", nazwisko + '\''" + surname+
                " " + proffession +
                '}';
    }
}
