package com.paladin.daos;

import org.springframework.data.repository.CrudRepository;

import com.paladin.models.Opportunity;

public interface OpportunityRepository extends CrudRepository<Opportunity, Long> {

}
