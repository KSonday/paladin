package com.paladin.services;

import com.paladin.models.ResetPasswordToken;

public interface RegistrationService extends TokenService<ResetPasswordToken> {
	
	boolean validateCredentials(String email, String password);
}
