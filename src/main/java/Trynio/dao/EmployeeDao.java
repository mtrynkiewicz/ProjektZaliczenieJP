package Trynio.dao;


import Trynio.entity.employee;

import java.util.List;

public interface EmployeeDao {
    List<employee> getEmployees();

    void saveEmployee(employee employee);
}
