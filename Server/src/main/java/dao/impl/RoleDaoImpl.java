package dao.impl;

import dao.RoleDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import models.Role;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    private EntityManager em;
    public RoleDaoImpl() {
        em = HibernateUtil.getInstance().getEntityManager();
    }
    @Override
    public boolean addRole(Role role) {
        EntityTransaction entityTransaction=em.getTransaction();
        try {
            entityTransaction.begin();
            em.persist(role);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteRole(String roleId) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            Role role=em.find(Role.class, roleId);
            em.remove(role);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public ArrayList<Role> getAllRole() {
        ArrayList<Role> roles = null;
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            String hql = "FROM Role";
            TypedQuery<Role> query = em.createQuery(hql, Role.class);
            roles = (ArrayList<Role>) query.getResultList();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
        return roles;
    }
}
