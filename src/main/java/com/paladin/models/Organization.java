package com.paladin.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="organizations")
@Inheritance(strategy=InheritanceType.JOINED)
public class Organization implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "organization_id")
    private Long organizationId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="display_name")
	private String displayName;
	
	@Column(name="form_type")
	private String formType;
	
	@Column(name="homepage_url")
	private String homepageUrl;
	
	@Column(name="contact_name")
	private String contactName;
	
	@Column(name="contact_email")
	private String contactEmail;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="organization_id")
	private Set<AdvocacyArea> advocacyAreas;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="organization_id")
	private Set<OpportunityType> opportunityTypes;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="organization_id")
	private Set<LanguageSkill> languageSkills;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="organization_id")
	@JsonIgnore
	private Set<User> users;

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getHomepageUrl() {
		return homepageUrl;
	}

	public void setHomepageUrl(String homepageUrl) {
		this.homepageUrl = homepageUrl;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}
}
