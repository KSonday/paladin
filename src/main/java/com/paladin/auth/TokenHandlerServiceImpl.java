package com.paladin.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.paladin.models.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenHandlerServiceImpl implements TokenHandlerService {
	
    @Value("${jwt.secret.key}")
	private String secret;
	
    @Override
	public String parseEmailFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    @Override
    public String createTokenForUser(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
}
