package Trynio.dao;


import Trynio.entity.employee;

import java.util.List;

public interface EmployeeDao {
    List getEmployees();

    void saveEmployee(employee employee);

    employee findById(int employeeId);

    void deleteEmployee(employee employeeObj);
}
