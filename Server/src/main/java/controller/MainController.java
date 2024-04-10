package controller;

import models.Customer;
import service.CustomerDaoImplService;

import java.util.List;

public class MainController {
    private CustomerDaoImplService customerDaoImplService = new CustomerDaoImplService();




    //Customer
    public List<Customer> getAllCustomers() {
        return customerDaoImplService.getAllCustomers();
    }

    public boolean addCustomer(Customer customer) {
        return customerDaoImplService.addCustomer(customer);
    }

    public boolean update(Customer customer) {
        return customerDaoImplService.updateCustomer(customer);
    }

    public boolean delete(String id) {
        return customerDaoImplService.deleteCustomer(id);
    }
    public List<Customer> findCustomerByText(String text) {
        return customerDaoImplService.findCustomerByText(text);
    }
}
