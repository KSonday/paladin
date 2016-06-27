package com.paladin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paladin.daos.EnterpriseRepository;
import com.paladin.models.Enterprise;

@RestController
public class EnterpriseController {
	
	@Autowired
	private EnterpriseRepository enterpriseRepository;
	
	@RequestMapping(value = "/enterprises/get", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Enterprise> getEnterprise(@RequestBody String enterpriseName) {
		Enterprise enterprise = enterpriseRepository.findByName(enterpriseName);
		if (enterprise != null) {
			return new ResponseEntity<Enterprise>(enterprise, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Enterprise>(HttpStatus.BAD_REQUEST);
		}
	}


}
