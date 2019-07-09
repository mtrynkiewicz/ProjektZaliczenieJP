package Trynio.dao;

import Trynio.entity.order;
import Trynio.entity.orderItem;

import java.util.List;

public interface OrderItemDao
{
    List<orderItem> orderItemsForOrder(order o);
}
