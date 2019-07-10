package Trynio.service;

import Trynio.dao.OrderItemDao;
import Trynio.entity.order;
import Trynio.entity.orderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService
{

    @Autowired
    OrderItemDao orderItemDao;

    @Override
    @Transactional
    public List<orderItem> orderItemsForOrder(order o)
    {
        return orderItemDao.orderItemsForOrder(o);
    }

    @Override
    @Transactional
    public void saveOrderItem(orderItem newOrderItem)
    {
        orderItemDao.saveOrderItem(newOrderItem);
    }

    @Override
    @Transactional
    public List<orderItem> getAllOrderItems()
    {
        return orderItemDao.getAllOrderItems();
    }

    @Override
    @Transactional
    public orderItem getItemById(int itemId) {
        return orderItemDao.getItemById(itemId);
    }

    @Override
    @Transactional
    public void deleteItem(orderItem item)
    {
        orderItemDao.deleteItem(item);
    }
}
