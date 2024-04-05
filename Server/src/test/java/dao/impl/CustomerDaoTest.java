package dao.impl;

import dao.CustomerDao;
import models.Customer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import util.GenderEnum;

import java.time.LocalDate;

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
    void testAddCustomer() {
        Customer customer=new Customer("Vinh","0355420475","vinh38254","Ben Tre",GenderEnum.getById(1).getDescription(),LocalDate.of(2003,9,1));
        boolean result=customerDao.addCustomer(customer);
        System.out.println(result);
    }
//    @Test
//    void testDeleteCustomer() {
//        String id= "null20240404230541";
//        boolean result=customerDao.deleteCustomer(id);
//        System.out.println(result);
//    }
}
