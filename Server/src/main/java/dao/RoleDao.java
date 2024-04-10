package dao;

import models.Role;

import java.util.List;

public interface RoleDao {
    boolean addRole(Role role);
    boolean deleteRole(String roleId);

    List<Role> getAllRole();
}
