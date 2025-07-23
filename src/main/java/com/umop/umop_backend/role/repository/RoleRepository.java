package com.umop.umop_backend.role.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umop.umop_backend.role.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
