package com.imran.project.config.services;

import java.util.List;
import java.util.Set;

import com.imran.project.config.models.User;
import com.imran.project.config.models.UserRole;

public interface UserService {
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;

	public User save(User user);

	public User showUser(String email);

	public User fetchUserByEmailAndPassword(String email, String password);

	public List<User> findAll();

}
