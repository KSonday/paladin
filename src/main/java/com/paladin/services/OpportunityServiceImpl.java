package com.paladin.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.paladin.daos.ActiveOpportunityRepository;
import com.paladin.models.ActiveOpportunity;
import com.paladin.models.Opportunity;
import com.paladin.models.User;
import com.paladin.util.TokenUtil;

@Service("opportunityService")
public class OpportunityServiceImpl implements OpportunityService {

	@Autowired
	ActiveOpportunityRepository activeOpportunityRepository;

	@Value("${base.url}")
	private String baseUrl;

	@Override
	public ActiveOpportunity createTokenObj(User user) {
		ActiveOpportunity opp = new ActiveOpportunity();
		opp.setActive(true);
		opp.setToken(TokenUtil.generateToken());
		opp.setUser(user);
		activeOpportunityRepository.save(opp);
		return opp;
	}
	
	@Override
	public ActiveOpportunity createTokenObj(User user, Opportunity opportunity) {
		ActiveOpportunity opp = new ActiveOpportunity();
		opp.setActive(true);
		opp.setToken(TokenUtil.generateToken());
		opp.setUser(user);
		opp.setOpportunity(opportunity);
		activeOpportunityRepository.save(opp);
		return opp;
	}
	
	@Override
	public List<ActiveOpportunity> createActiveOpportunities(User user, List<Opportunity> opportunities) {
		List<ActiveOpportunity> activeOpps = new ArrayList<>();
		for (Opportunity opp : opportunities) {
			activeOpps.add(createTokenObj(user, opp));
		}
		return activeOpps;
		
	}

	@Override
	public void save(ActiveOpportunity token) {
		activeOpportunityRepository.save(token);
	}

	@Override
	public boolean verifyToken(ActiveOpportunity token) {
		return token != null && token.getActive();
	}

	@Override
	public ActiveOpportunity getTokenObjfromToken(String token) {
		return activeOpportunityRepository.findByToken(token);
	}

	@Override
	public String getUrl(ActiveOpportunity token) {
		return baseUrl + "/#/opportunity/" + token.getToken();
	}



	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
}
