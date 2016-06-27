package com.paladin.dtos;

import com.paladin.models.Opportunity;
import com.paladin.models.User;

public class UserOpportunityDTO {
	
	private User user;
	
	private Opportunity opportunity;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Opportunity getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(Opportunity opportunity) {
		this.opportunity = opportunity;
	}

	
}
