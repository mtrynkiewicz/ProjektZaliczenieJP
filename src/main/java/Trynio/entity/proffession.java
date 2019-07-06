package Trynio.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "proffessions")
public class proffession
{
    public proffession(){}

    public proffession(String proffessionsName)
    {
        this.name= proffessionsName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "proffessionsName")
    private String name;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "proffession",cascade = CascadeType.ALL)
    private List<employee> employees;

    public void setEmployees(List<employee> employees) {
        this.employees = employees;
    }

    public void addEmployees(employee employee)
    {
        if(employees.isEmpty())
        {
           employees = new ArrayList<>();
        }
        employee.setProffession(this);
        employees.add(employee);
    }

    public List<employee> getEmployees() {
        return employees;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Zawód: " + this.name + "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

