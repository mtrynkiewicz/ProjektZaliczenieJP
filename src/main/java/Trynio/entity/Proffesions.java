package Trynio.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "proffesions")
public class Proffesions
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @Column(name="ProffesionName")
    private String proffesionName;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "ProffesionId",
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    private List<Employees> employees;

    public Proffesions(){}
    public Proffesions(String name){
        this.proffesionName=name;
    }

    //Dodawanie pracowników do listy:
    public void addEmployee(Employees e){
        if(employees==null)
        {
            employees=new ArrayList<>();
        }
        employees.add(e);
        e.setProffesionId(this);
    }

    public List<Employees> getEmployees()
    {
        return employees;
    }
    public void setEmployees(List<Employees> employees)
    {
        this.employees = employees;
    }

    public String getProffesionName()
    {
        return proffesionName;
    }
    public void setProffesionName(String proffesionName)
    {
        this.proffesionName = proffesionName;
    }

    @Override
    public String toString() {
        return "Profesja{" +
                "id=" + id +
                ", nazwa='" + proffesionName + '\'' +
                '}';
    }
}
