package dao;

import models.Role;

import java.util.ArrayList;
import java.util.List;

public interface RoleDao {
    boolean addRole(Role role);

    boolean deleteRole(String roleId);

    List<Role> getAllRole();

    Role findRoleByText(String text);

    boolean updateRole(String id);

    List<Role> getRolesByRoleCode(int roleCode);
    
}
