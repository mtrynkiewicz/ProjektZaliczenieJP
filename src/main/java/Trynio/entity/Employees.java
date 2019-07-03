package Trynio.entity;

import javax.persistence.*;

@Entity
@Table(name="Employees")
public class Employees
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @Column(name="Name")
    private String name;

    @Column(name="Surname")
    private String surname;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="ProffesionId")
    private Proffesions proffesionId;

    @Column(name="Rating")
    private double rating;

    @Column(name="TotalIncome")
    private double totalIncome;

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

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Proffesions getProffesionId() {
        return proffesionId;
    }

    public void setProffesionId(Proffesions proffesionId) {
        this.proffesionId = proffesionId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Employees()
    {
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "id=" + id +
                ", Imie='" + name + '\'' +
                ", Nazwisko='" + surname+ '\'' +
                ", Profesja=" + proffesionId +
                ", Ocena=" + rating +
                ", Wygenerowany przychód=" + totalIncome +
                '}';
    }


}
