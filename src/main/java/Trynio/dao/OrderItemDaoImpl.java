package Trynio.dao;

import Trynio.entity.order;
import Trynio.entity.orderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderItemDaoImpl implements OrderItemDao
{
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public List<orderItem> orderItemsForOrder(order o)
    {
        Session session = sessionFactory.getCurrentSession();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Lista idików:");
        List<Integer> listOfIds = new ArrayList<>();
        for (orderItem singleOrdeItem :
                o.getItems())
        {
            System.out.println(singleOrdeItem.getId());
            listOfIds.add(singleOrdeItem.getId());
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        String s = "FROM orderItem as oi WHERE oi.id in (:itemsIds)";
        Query query = session.createQuery(s);
        query.setParameter("itemsIds",listOfIds);

        List results = query.getResultList();
        return results;
    }
}
