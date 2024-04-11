package service;

import dao.impl.CustomerDaoImpl;
import dao.impl.EmployeeDaoImpl;
import models.Customer;
import models.Employee;

import java.util.List;

public class EmployeeDaoImplService {
    private EmployeeDaoImpl employeeDao= new EmployeeDaoImpl();

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public boolean addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    public boolean updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    public boolean deleteEmployee(String id) {
        return employeeDao.deleteEmployee(id);
    }
    public List<Employee> findEmployeeByText(String text) {
        return employeeDao.findEmployeeByText(text);
    }
}
