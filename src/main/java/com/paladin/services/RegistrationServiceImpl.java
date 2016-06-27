package com.paladin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.paladin.daos.ResetPasswordTokenRepository;
import com.paladin.models.ResetPasswordToken;
import com.paladin.models.User;
import com.paladin.util.PasswordCrypto;
import com.paladin.util.TokenUtil;

@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	private ResetPasswordTokenRepository tokenRepository;
	
	@Autowired
	private UserService userService;
	
    @Autowired
    private PasswordCrypto pwCrypto;

	@Value("${base.url}")
	private String baseUrl;

	
	@Override
	public ResetPasswordToken createTokenObj(User user) {
		ResetPasswordToken token = new ResetPasswordToken();
		token.setActive(true);
		token.setToken(TokenUtil.generateToken());
		token.setUser(user);
		tokenRepository.save(token);
		return token;
	}
	
	@Override
	public void save(ResetPasswordToken token) {
		tokenRepository.save(token);
	}
	
	@Override
	public boolean verifyToken(ResetPasswordToken token) {
		return token != null && token.getActive();
		
		
	}
	
	@Override
	public ResetPasswordToken getTokenObjfromToken(String token) {
		return tokenRepository.findByToken(token);
	}
	
	@Override
	public String getUrl(ResetPasswordToken token) {
		return baseUrl + "/resetPassword/" + token.getToken();
	}
	
	@Override
	public boolean validateCredentials(String email, String password) {
		User user = userService.findByEmail(email);
		if (user != null) {
			return pwCrypto.getEncoder().matches(password, user.getPassword());
		}
		return false;
	}

	
	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
}
