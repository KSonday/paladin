package com.paladin.auth;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.paladin.models.User;
import com.paladin.services.UserService;

public class UserAuthentication implements Authentication {
	
    private final User user;
    private boolean authenticated = true;
    
    UserService userService;

    public UserAuthentication(User user, UserService userService) {
        this.user = user;
        this.userService = userService;
    }

    @Override
    public String getName() {
        return user.getEmail();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userService.getAuthorities(user.getRoles());
    }

    @Override
    public Object getCredentials() {
        return user.getPassword();
    }

    @Override
    public User getDetails() {
        return user;
    }

    @Override
    public Object getPrincipal() {
        return user.getEmail();
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
