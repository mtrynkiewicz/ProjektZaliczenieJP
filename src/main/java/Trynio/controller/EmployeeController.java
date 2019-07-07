package Trynio.controller;


import Trynio.entity.employee;
import Trynio.entity.proffession;
import Trynio.service.EmployeeService;
import Trynio.service.ProffessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController
{

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProffessionService proffessionService;

    @GetMapping("/list")
    public String listEmpolyees(Model model)
    {
        List<employee> employees = employeeService.getEmployees();
        model.addAttribute("employees",employees);
        return "employeesList";
    }

    @GetMapping("/addEmployee")
    public String addForm(Model model)
    {
        employee employee = new employee();
        model.addAttribute("employee",employee);

        List<proffession> proffessions = proffessionService.getProffessions();
        model.addAttribute("proffessionsList",proffessions);

        return "addEmployeeForm";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") employee e)
    {
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("profesja");

        proffession  p = e.getProffession();
        System.out.println(p.getId());
        System.out.println(p.getName());
        System.out.println(p.toString());
        System.out.println();


        System.out.println();
        System.out.println();
        System.out.println(p.getEmployees());

        p.addEmployees(e);
        System.out.println(p.getEmployees());

        List<proffession> p1 = proffessionService.getProffessions();

        for (proffession _p :
                p1)
        {
            if(_p.getName().equals(p.getName()))
            {
                System.out.println(_p.getId());
                System.out.println(_p.getName());
                System.out.println(_p.toString());
                e.setProffession(_p);
            }
        }


        System.out.println();

        System.out.println("pracownik");
        System.out.println(e.getId());
        System.out.println(e.getName());
        System.out.println(e.getSurname());
        System.out.println(e.toString());

        System.out.println("po");
        System.out.println();
        System.out.println();
        System.out.println();

//        proffession  p = e.getProffession();
//        p.addEmployees(e);


        employeeService.saveEmployee(e);
        return "redirect:/employees/list";


    }

    @GetMapping("employeeUpdate")
    public String deleteBookForm(@RequestParam("employeeId")int employeeId, Model model){

        employee singleEmployee = employeeService.getEmployee(employeeId);
        employeeService.deleteEmployeeOnId(singleEmployee);

        return "addEmployeeForm";
    }

    @GetMapping("employeeDelete")
    public String updateBookForm(@RequestParam("employeeId")int employeeId, Model model){
        employee singleEmployee = employeeService.getEmployee(employeeId);
        model.addAttribute("employee",singleEmployee);

        List<proffession> proffessions = proffessionService.getProffessions();
        model.addAttribute("proffessionsList",proffessions);

        return "redirect:/employees/list";
    }
}
