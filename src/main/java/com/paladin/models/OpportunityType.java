package com.paladin.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="opportunity_types")
public class OpportunityType implements Serializable {
	
	@Id
	@GeneratedValue
    private int id;
	
	@Column(name="opportunity")
	private String name;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="user_profile_id")
	@JsonIgnore
	private UserProfile userProfile;

	@ManyToOne(optional=true)
	@JoinColumn(name="organization_id")
	@JsonIgnore
	private Organization organization;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="opportunity_id")
	@JsonIgnore
	private Opportunity opportunity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Opportunity getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(Opportunity opportunity) {
		this.opportunity = opportunity;
	}
}
