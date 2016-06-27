package com.paladin.dtos;

import java.util.List;

import com.paladin.models.Opportunity;
import com.paladin.models.User;

public class MatchEmail {
	
	private User user;
	private List<Opportunity> opportunities;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Opportunity> getOpportunities() {
		return opportunities;
	}
	public void setOpportunities(List<Opportunity> opportunities) {
		this.opportunities = opportunities;
	}
}
