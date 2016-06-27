package com.paladin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paladin.models.ActiveOpportunity;
import com.paladin.services.OpportunityService;

@RestController
public class OpportunityController {
	
	@Autowired
	OpportunityService opportunityService;

	
	@RequestMapping(value = "/opportunity/verify", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<ActiveOpportunity> verifyToken(@RequestBody String token) {
    	ActiveOpportunity tokenObj = opportunityService.getTokenObjfromToken(token);
    	boolean verified = opportunityService.verifyToken(tokenObj);
    	if (verified) {
    		return new ResponseEntity<ActiveOpportunity>(tokenObj, HttpStatus.OK);
    	}
    	else {
    		return new ResponseEntity<ActiveOpportunity>(HttpStatus.BAD_REQUEST);
    	}  	
    }
	
	@RequestMapping(value = "/opportunity/select", method = RequestMethod.POST)
    public ResponseEntity<Void> selectOpportunity(@RequestBody String token) {
		ActiveOpportunity tokenObj = opportunityService.getTokenObjfromToken(token);
		tokenObj.setActive(false);
		tokenObj.getOpportunity().setAssignee(tokenObj.getUser());
		opportunityService.save(tokenObj);
    	return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
