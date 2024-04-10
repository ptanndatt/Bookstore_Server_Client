package dao.impl;

import dao.EmployeeDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import models.Customer;
import models.Employee;
import util.HibernateUtil;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private EntityManager em;
    public EmployeeDaoImpl() {
        em = HibernateUtil.getInstance().getEntityManager();
    }
    @Override
    public List<Employee> getAllEmployeeBy() {
        List<Employee> employees = null;
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            String hql = "FROM Employee";
            TypedQuery<Employee> query = em.createQuery(hql, Employee.class);
            employees = query.getResultList();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
        return employees;

    }

    @Override
    public boolean addEmployee(Employee employee) {
        EntityTransaction entityTransaction=em.getTransaction();
        try {
            entityTransaction.begin();
            em.persist(employee);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        EntityTransaction entityTransaction =  em.getTransaction();;
        try {
            entityTransaction.begin();
            em.merge(employee);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(String empId) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            Employee employee=em.find(Employee.class, empId);
            em.remove(employee);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
