package com.paladin.daos;

import org.springframework.data.repository.CrudRepository;

import com.paladin.models.Enterprise;

public interface EnterpriseRepository extends CrudRepository<Enterprise, Long> {
	Enterprise findByName(String name);
}
