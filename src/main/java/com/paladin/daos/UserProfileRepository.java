package com.paladin.daos;

import org.springframework.data.repository.CrudRepository;

import com.paladin.models.UserProfile;

public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {

}
