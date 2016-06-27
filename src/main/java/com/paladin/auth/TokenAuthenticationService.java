package com.paladin.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.paladin.models.User;
import com.paladin.services.UserService;

@Service
public class TokenAuthenticationService {

	private static final String AUTH_HEADER_NAME = "Authorization";

    @Autowired
    private UserService userService;
    
    @Autowired
    private TokenHandlerService tokenHandler;
    
    
    
    public String addAuthentication(HttpServletResponse response, UserAuthentication authentication) {
        final User user = authentication.getDetails();
        String token = tokenHandler.createTokenForUser(user);
        response.addHeader(AUTH_HEADER_NAME, token);
        return token;
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        final String token = request.getHeader(AUTH_HEADER_NAME);      
        if (token != null) {
            String email = tokenHandler.parseEmailFromToken(token);
            User user = userService.findByEmail(email);
            if (user != null) {
                return new UserAuthentication(user, userService);
            }
        }
        return null;
    }
}
