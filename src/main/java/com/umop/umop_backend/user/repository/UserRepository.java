package com.umop.umop_backend.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umop.umop_backend.user.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUsername(String username);
}
