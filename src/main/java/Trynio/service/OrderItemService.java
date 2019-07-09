package Trynio.service;

import Trynio.entity.order;
import Trynio.entity.orderItem;

import java.util.List;

public interface OrderItemService
{
    List<orderItem> orderItemsForOrder(order o);
}
