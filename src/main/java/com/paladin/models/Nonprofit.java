package com.paladin.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="nonprofits")
@PrimaryKeyJoinColumn(name="organization_id")
public class Nonprofit extends Organization {

	@Column(name="primary_jurisdiction")
	private String primaryJurisdiction;

	@Column(name="insurance")
	private Boolean insurance;

	@Column(name="supervision")
	private Boolean supervision;
	
	@Column(name="supervision_type")
	private String supervisionType;

	@Column(name="overview")
	private String overview;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="organization_id")
	private Set<Opportunity> opportunities;


	public String getPrimaryJurisdiction() {
		return primaryJurisdiction;
	}

	public void setPrimaryJurisdiction(String primaryJurisdiction) {
		this.primaryJurisdiction = primaryJurisdiction;
	}

	public Boolean isInsurance() {
		return insurance;
	}

	public void setInsurance(Boolean insurance) {
		this.insurance = insurance;
	}

	public Boolean isSupervision() {
		return supervision;
	}

	public void setSupervision(Boolean supervision) {
		this.supervision = supervision;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}
	

	public String getSupervisionType() {
		return supervisionType;
	}

	public void setSupervisionType(String supervisionType) {
		this.supervisionType = supervisionType;
	}

	@Override
	public String toString() {
		String base = " name: " + getName() + "\n phoneNumber: " + getPhoneNumber() + "\n primaryJurisdiction: " + primaryJurisdiction + "\n insurance: " + insurance + "\n supervision: "
				+ supervision + "\n overview: " + overview;

		if (getLanguageSkills() != null && !getLanguageSkills().isEmpty()) {
			String languages = "\n languages:  ";
			for (LanguageSkill language : getLanguageSkills()) {
				languages+=language.getName() + ", ";
			}
			base+=languages;
		}
		if (getAdvocacyAreas() != null && !getAdvocacyAreas().isEmpty()) {
			String areas = "\n Advocacy Areas:  ";
			for (AdvocacyArea area : getAdvocacyAreas()) {
				areas+=area.getName() + ", ";
			}
			base+=areas;
		}

		if (getOpportunityTypes() != null && !getOpportunityTypes().isEmpty()) {
			String opTypes = "\n Opportunity Types:  ";
			for (OpportunityType type : getOpportunityTypes()) {
				opTypes+=type.getName() + ", ";
			}
			base+= opTypes;	
		}
		return base;
	}
}
