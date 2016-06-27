package com.paladin.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="user_profiles")
public class  UserProfile implements Serializable {
	
	@Id
	@GeneratedValue
    private int id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	@Column(name="employer")
	private String employer;

	@Column(name="practice_area")
	private String practiceArea;

	@Column(name="experience_level")
	private String experienceLevel;

	@Column(name="primary_jurisdiction")
	private String primaryJurisdiction;

	@Column(name="time_commitment")
	private String timeCommitment;
	
	@Column(name="commitment_duration")
	private String commitmentDuration;

	@Column(name="insurance")
	private Boolean hasInsurance;

	@Column(name="supervision")
	private Boolean supervision;
	
	@Column(name="supervision_type")
	private String supervisionType;

	@Column(name="previous_experience")
	private Boolean previousExperience;

	@Column(name="experience")
	private String experience;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="user_profile_id")
	private Set<LanguageSkill> languageSkills;


	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="user_profile_id")
	private Set<AdvocacyArea> advocacyAreas;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="user_profile_id")
	private Set<OpportunityType> opportunityTypes;

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getPracticeArea() {
		return practiceArea;
	}

	public void setPracticeArea(String practiceArea) {
		this.practiceArea = practiceArea;
	}



	public String getPrimaryJurisdiction() {
		return primaryJurisdiction;
	}

	public void setPrimaryJurisdiction(String primaryJurisdiction) {
		this.primaryJurisdiction = primaryJurisdiction;
	}


	public Boolean isHasInsurance() {
		return hasInsurance;
	}

	public void setHasInsurance(Boolean hasInsurance) {
		this.hasInsurance = hasInsurance;
	}

	public Boolean isSupervision() {
		return supervision;
	}

	public void setSupervision(Boolean supervision) {
		this.supervision = supervision;
	}
	

	public String getSupervisionType() {
		return supervisionType;
	}

	public void setSupervisionType(String supervisionType) {
		this.supervisionType = supervisionType;
	}

	public Boolean isPreviousExperience() {
		return previousExperience;
	}

	public void setPreviousExperience(Boolean previousExperience) {
		this.previousExperience = previousExperience;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getExperienceLevel() {
		return experienceLevel;
	}

	public void setExperienceLevel(String experienceLevel) {
		this.experienceLevel = experienceLevel;
	}

	public String getTimeCommitment() {
		return timeCommitment;
	}

	public void setTimeCommitment(String timeCommitment) {
		this.timeCommitment = timeCommitment;
	}
	

	public String getCommitmentDuration() {
		return commitmentDuration;
	}

	public void setCommitmentDuration(String commitmentDuration) {
		this.commitmentDuration = commitmentDuration;
	}

	public Set<LanguageSkill> getLanguageSkills() {
		return languageSkills;
	}

	public void setLanguageSkills(Set<LanguageSkill> languageSkills) {
		this.languageSkills = languageSkills;
	}

	public Set<AdvocacyArea> getAdvocacyAreas() {
		return advocacyAreas;
	}

	public void setAdvocacyAreas(Set<AdvocacyArea> advocacyAreas) {
		this.advocacyAreas = advocacyAreas;
	}

	public Set<OpportunityType> getOpportunityTypes() {
		return opportunityTypes;
	}

	public void setOpportunityTypes(Set<OpportunityType> opportunityTypes) {
		this.opportunityTypes = opportunityTypes;
	}

	@Override
	public String toString() {
		String base = " employer: " + employer + "\n practiceArea: " + practiceArea + "\n experienceLevel: "
				+ experienceLevel + "\n primaryJurisdiction: " + primaryJurisdiction + "\n timeCommitment: "
				+ timeCommitment + "\n commitmentDuration: " + commitmentDuration + "\n hasInsurance: " + hasInsurance + "\n needsSupervision: " + supervision
				+ "\n supervisionType: " + supervisionType + "\n previousExperience: " + previousExperience + "\n experience: " + experience;
				
		if (languageSkills != null) {
				String languages = "\n languages:  ";
				for (LanguageSkill language : languageSkills) {
					languages+=language.getName() + ", ";
				}
				base += languages;
		}
		if (advocacyAreas != null) {
				String areas = "\n Advocacy Areas:  ";
				for (AdvocacyArea area : advocacyAreas) {
					areas+=area.getName() + ", ";
				}
				base += areas;
		}
		if (opportunityTypes != null) {
				String opTypes = "\n Skills: ";
				for (OpportunityType type : opportunityTypes) {
					opTypes+=type.getName() + ", ";
				}
				base +=opTypes;
		}
		return base;
	}
}
