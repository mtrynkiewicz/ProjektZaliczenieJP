package Trynio.controller;

import Trynio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController
{
    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(ModelMap model) {
        return "index";
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPageAgain(ModelMap model) {
        return "index";
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        return "admin";
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(ModelMap model) {
        return "user";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/tryShowMenu", method = RequestMethod.GET)
    public String tryShowMenu(ModelMap model) {
        return "adminMenu";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @RequestMapping(value = "/showOrders", method = RequestMethod.GET)
    public String showOrders(ModelMap model)
    {
        return "redirect:/orders/showOrders";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/showEmployee", method = RequestMethod.GET)
    public String showEmployee(ModelMap model) {
        return "redirect:/employees/list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/tryManageOrderItem", method = RequestMethod.GET)
    public String tryAddOrderItem(ModelMap model)
    {
        return "redirect:/orderItem/list";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/showLoginUser", method = RequestMethod.GET)
    public String logAsUser(ModelMap model)
    {
        return "redirect:/user";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/showLoginAdmin", method = RequestMethod.GET)
    public String logAsAdmin(ModelMap model)
    {
        return "redirect:/admin";
    }
}