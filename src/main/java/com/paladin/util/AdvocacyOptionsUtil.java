package com.paladin.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdvocacyOptionsUtil {
	
	public static class AdvocacyOption implements Serializable {
		private String displayName;
		private String name;
		
		public AdvocacyOption (String displayName, String name) {
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
	
	private static List<AdvocacyOption> options = new ArrayList<AdvocacyOption>(Arrays.asList(
			new AdvocacyOption("Arts & Community Development", "arts"),
			new AdvocacyOption("Civil Rights", "civil"),
			new AdvocacyOption("Consumer", "consumer"),
			new AdvocacyOption("Criminal & Death Penalty", "criminal"),
			new AdvocacyOption("Debt/Credit/Bankruptcy", "finance"),
			new AdvocacyOption("Disability & Elder", "disability"),
			new AdvocacyOption("Disaster & Emergency Assistance", "disaster"),
			new AdvocacyOption("Education", "education"),
			new AdvocacyOption("Employment", "employment"),
			new AdvocacyOption("Environmental & Animal", "environment"),
			new AdvocacyOption("Entrepreneurship", "entrepreneurship"),
			new AdvocacyOption("Family & Juvenile", "family"),
			new AdvocacyOption("Health", "health"),
			new AdvocacyOption("Homeless", "homeless"),
			new AdvocacyOption("Housing, Foreclosure & Property", "housing"),
			new AdvocacyOption("Immigration", "immigration"),
			new AdvocacyOption("Intellectual Property", "IP"),
			new AdvocacyOption("International", "international"),
			new AdvocacyOption("LGBTQ", "LGBTQ"),
			new AdvocacyOption("Life Planning, Wills & Estates", "life"),
			new AdvocacyOption("Nonprofits", "nonprofits"),
			new AdvocacyOption("Public Benefits", "public"),
			new AdvocacyOption("Tax", "tax"),
			new AdvocacyOption("Veterans", "veterans"),
			new AdvocacyOption("Women's Rights", "women")));

	public static List<AdvocacyOption> getOptions() {
		return options;
	}

}
