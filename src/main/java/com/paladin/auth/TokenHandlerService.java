package com.paladin.auth;

import com.paladin.models.User;

public interface TokenHandlerService {
	
	String parseEmailFromToken(String token);
	
	String createTokenForUser(User user);

}
