package com.paladin.services;

import com.paladin.models.User;

public interface TokenService<T> {

	T createTokenObj(User user);

	void save(T token);

	String getUrl(T token);


	boolean verifyToken(T token);

	T getTokenObjfromToken(String token);

}
