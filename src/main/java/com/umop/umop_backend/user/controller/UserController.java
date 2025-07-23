package com.umop.umop_backend.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umop.umop_backend.user.dto.RegisterRequest;
import com.umop.umop_backend.user.entity.User;
import com.umop.umop_backend.user.service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/{id}")
	public User findUserById(@PathVariable Long id) {
		return userService.findUserById(id);
	}

	@PostMapping(value = "/register", consumes = "application/json")
	public User registUser(@RequestBody RegisterRequest user) {
		return userService.registerUser(user);
	}
	

}
