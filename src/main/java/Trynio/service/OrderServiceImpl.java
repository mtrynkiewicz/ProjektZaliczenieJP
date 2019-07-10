package Trynio.service;

import Trynio.dao.OrderDao;
import Trynio.entity.employee;
import Trynio.entity.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderDao orderDao;

    @Override
    @Transactional
    public List<order> orderListForEmployee(employee emp)
    {
        return orderDao.orderListForEmployee(emp);
    }

    @Override
    @Transactional
    public HashMap<employee, List<order>> getAllOrdersForEmployees(List<employee> empList)
    {
        HashMap<employee, List<order>> results = new HashMap<>();

        for (employee emp : empList)
        {
            List<order> orderList = orderDao.orderListForEmployee(emp);
            if(orderList == null)
            {
                continue;
            }
            results.put(emp,orderList);
        }

        return results;
    }

    @Override
    @Transactional
    public order getSingleOrderById(int id) {
        return orderDao.getSingleOrderById(id);
    }

    @Override
    @Transactional
    public void saveOrder(order o)
    {
        orderDao.saveOrder(o);
    }

    @Override
    @Transactional
    public void deleteOrder(order o)
    {
        orderDao.deleteOrder(o);
    }

}
