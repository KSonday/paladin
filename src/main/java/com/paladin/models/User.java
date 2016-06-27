package com.paladin.models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/**
 * Created by meghandow on 2/27/16.
 */
@Entity
@Table(name="users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5805162121291162493L;

	@Id
	@GeneratedValue
	private int id;

	@Column(name="email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "title")
	private String title;

	@Column(name = "user_type")
	private String userType;

	@Column(name = "state")
	private String state;

	@OneToOne(mappedBy="user")
	private UserProfile userProfile;
	
	@OneToOne(mappedBy="assignee")
	private Opportunity opportunity;

	@ManyToOne(optional=true)
	@JoinColumn(name="organization_id")
	//@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property = "type")
	@JsonSubTypes({
		@Type(value = Enterprise.class),
		@Type(value = Nonprofit.class)})
	private Organization organization;
	
	@ManyToMany
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id") )
    private Collection<Role> roles;

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	

	public void setId(int id) {
		this.id = id;
	}
	
	
	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return getState().equals("active");
	}

	@Override
	public String toString() {
		String base = " email: " + email + "\n firstName: " + firstName + "\n lastName: " + lastName + "\n title: " + title
				+ "\n userType: " + userType;
		
		if (getUserProfile() != null) {
			base += "\n userProfile: \n" + userProfile.toString();
		}
		if (getOrganization() != null) {
			base += "\n organization: \n" + organization.toString();
		}
		
		return base;
	}


}
