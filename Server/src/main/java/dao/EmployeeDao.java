package dao;


import models.Employee;
import models.Role;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployees();

    boolean addEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(String empId);

    List<Employee> findEmployeeByText(String text);

    List<Employee> findEmployeeByRoleCode(int roleCode);

    Employee findEmployeeById(String empId);
}
