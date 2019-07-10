package Trynio.service;

import Trynio.entity.order;
import Trynio.entity.orderItem;

import java.util.List;

public interface OrderItemService
{
    List<orderItem> orderItemsForOrder(order o);

    void saveOrderItem(orderItem newOrderItem);

    List<orderItem> getAllOrderItems();

    orderItem getItemById(int itemId);

    void deleteItem(orderItem item);
}
