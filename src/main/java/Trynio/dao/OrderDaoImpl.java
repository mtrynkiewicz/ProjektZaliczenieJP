package Trynio.dao;

import Trynio.entity.employee;
import Trynio.entity.order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;


@Repository
public class OrderDaoImpl implements OrderDao
{
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public List<order> orderListForEmployee(employee emp)
    {
        Session session = sessionFactory.getCurrentSession();

        String s = "FROM order as o WHERE o.employee.id = :employeeId";
        Query query = session.createQuery(s);
        query.setParameter("employeeId",emp.getId());

        List results = query.getResultList();
        return results;
    }

    @Override
    @Transactional
    public order getSingleOrderById(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        String s = "FROM order as o WHERE o.id = :orderID";
        Query query = session.createQuery(s);
        query.setParameter("orderID",id);

        order o = (order) query.getResultList().get(0);
        return o;
    }


}
