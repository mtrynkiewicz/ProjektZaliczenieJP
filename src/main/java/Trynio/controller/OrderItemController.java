package Trynio.controller;


import Trynio.entity.orderItem;
import Trynio.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orderItem")
public class OrderItemController
{

    @Autowired
    OrderItemService orderItemService;


    @GetMapping("/create")
    public String createOrderItem(Model model)
    {
        orderItem item = new orderItem();
        model.addAttribute("item",item);

        return "createOrderItemForm";
    }

    @GetMapping("/list")
    public String createOrderItemList(Model model)
    {
        List<orderItem> items = orderItemService.getAllOrderItems();
        model.addAttribute("items",items);

        return "showOrderItemsList";
    }


    @PostMapping("/confirmToDb")
    public String saveEmployee(@ModelAttribute("item") orderItem newOrderItem)
    {
        orderItemService.saveOrderItem(newOrderItem);
        return "redirect:/tryShowMenu";
    }

    @GetMapping("/itemUpdate")
    public String updateItem(@RequestParam("itemId")int itemId, Model model)
    {
        orderItem item = orderItemService.getItemById(itemId);
        model.addAttribute("item",item);
        return "createOrderItemForm";
    }

    @GetMapping("/itemDelete")
    public String updateDelete(@RequestParam("itemId")int itemId, Model model)
    {
        orderItem item = orderItemService.getItemById(itemId);
        orderItemService.deleteItem(item);
        return "redirect:/orderItem/list";
    }

    @GetMapping("/backToOrderItemList")
    public String backToList(Model model)
    {
        return "redirect:/orderItem/list";
    }

    @GetMapping("/tryShowMenu")
    public String backToMenu(Model model)
    {
        return "redirect:/tryShowMenu";
    }




}
