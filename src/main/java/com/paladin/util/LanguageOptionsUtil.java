package com.paladin.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LanguageOptionsUtil {
	
	public static class LanguageOption implements Serializable {
		private String displayName;
		private String name;
		
		public LanguageOption (String displayName, String name) {
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
	
	private static List<LanguageOption> options = new ArrayList<LanguageOption>(Arrays.asList(
			new LanguageOption("English", "english"),
			new LanguageOption("Spanish", "spanish"),
			new LanguageOption("Chinese", "chinese"),
			new LanguageOption("Tagalog", "tagalog"),
			new LanguageOption("Vietnamese", "vietnamese"),
			new LanguageOption("French", "french"),
			new LanguageOption("German", "german"),
			new LanguageOption("Korean", "korean"),
			new LanguageOption("Arabic", "arabic"),
			new LanguageOption("Russian", "russian"),
			new LanguageOption("Italian", "italian")));

	public static List<LanguageOption> getOptions() {
		return options;
	}

}
