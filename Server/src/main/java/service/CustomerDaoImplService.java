package service;



import dao.impl.CustomerDaoImpl;
import models.Customer;

import java.util.List;

public class CustomerDaoImplService{
    private CustomerDaoImpl customerDao = new CustomerDaoImpl();

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public boolean addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }

    public boolean updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    public boolean deleteCustomer(String id) {
        return customerDao.deleteCustomer(id);
    }
    public List<Customer> findCustomerByText(String text) {
        return customerDao.findCustomerByText(text);
    }
    public Customer findCustomerById(String id) {
        return customerDao.getCustomerByID(id);
    }
}