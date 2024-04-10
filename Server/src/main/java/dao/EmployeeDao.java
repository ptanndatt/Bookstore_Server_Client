package dao;

import models.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployeeBy();
    boolean addEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(String empId);

}
