package dao;

import models.Customer;

public interface CustomerDao {
    boolean addCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(String customerID);
}
