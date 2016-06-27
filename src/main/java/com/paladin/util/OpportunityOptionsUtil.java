package com.paladin.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpportunityOptionsUtil {
	
	public static class OpportunityType implements Serializable {
		private String displayName;
		private String name;
		
		public OpportunityType (String displayName, String name) {
			this.displayName = displayName;
			this.name = name;
		}

		public String getDisplayName() {
			return displayName;
		}

		public String getName() {
			return name;
		}
		
	}
	
	private static List<OpportunityType> options = new ArrayList<OpportunityType>(Arrays.asList(
			new OpportunityType("Litigation Drafting", "litigation"),
			new OpportunityType("Transactional Drafting", "transactional"),
			new OpportunityType("Courtroom", "courtroom"),
			new OpportunityType("Negotiation", "negotiation"),
			new OpportunityType("Policy", "policy"),
			new OpportunityType("Legal Counseling (primarily by phone)", "counseling"),
			new OpportunityType("Clinic", "clinic")));

	public static List<OpportunityType> getOptions() {
		return options;
	}
	
	

}
