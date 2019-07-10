package Trynio.service;

import Trynio.entity.employee;
import Trynio.entity.order;

import java.util.HashMap;
import java.util.List;

public interface OrderService
{
    List<order> orderListForEmployee(employee emp);

    HashMap<employee,List<order>> getAllOrdersForEmployees(List<employee> empList);

    order getSingleOrderById(int id);

    void saveOrder(order o);

    void deleteOrder(order o);
}
