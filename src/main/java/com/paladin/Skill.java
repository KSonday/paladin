package com.paladin;

/**
 * Created by meghandow on 2/27/16.
 */
public enum Skill {
    attorney("Attorney"),
    entrepreneur("Entrepreneur"),
    engineer("Engineer");

    private String displayName;

    Skill(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
