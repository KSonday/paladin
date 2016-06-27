package com.paladin.daos;

import org.springframework.data.repository.CrudRepository;

import com.paladin.models.Nonprofit;

public interface NonprofitRepository extends CrudRepository<Nonprofit, Long> {

}
