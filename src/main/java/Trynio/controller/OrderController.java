package Trynio.controller;

import Trynio.entity.employee;
import Trynio.entity.order;
import Trynio.entity.orderItem;
import Trynio.service.EmployeeService;
import Trynio.service.OrderItemService;
import Trynio.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/showOrders")
    public String showAvailableOrders(Model model)
    {
        List<employee> listOfEmployees = employeeService.getEmployees();

        List<employee> employeesButNotCook = new ArrayList<employee>();
        for (employee emp :
                listOfEmployees) {
            if(emp.getProffession().getId()!= 3)
            {
                employeesButNotCook.add(emp);
            }
        }

        HashMap<employee,List<order>> hasSetKeyOfEmpValuesOfOrder
                = orderService.getAllOrdersForEmployees(employeesButNotCook);
        model.addAttribute("hasSetKeyOfEmpValuesOfOrder",hasSetKeyOfEmpValuesOfOrder);

        return "showOrdersGruppedByEmployees";
    }

    @GetMapping("/show")
    public String showOrderDetails(@RequestParam("orderId")int orderId, Model model)
    {
        order o = orderService.getSingleOrderById(orderId);
        model.addAttribute("currentOrder",o);

        List<orderItem> items = orderItemService.orderItemsForOrder(o);
        model.addAttribute("orderItems",items);


        return "orderDetails";
    }


    @GetMapping("/addItemToOrder")
    public String invokeAddingItemToOrder(@RequestParam("currentOrderId")int oId, Model model)
    {
        order o = orderService.getSingleOrderById(oId);
        model.addAttribute("currentOrder",o);

        List<orderItem> orderItemsList = orderItemService.getAllOrderItems();
        model.addAttribute("allOrderItems",orderItemsList);


        return "addOrderItemToOrder";
    }

    @PostMapping("/itemAddedToOrder")
    public String invokeAavingAddedItemToOrder(@RequestParam("currentOrder")order o, Model model)
    {
        orderService.saveOrder(o);
        return "redirect:/showOrdersGruppedByEmployees";
    }


    @GetMapping("backToMenu")
    public String backToMenu(Model model)
    {
        return "redirect:/tryShowMenu";
    }


    @GetMapping("/orderUpdate")
    public String updateOrder(@RequestParam("orderId")int orderId, Model model)
    {
        order o = orderService.getSingleOrderById(orderId);
        model.addAttribute("order",o);

        List<employee> empList = employeeService.getEmployees();
        model.addAttribute("employeeList",empList);
        return "createOrderForm";
    }

    @GetMapping("/orderDelete")
    public String deleteOrder(@RequestParam("orderId")int orderId, Model model)
    {
        order o = orderService.getSingleOrderById(orderId);
        orderService.deleteOrder(o);

        return "redirect:/showOrders";
    }

    @PostMapping("/saveOrder")
    public String saveNewOrder(@ModelAttribute("order")order o, Model model)
    {
        employee  e = o.getEmployee();
        List<employee> e1 = employeeService.getEmployees();

        for (employee _e :
                e1)
        {
            if(_e.getName().equals(e.getName())
            && _e.getSurname().equals(e.getSurname()))
            {
                o.setEmployee(_e);
            }
        }

        orderService.saveOrder(o);
        return "redirect:/orders/showOrders";
    }

}
