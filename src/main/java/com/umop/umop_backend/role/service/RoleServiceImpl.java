package com.umop.umop_backend.role.service;

import java.util.Collections;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umop.umop_backend.common.enums.RoleType;
import com.umop.umop_backend.role.entity.Role;
import com.umop.umop_backend.role.exception.RoleNotFound;
import com.umop.umop_backend.role.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByName(name).orElseThrow(() -> new RoleNotFound("Role not Found: " + name));
    }

    public Set<Role> createDefaultRoles() {
        Role role = findRoleByName(RoleType.ROLE_USER.name());
        return Collections.singleton(role);
    }

}
