package service;


import dao.impl.CustomerDaoImpl;
import models.Customer;

import java.rmi.RemoteException;
import java.util.List;

public class CustomerDaoImplService {
    private CustomerDaoImpl customerDao = new CustomerDaoImpl();

    public CustomerDaoImplService() throws RemoteException {
    }

    public List<Customer> getAllCustomers() throws RemoteException {
        return customerDao.getAllCustomers();
    }

    public boolean addCustomer(Customer customer) throws RemoteException {
        return customerDao.addCustomer(customer);
    }

    public boolean updateCustomer(Customer customer) throws RemoteException {
        return customerDao.updateCustomer(customer);
    }

    public boolean deleteCustomer(String id) throws RemoteException {
        return customerDao.deleteCustomer(id);
    }

    public List<Customer> findCustomerByText(String text) throws RemoteException {
        return customerDao.findCustomerByText(text);
    }

    public Customer findCustomerById(String id) throws RemoteException {
        return customerDao.getCustomerByID(id);
    }
}