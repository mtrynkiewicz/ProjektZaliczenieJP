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

    @Column(name="Ratings")
    private double Ratings;

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

    public double getRatings() {
        return Ratings;
    }

    public void setRatings(double ratings) {
        Ratings = ratings;
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

}
