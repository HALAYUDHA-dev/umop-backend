package com.umop.umop_backend.role.service;

import java.util.Set;

import com.umop.umop_backend.role.entity.Role;

public interface RoleService {

    public Role findRoleByName(String name);

    Set<Role> createDefaultRoles();
}
