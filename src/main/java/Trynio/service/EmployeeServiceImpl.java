package Trynio.service;

import Trynio.dao.EmployeeDao;
import Trynio.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public List<Employees> getEmployees()
    {
        List<Employees> employees = employeeDao.getEmployees();
        return employees;
    }

    @Override
    @Transactional
    public void saveBook(Employees employee)
    {
        employeeDao.saveBook(employee);
    }

}
