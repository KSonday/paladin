package com.paladin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paladin.auth.TokenAuthenticationService;
import com.paladin.auth.TokenHandlerService;
import com.paladin.dtos.Credentials;
import com.paladin.models.ResetPasswordToken;
import com.paladin.models.User;
import com.paladin.services.MailService;
import com.paladin.services.RegistrationService;
import com.paladin.services.UserService;

@RestController
public class AuthController {
	
	@Autowired
	RegistrationService registrationService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	TokenHandlerService tokenHandlerService;
	
	@Autowired
    MailService mailService;
	
	@Autowired
	TokenAuthenticationService tokenService;
	
    @RequestMapping(value = "/auth/resetPassword/verify", method = RequestMethod.POST)
    public @ResponseBody ResetPasswordToken verifyToken(@RequestBody String token) {
    	ResetPasswordToken tokenObj = registrationService.getTokenObjfromToken(token);
    	boolean verified = registrationService.verifyToken(tokenObj);
    	if (verified) {
    		return tokenObj;
    	}
    	else {
    		return null;
    	}  	
    }
    
    @RequestMapping(value = "/auth/resetPassword/reset", method = RequestMethod.POST)
    public ResponseEntity<Void> resetPassword(@RequestBody Credentials credentials) {
    	ResetPasswordToken token = registrationService.getTokenObjfromToken(credentials.getToken());
    	userService.setPassword(token.getUser(), credentials.getPassword());
    	token.setActive(false);
    	registrationService.save(token);
    	return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/auth/register", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user) {
    	user.setState("active");
        System.out.println("Creating User " + user.getEmail());
        userService.save(user);
        mailService.sendProfile(user);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public ResponseEntity<Credentials> getLoginToken(@RequestBody Credentials credentials) {
    	String email = credentials.getEmail();
    	boolean verified = registrationService.validateCredentials(email, credentials.getPassword());
    	if (verified) {
    		String token = tokenHandlerService.createTokenForUser(userService.findByEmail(credentials.getEmail()));
    		Credentials retCreds = new Credentials();
    		retCreds.setToken(token);
    		return new ResponseEntity<Credentials>(retCreds, HttpStatus.OK);
    	}
    	return new ResponseEntity<Credentials>(HttpStatus.BAD_REQUEST);
    }
}
