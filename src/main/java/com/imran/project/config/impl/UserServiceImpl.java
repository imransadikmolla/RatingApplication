package com.imran.project.config.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imran.project.config.models.User;
import com.imran.project.config.models.UserRole;
import com.imran.project.config.repository.RoleRepository;
import com.imran.project.config.repository.UserRepository;
import com.imran.project.config.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local = this.userRepository.getUserByEmail(user.getEmail());
		if (local != null) {
			System.out.println("User exists");
			throw new Exception("User already present!");
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}

			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
			return local;
		}
	}

	public User save(User user) {
		return this.userRepository.save(user);
	}

	public User showUser(String email) {
		return this.userRepository.getUserByEmail(email);
	}

	public User fetchUserByEmailAndPassword(String email, String password) {
		return this.userRepository.findByEmailAndPassword(email, password);
	}

	public List<User> findAll() {
		return this.userRepository.findAll();
	}

}
