package com.paladin.daos;

import org.springframework.data.repository.CrudRepository;

import com.paladin.models.ResetPasswordToken;

public interface ResetPasswordTokenRepository extends CrudRepository<ResetPasswordToken, Long> {

	ResetPasswordToken findByToken(String token);
}
