package com.paladin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.paladin.daos.EnterpriseRepository;
import com.paladin.daos.NonprofitRepository;
import com.paladin.daos.OpportunityRepository;
import com.paladin.daos.UserRepository;
import com.paladin.dtos.MatchEmail;
import com.paladin.dtos.UserOpportunityDTO;
import com.paladin.models.ActiveOpportunity;
import com.paladin.models.Enterprise;
import com.paladin.models.Nonprofit;
import com.paladin.models.Opportunity;
import com.paladin.models.User;
import com.paladin.services.MailService;
import com.paladin.services.OpportunityService;

@RestController
public class AdminController {

	@Autowired
	private NonprofitRepository nonprofitRepository;

	@Autowired
	private OpportunityRepository opportunityRepository;
	
	@Autowired
	private EnterpriseRepository enterpriseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	OpportunityService opportunityService;

	@RequestMapping(value = "/api/nonprofits/all", method = RequestMethod.GET)
	public @ResponseBody List<Nonprofit> getNonprofits() {
		return Lists.newArrayList(nonprofitRepository.findAll());  	
	}
	
	@RequestMapping(value = "/api/enterprises/all", method = RequestMethod.GET)
	public @ResponseBody List<Enterprise> getEnterprises() {
		return Lists.newArrayList(enterpriseRepository.findAll());  	
	}
	
	@RequestMapping(value = "/api/opportunities/all", method = RequestMethod.GET)
	public @ResponseBody List<Opportunity> getOpportunities() {
		return Lists.newArrayList(opportunityRepository.findAll());  	
	}


	@RequestMapping(value = "/api/opportunity/submit", method = RequestMethod.POST)
	public ResponseEntity<Void> createOpportunity(@RequestBody Opportunity opportunity) {
		opportunityRepository.save(opportunity);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/api/nonprofit/submit", method = RequestMethod.POST)
	public ResponseEntity<Void> createNonprofit(@RequestBody Nonprofit nonprofit) {
		nonprofitRepository.save(nonprofit);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/api/enterprise/submit", method = RequestMethod.POST)
	public ResponseEntity<Void> createEnterprise(@RequestBody Enterprise enterprise) {
		enterpriseRepository.save(enterprise);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/api/users/all", method = RequestMethod.GET)
	public @ResponseBody List<User> getUsers() {
		return Lists.newArrayList(userRepository.findAll());  	
	}
	
	@RequestMapping(value = "/api/users/sendMatchEmail", method = RequestMethod.POST)
	public ResponseEntity<Void> sendMatchEmail(@RequestBody MatchEmail matchEmail) {
		List<ActiveOpportunity> activeOpps = opportunityService.createActiveOpportunities(matchEmail.getUser(), matchEmail.getOpportunities());
		mailService.sendMatchEmail(matchEmail.getUser(), activeOpps);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/users/pairOpportunity", method = RequestMethod.POST)
	public ResponseEntity<Void> pairOpportunity(@RequestBody UserOpportunityDTO userOppDTO) {
		Opportunity opportunity = userOppDTO.getOpportunity();
		opportunity.setAssignee(userOppDTO.getUser());
		opportunityRepository.save(opportunity);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	 
}
