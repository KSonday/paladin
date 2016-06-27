package com.paladin.daos;

import org.springframework.data.repository.CrudRepository;

import com.paladin.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByEmail(String email);
}
