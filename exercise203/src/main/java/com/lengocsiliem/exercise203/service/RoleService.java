package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.Role;

public interface RoleService {
    List<Role> getAllRoles();

    Role getRoleById(UUID id);

    Role createRole(Role role);

    void deleteRole(UUID id);
}
