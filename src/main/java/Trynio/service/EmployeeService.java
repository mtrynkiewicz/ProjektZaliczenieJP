package Trynio.service;

import Trynio.entity.Employees;

import java.util.List;

public interface EmployeeService {
    List<Employees> getEmployees();

    public void saveBook(Employees employee);

}
