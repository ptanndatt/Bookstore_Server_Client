package dao;

import models.Customer;

import java.util.List;

public interface CustomerDao {
    boolean addCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(String customerID);
    List<Customer> getAllCustomers();
    List<Customer> findCustomerByText(String text);
}
