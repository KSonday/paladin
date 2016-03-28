package com.paladin;

/**
 * Created by meghandow on 2/27/16.
 */
public enum Industry {
    womensRights("Women's Rights"),
    lgbtRights("LGBT Rights"),
    healthcare("Healthcare");

    private String displayName;

    Industry(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
