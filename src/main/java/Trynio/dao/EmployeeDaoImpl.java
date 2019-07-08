package Trynio.dao;

import Trynio.entity.employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<employee> getEmployees() {
        //sesja hibernate
        Session currentSession = sessionFactory.getCurrentSession();
        //zapytanie
        ///
        String s = "FROM employee";
        Query<employee> query = currentSession.createQuery(s,employee.class);
        List employees = query.getResultList();
        return employees;
    }

    @Override
    @Transactional
    public void saveEmployee(employee employee)
    {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    @Transactional
    public employee findById(int employeeId) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(employee.class,employeeId);
    }

    @Override
    @Transactional
    public void deleteEmployee(employee employeeObj) {
        Session session = sessionFactory.getCurrentSession();
//        session.delete("employees",employeeObj);

        String hql = "DELETE FROM employee "  +
                "WHERE id = :employee_id";
        Query query = session.createQuery(hql);
        query.setParameter("employee_id", employeeObj.getId());

        System.out.println();
        System.out.println(employeeObj.getId());
        System.out.println();

        int result = query.executeUpdate();
    }
}
