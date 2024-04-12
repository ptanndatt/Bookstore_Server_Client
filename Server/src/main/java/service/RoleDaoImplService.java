package service;

import dao.RoleDao;
import dao.impl.RoleDaoImpl;
import models.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleDaoImplService {
    RoleDaoImpl roleDao = new RoleDaoImpl();

    public List<Role> getAllRole() {
        return roleDao.getAllRole();
    }

    public boolean addRole(Role role) {
        return roleDao.addRole(role);
    }

    public boolean deleteRole(String id) {
        return roleDao.deleteRole(id);
    }

    public Role findRoleByText(String text) {
        return roleDao.findRoleByText(text);
    }

    public boolean updateRole(String id) {
        return roleDao.updateRole(id);
    }
}
