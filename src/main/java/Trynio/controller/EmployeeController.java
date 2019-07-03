package Trynio.controller;


import Trynio.entity.Employees;
import Trynio.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController
{

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String listEmpolyees(Model model)
    {
        List<Employees> employees = employeeService.getEmployees();
        model.addAttribute("employees",employees);
        return "employeesList";
    }

    @GetMapping
    public String addForm(Model model)
    {
        Employees employee = new Employees();
        model.addAttribute("employee",employee);
        return "addEmployeeForm";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("employee") Employees employees)
    {
        employeeService.saveBook(employees);
        return "redirect:/employees/list";
    }

}
