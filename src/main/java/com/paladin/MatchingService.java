package com.paladin;

import java.util.List;

/**
 * Created by meghandow on 2/27/16.
 */
public interface MatchingService {

    List<Project> getPossibleProjects(Contractor contractor);

    List<Project> getPossibleProjects(Contractor contractor, List<Project> projects);


}
