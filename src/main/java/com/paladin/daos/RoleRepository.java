package com.paladin.daos;

import org.springframework.data.repository.CrudRepository;

import com.paladin.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	Role findByName(String name);

	@Override
	void delete(Role role);
}
