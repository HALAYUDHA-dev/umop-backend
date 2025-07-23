package com.umop.umop_backend.user.service;

import com.umop.umop_backend.user.dto.RegisterRequest;
import com.umop.umop_backend.user.entity.User;

public interface UserService {
	public User findUserById(Long id); 

	public User findUserByUserName(String name);

	public User registerUser(RegisterRequest newuser);
}
