package dao.impl;

import dao.EmployeeDao;
import models.Employee;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public List<Employee> getAllEmployeeBy() {
        return List.of();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(String empId) {
        return false;
    }
}
