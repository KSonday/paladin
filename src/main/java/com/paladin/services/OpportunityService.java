package com.paladin.services;

import java.util.List;

import com.paladin.models.ActiveOpportunity;
import com.paladin.models.Opportunity;
import com.paladin.models.User;

public interface OpportunityService  extends TokenService<ActiveOpportunity> {

	ActiveOpportunity createTokenObj(User user, Opportunity opportunity);
	
	List<ActiveOpportunity> createActiveOpportunities(User user, List<Opportunity> opportunities);
}
