package Trynio.dao;

import Trynio.entity.Employees;

import java.util.List;

public interface EmployeeDao {
    List<Employees> getEmployees();

    void saveBook(Employees employee);
}
