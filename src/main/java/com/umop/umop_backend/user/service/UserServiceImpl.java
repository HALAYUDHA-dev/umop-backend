package com.umop.umop_backend.user.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.umop.umop_backend.role.service.RoleService;
import com.umop.umop_backend.user.dto.RegisterRequest;
import com.umop.umop_backend.user.entity.User;
import com.umop.umop_backend.user.exception.UserNotFoundException;
import com.umop.umop_backend.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found on ID: " + id));
	}

	@Override
	public User findUserByUserName(String name) {
		return userRepository.findByUsername(name)
				.orElseThrow(() -> new UserNotFoundException("User not found with NAME: " + name));
	}

	@Override
	public User registerUser(RegisterRequest newuser) {
		User user = new User();
		String encryptPass = passwordEncoder.encode(newuser.getPassword());
		user.setPassword(encryptPass);
		user.setEmail(newuser.getEmail());
		user.setUsername(newuser.getUsername());
		user.setCreatedAt(LocalDateTime.now());
		user.setRoles(roleService.createDefaultRoles());
		return userRepository.save(user);
	}
}
