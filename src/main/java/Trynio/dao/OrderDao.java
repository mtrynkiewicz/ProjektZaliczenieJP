package Trynio.dao;

import Trynio.entity.employee;
import Trynio.entity.order;

import java.util.HashMap;
import java.util.List;

public interface OrderDao
{
    List<order> orderListForEmployee(employee emp);
    order getSingleOrderById(int id);

    void saveOrder(order o);

    void deleteOrder(order o);
}
