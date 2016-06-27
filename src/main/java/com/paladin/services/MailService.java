package com.paladin.services;

import java.util.List;

import com.paladin.models.ActiveOpportunity;
import com.paladin.models.User;

public interface MailService {
	 
	void sendProfile(User user);
	
	void sendMatchEmail(User user, List<ActiveOpportunity> opportunities);

}
