package com.paladin.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordCrypto {
	
    private PasswordEncoder passwordEncoder;

    
    public PasswordEncoder getEncoder() {
        if(passwordEncoder == null) {
        	passwordEncoder = new BCryptPasswordEncoder();
        }
        return passwordEncoder;
    }


    public String encode(String str) {
        return getEncoder().encode(str);
    }

}
