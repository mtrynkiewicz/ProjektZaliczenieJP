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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

        HashMap<employee,List<order>> hasSetKeyOfEmpValuesOfOrder
                = orderService.getAllOrdersForEmployees(listOfEmployees);
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



    @GetMapping("backToMenu")
    public String backToMenu(Model model)
    {
        return "redirect:/tryShowMenu";
    }
}
