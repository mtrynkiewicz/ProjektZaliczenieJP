package Logic.Database;

import javax.persistence.*;

@Entity
public class Employees
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @Column(name="Name")
    private String Name;

    @Column(name="Surname")
    private String surname;

//    @Column(name="ProffesionId")
    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="ProffesionId")
    private Proffesions ProffesionId;

    @Column(name="Rating")
    private double Rating;

    @Column(name="TotalIncome")
    private double TotalIncome;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getTotalIncome() {
        return TotalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        TotalIncome = totalIncome;
    }

    public Proffesions getProffesionId() {
        return ProffesionId;
    }

    public void setProffesionId(Proffesions proffesionId) {
        ProffesionId = proffesionId;
    }
    public Employees()
    {
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }
}
