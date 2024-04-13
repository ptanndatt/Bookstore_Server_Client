package dao.impl;

import dao.RoleDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import models.Customer;
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
        EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();
            if (!em.contains(role)) {
                role = em.merge(role);
            }
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
            Role role = em.find(Role.class, roleId);
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
    public List<Role> getAllRole() {
        List<Role> roles = null;
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            String hql = "FROM Role";
            TypedQuery<Role> query = em.createQuery(hql, Role.class);
            roles = query.getResultList();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
        return roles;
    }

    public Role findRoleByText(String text) {
        return em.createQuery("SELECT r from Role r where r.roleName =:text", Role.class)
                .setParameter("text", text) // %text% for similarity
                .getSingleResult();
    }

    @Override
    public boolean updateRole(String id) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            Role role = em.find(Role.class, id);
            em.merge(role);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Role> getRolesByRoleCode(int roleCode) {
        List<Role> roles = new ArrayList<>();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            String hql = "FROM Role r WHERE r.roleCode = :roleCode";
            TypedQuery<Role> query = em.createQuery(hql, Role.class);
            query.setParameter("roleCode", roleCode);
            roles = query.getResultList();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
        return roles;
    }
}
