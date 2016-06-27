package com.paladin.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="opportunities")
public class Opportunity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column
	private String description;
	
	@Column(name="time_commitment")
	private String timeCommitment;
	
	@Column(name="commitment_duration")
	private String commitmentDuration;
	
	@Column(name="experience_level")
	private String experienceLevel;
	
	@Column(name="training")
	private String training;
	
	@Column(name="training_duration")
	private String trainingDuration;
	
	@Column(name="cle_credit")
	private Boolean cleCredit;
	

	@ManyToOne
	@JoinColumn(name="organization_id")
	private Nonprofit nonprofit;
	
	@OneToOne(optional=true)
	@JoinColumn(name="asignee_id")
	private User assignee;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="opportunity_id")
	private Set<AdvocacyArea> advocacyAreas;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="opportunity_id")
	private Set<OpportunityType> opportunityTypes;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="opportunity_id")
	private Set<LanguageSkill> languageSkills;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Nonprofit getNonprofit() {
		return nonprofit;
	}

	public void setNonprofit(Nonprofit nonprofit) {
		this.nonprofit = nonprofit;
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

	public Set<LanguageSkill> getLanguageSkills() {
		return languageSkills;
	}

	public void setLanguageSkills(Set<LanguageSkill> languageSkills) {
		this.languageSkills = languageSkills;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
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

	public String getExperienceLevel() {
		return experienceLevel;
	}

	public void setExperienceLevel(String experienceLevel) {
		this.experienceLevel = experienceLevel;
	}

	public String getTraining() {
		return training;
	}

	public void setTraining(String training) {
		this.training = training;
	}

	public String getTrainingDuration() {
		return trainingDuration;
	}

	public void setTrainingDuration(String trainingDuration) {
		this.trainingDuration = trainingDuration;
	}

	public Boolean getCleCredit() {
		return cleCredit;
	}

	public void setCleCredit(Boolean cleCredit) {
		this.cleCredit = cleCredit;
	}
}
