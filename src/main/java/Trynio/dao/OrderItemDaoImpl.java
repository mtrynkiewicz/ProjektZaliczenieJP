package Trynio.dao;

import Trynio.entity.employee;
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

        List<Integer> listOfIds = new ArrayList<>();
        for (orderItem singleOrdeItem :
                o.getItems())
        {
            listOfIds.add(singleOrdeItem.getId());
        }
        String s = "FROM orderItem as oi WHERE oi.id in (:itemsIds)";
        Query query = session.createQuery(s);
        query.setParameter("itemsIds",listOfIds);

        List results = query.getResultList();
        return results;
    }

    @Override
    public void saveOrderItem(orderItem newOrderItem)
    {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(newOrderItem);
    }

    @Override
    @Transactional
    public List<orderItem> getAllOrderItems()
    {
        Session session = sessionFactory.getCurrentSession();
        String s = "FROM orderItem";
        Query<orderItem> query = session.createQuery(s,orderItem.class);
        List orderItems = query.getResultList();
        return orderItems;

    }

    @Override
    @Transactional
    public orderItem getItemById(int itemId)
    {
        Session session = sessionFactory.getCurrentSession();
        return session.find(orderItem.class,itemId);
    }

    @Override
    @Transactional
    public void deleteItem(orderItem item)
    {
        Session session = sessionFactory.getCurrentSession();

        String hql = "DELETE FROM orderItem "  +
                "WHERE id = :item_id";
        Query query = session.createQuery(hql);
        query.setParameter("item_id", item.getId());

        int result = query.executeUpdate();

    }
}
