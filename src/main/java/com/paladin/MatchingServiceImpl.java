package com.paladin;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by meghandow on 2/27/16.
 */
@Service
public class MatchingServiceImpl implements MatchingService {

    /**
     * If this were hooked up to a data source, it would call the relevant DAO to find relevant projects for a
     *passed in contractor
     * @param contractor
     * @return List<Project>
     */
    @Override
    public List<Project> getPossibleProjects(Contractor contractor) {
        return new ArrayList<Project>();
    }

    /**
     * Filters the relevant projects (matching skill and industry) for a given contractor and project list
     *
     * @param contractor
     * @param projects
     * @return List<Project>
     */
    @Override
    public List<Project> getPossibleProjects(Contractor contractor, List<Project> projects) {
        List<Project> possibleProjects = new ArrayList<Project>();
        for (Project project : projects) {
            if (project.getContractor() == null) {
                Set<Skill> skillIntersect = new HashSet<Skill>(contractor.getSkills());
                skillIntersect.retainAll(project.getSkillsNeeded());
                Set<Industry> industryIntersect = new HashSet<Industry>(contractor.getIndustries());
                industryIntersect.retainAll(project.getIndustries());
                if (!skillIntersect.isEmpty() && !industryIntersect.isEmpty()) {
                    possibleProjects.add(project);
                }
            }
        }
        return possibleProjects;
    }
}
