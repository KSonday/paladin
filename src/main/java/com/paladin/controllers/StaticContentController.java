package com.paladin.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paladin.util.AdvocacyOptionsUtil;
import com.paladin.util.LanguageOptionsUtil;
import com.paladin.util.OpportunityOptionsUtil;


@RestController
public class StaticContentController {
	
	@RequestMapping(value = "/auth/opportunityOptions", method = RequestMethod.GET)
    public String getAllOpportunityOptions() throws JsonProcessingException {
		ObjectMapper map = new ObjectMapper();
		return map.writeValueAsString(OpportunityOptionsUtil.getOptions());
    	
    }

	
	@RequestMapping(value = "/auth/languageOptions", method = RequestMethod.GET)
    public String getAllLanguageOptions() throws JsonProcessingException {
		ObjectMapper map = new ObjectMapper();
		return map.writeValueAsString(LanguageOptionsUtil.getOptions());
    	
    }
	
	@RequestMapping(value = "/auth/advocacyOptions", method = RequestMethod.GET)
    public String getAdvocacyOptions() throws JsonProcessingException {
		ObjectMapper map = new ObjectMapper();
		return map.writeValueAsString(AdvocacyOptionsUtil.getOptions());
    	
    }
}
