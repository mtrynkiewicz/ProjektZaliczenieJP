package Trynio.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "proffessions")
public class proffession
{
    public proffession()
    {
        employees = new ArrayList<employee>();
    }

    public proffession(String proffessionsName)
    {
        this.name= proffessionsName;
        employees = new ArrayList<employee>();

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
        if(employees == null)
        {
           employees = new ArrayList<>();
        }
        employees.add(employee);
    }

    public List<employee> getEmployees() {
        return employees;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.name ;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

