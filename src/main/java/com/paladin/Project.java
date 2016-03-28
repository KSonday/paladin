package com.paladin;

import java.util.Set;

/**
 * Created by meghandow on 2/27/16.
 */
public class Project {
    private int id;
    private String description;
    private Set<Skill> skillsNeeded;
    private Set<Industry> industries;
    private Nonprofit nonprofit;
    private Contractor contractor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Skill> getSkillsNeeded() {
        return skillsNeeded;
    }

    public void setSkillsNeeded(Set<Skill> skillsNeeded) {
        this.skillsNeeded = skillsNeeded;
    }

    public Set<Industry> getIndustries() {
        return industries;
    }

    public void setIndustries(Set<Industry> industries) {
        this.industries = industries;
    }

    public Nonprofit getNonprofit() {
        return nonprofit;
    }

    public void setNonprofit(Nonprofit nonprofit) {
        this.nonprofit = nonprofit;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }
}
