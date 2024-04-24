package service;

import dao.impl.CustomerDaoImpl;
import dao.impl.EmployeeDaoImpl;
import models.Customer;
import models.Employee;
import models.Role;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public class EmployeeDaoImplService implements Remote {
    private final EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

    public EmployeeDaoImplService() throws RemoteException {
    }

    public List<Employee> getAllEmployees() throws RemoteException {
        return employeeDao.getAllEmployees();
    }

    public boolean addEmployee(Employee employee) throws RemoteException {
        return employeeDao.addEmployee(employee);
    }

    public boolean updateEmployee(Employee employee) throws RemoteException {
        return employeeDao.updateEmployee(employee);
    }

    public boolean deleteEmployee(String id) throws RemoteException {
        return employeeDao.deleteEmployee(id);
    }

    public List<Employee> findEmployeeByText(String text) throws RemoteException {
        return employeeDao.findEmployeeByText(text);
    }

    public List<Employee> findEmployeeByRoleCode(int roleCode) throws RemoteException {
        return employeeDao.findEmployeeByRoleCode(roleCode);
    }

    public Employee findEmployeeById(String empId) throws RemoteException {
        return employeeDao.findEmployeeById(empId);
    }
}
