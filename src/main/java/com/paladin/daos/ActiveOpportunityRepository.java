package com.paladin.daos;

import org.springframework.data.repository.CrudRepository;

import com.paladin.models.ActiveOpportunity;

public interface ActiveOpportunityRepository extends CrudRepository<ActiveOpportunity, Long> {
	ActiveOpportunity findByToken(String token);
}
