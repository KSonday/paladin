import com.paladin.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by meghandow on 2/28/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/servlet-context-test.xml" })
public class MatchingServiceUnitTest {

    @Autowired
    MatchingService matchingService;

    @Test
    public void testGetPossibleProjects() {
        Contractor contractor = createContractor();

        List<Project> projects = new ArrayList<Project>();
        Set<Skill> skills = new HashSet<Skill>();
        skills.add(Skill.attorney);
        Set<Industry> industries = new HashSet<Industry>();
        industries.add(Industry.healthcare);
        Project project = new Project();
        project.setIndustries(industries);
        project.setSkillsNeeded(skills);
        projects.add(project);


        Set<Skill> skills2 = new HashSet<Skill>();
        skills2.add(Skill.engineer);
        Set<Industry> industries2 = new HashSet<Industry>();
        industries2.add(Industry.healthcare);
        industries2.add(Industry.womensRights);
        Project project2 = new Project();
        project2.setIndustries(industries2);
        project2.setSkillsNeeded(skills2);
        projects.add(project2);

        Set<Skill> skills3 = new HashSet<Skill>();
        skills3.add(Skill.attorney);
        Set<Industry> industries3 = new HashSet<Industry>();
        industries3.add(Industry.lgbtRights);
        Project project3 = new Project();
        project3.setIndustries(industries3);
        project3.setSkillsNeeded(skills3);
        projects.add(project3);

        List<Project> matchedProjects = matchingService.getPossibleProjects(contractor, projects);
        Assert.assertEquals(matchedProjects.size(), 1);
    }

    public static Contractor createContractor() {
        Contractor contractor = new Contractor();

        contractor.setName("Olivia Pope");
        Set<Skill> skills = new HashSet<Skill>();
        skills.add(Skill.attorney);
        Set<Industry> industries = new HashSet<Industry>();
        industries.add(Industry.healthcare);
        industries.add(Industry.womensRights);
        contractor.setSkills(skills);
        contractor.setIndustries(industries);

        return contractor;
    }
}

