package beautifuldonkey.survivorsguide.Data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.List;

/**
 * basic unit test for skill lists
 * Created by jaw_m on 2/12/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class SkillListTest {

    @Mock
    SkillList testSkillList;

    String testSkills = "Alert,Teach";
    String testCosts = "5,5";

    @Test
    public void getSkillListTest() {
        List<Skill> skills = testSkillList.getSkillList();
        assertThat(skills.size(),is(134));
      for (Skill skill: skills ) {
        assertThat(skill.getBuildCost(),notNullValue());
        assertThat(skill.getBuildCost(),not(0));
      }
    }

    @Test
    public void getSingleSkillByNameTest(){
        String testSkillName = "Alert";
        String testSkillNameCheck = "Alert";
        List<Skill> testSkill = testSkillList.getSkillsByName(testSkillName);
        assertThat(testSkill.get(0).getName(),is(testSkillNameCheck));
    }

    @Test
    public void getSkillsByNameTest(){
      List<Skill> testList = testSkillList.getSkillsByName(testSkills);
      for (Skill skill : testList){
        assertThat(testSkills,containsString(skill.getName()));
      }
    }

    @Test
    public void getSkillsByNameSetCostTest(){
      List<Skill> testList = testSkillList.getSkillsByNameSetCost(testSkills,testCosts);
      for(Skill skill : testList){
        assertThat(skill.getBuildCost(),is(5));
      }
    }
}