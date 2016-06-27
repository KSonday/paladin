package com.paladin.services;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.paladin.models.Role;
import com.paladin.models.User;

public interface UserService extends UserDetailsService {
	User findByEmail(String email);

	void save(User user);

	User findById(Long id);

	Iterable<User> findAllUsers();

	boolean isUserExist(User user);
	
	Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles);
	
	void setPassword(User user, String unEncryptedPassword);
}
