package com.paladin.daos;

import org.springframework.data.repository.CrudRepository;

import com.paladin.models.Privilege;


public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

	Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);
}
