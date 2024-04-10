package dao.impl;

import dao.CustomerDao;
import models.Customer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import util.GenderEnum;

import java.time.LocalDate;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerDaoTest {
    private CustomerDaoImpl customerDao;
    @BeforeAll
    void setUp() {
        customerDao=new CustomerDaoImpl();
    }
    @AfterAll
    void tearDown() {
        customerDao=null;
    }

    @Test
    void testFindCustomer() {
        List<Customer> customers=customerDao.findCustomerByText("V");
        System.out.println(customers);
    }
}
