package Trynio.service;

import Trynio.entity.employee;

import java.util.List;

public interface EmployeeService {
    List<employee> getEmployees();

    public void saveEmployee(employee employee);

}
