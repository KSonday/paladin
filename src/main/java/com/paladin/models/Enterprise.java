package com.paladin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="enterprises")
@PrimaryKeyJoinColumn(name="organization_id")
public class Enterprise extends Organization {
	
	@Column(name="num_lawyers")
	private int numLawyers;
	
	@Column(name="has_program")
	private Boolean hasProgram;
	
	@Column(name="program_exp")
	private String programExp;
	
	@Column(name="org_type")
	private String orgType;

	public int getNumLawyers() {
		return numLawyers;
	}

	public void setNumLawyers(int numLawyers) {
		this.numLawyers = numLawyers;
	}
	public Boolean isHasProgram() {
		return hasProgram;
	}

	public void setHasProgram(Boolean hasProgram) {
		this.hasProgram = hasProgram;
	}

	public String getProgramExp() {
		return programExp;
	}

	public void setProgramExp(String programExp) {
		this.programExp = programExp;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	@Override
	public String toString() {
		return " name: " + getName() + "\n phoneNumber: " + getPhoneNumber() + "\n numLawyers: " + numLawyers + "\n hasProgram: " + hasProgram + "\n programExp: " + programExp
				+ "\n orgType: " + orgType;
		
//		String languages = " languages= ";
//		for (LanguageSkill language : getLanguageSkills()) {
//			languages+=language.getLanguage() + ", ";
//		}
//		String areas = "Advocacy Areas= ";
//		for (AdvocacyArea area : getAdvocacyAreas()) {
//			areas+=area.getArea() + ", ";
//		}
//		String opTypes = "Opportunity Types= ";
//		for (OpportunityType type : getOpportunityTypes()) {
//			opTypes+=type.getOpportunity() + ", ";
//		}
//		return base+languages+areas+opTypes;
	}

	
}
