package Trynio.controller;


import Trynio.entity.employee;
import Trynio.entity.proffession;
import Trynio.service.EmployeeService;
import Trynio.service.ProffessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
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
        proffession  p = e.getProffession();
        List<proffession> p1 = proffessionService.getProffessions();

        for (proffession _p :
                p1)
        {
            if(_p.getName().equals(p.getName()))
            {
                e.setProffession(_p);
            }
        }
        employeeService.saveEmployee(e);
        return "redirect:/employees/list";
    }

    @GetMapping("employeeDelete")
    public String deleteBookForm(@RequestParam("employeeId")int employeeId, Model model){

        employee singleEmployee = employeeService.getEmployee(employeeId);
        employeeService.deleteEmployeeOnId(singleEmployee);

        return "redirect:/employees/list";
    }

    @GetMapping("employeeUpdate")
    public String updateBookForm(@RequestParam("employeeId")int employeeId, Model model){
        employee singleEmployee = employeeService.getEmployee(employeeId);
        model.addAttribute("employee",singleEmployee);

        List<proffession> proffessions = proffessionService.getProffessions();
        model.addAttribute("proffessionsList",proffessions);

        return "addEmployeeForm";
    }

    @GetMapping("backToMenu")
    public String backToMenu(Model model)
    {
        return "redirect:/tryShowMenu";
    }

}
