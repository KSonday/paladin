package com.paladin.util;

import org.apache.commons.lang3.RandomStringUtils;

public class TokenUtil {
	
	public static String generateToken() {
		return RandomStringUtils.randomAlphanumeric(70);
	}

}
