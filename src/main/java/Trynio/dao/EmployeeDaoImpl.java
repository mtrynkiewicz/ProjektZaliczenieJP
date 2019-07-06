package Trynio.dao;

import Trynio.entity.employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<employee> getEmployees() {
        //sesja hibernate
        Session currentSession = sessionFactory.getCurrentSession();
        //zapytanie
        ///
        String s = "FROM Trynio.entity.employee";
        Query query = currentSession.createQuery(s);
        List employees = query.getResultList();
        return employees;
    }

    @Override
    public void saveEmployee(employee employee)
    {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
    }
}
