package Trynio.service;

import Trynio.dao.EmployeeDao;
import Trynio.entity.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public List<employee> getEmployees()
    {
        List<employee> employees = employeeDao.getEmployees();
        return employees;
    }

    @Override
    @Transactional
    public void saveEmployee(employee employee)
    {
        employeeDao.saveEmployee(employee);
    }

    @Override
    public employee getEmployee(int employeeId) {
        return employeeDao.findById(employeeId);
    }

    @Override
    public void deleteEmployeeOnId(employee employee)
    {
        employeeDao.deleteEmployee( employee);
    }
}
