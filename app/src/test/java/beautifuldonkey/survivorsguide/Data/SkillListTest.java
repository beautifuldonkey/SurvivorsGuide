package beautifuldonkey.survivorsguide.Data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.List;

import beautifuldonkey.survivorsguide.Data.Profession;
import beautifuldonkey.survivorsguide.Data.ProfessionList;
import beautifuldonkey.survivorsguide.Data.Skill;
import beautifuldonkey.survivorsguide.Data.SkillList;

/**
 * basic unit test for skill lists
 * Created by jaw_m on 2/12/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class SkillListTest {

    @Mock
    SkillList testSkillList;

    @Mock
    ProfessionList testProfList;

    @Test
    public void getSkillListTest() {
        assertThat(testSkillList.getSkillList().size(),is(134));
    }

    @Test
    public void getSingleSkillByNameTest(){
        String testSkillName = "Backstab";
        String testSkillNameCheck = "Backstab";
        List<Skill> testSkill = testSkillList.getSkillsByName(testSkillName);
        assertThat(testSkill.get(0).getName(),is(testSkillNameCheck));
    }

    @Test
    public void getSkillsByNameTest(){
        List<Profession> professions = testProfList.getProfessionList();
        for(Profession prof : professions){
          System.out.println("Testing profession: "+prof.getName());
          String testSkillName = prof.getSkills();
          String[] testSkillsToCheck = testSkillName.split(",");
          List<Skill> testSkill = testSkillList.getSkillsByName(testSkillName);
          for(int i=0; i<testSkill.size(); i++){
            assertThat(testSkill.get(i).getName(), is(testSkillsToCheck[i]));
          }
          System.out.println("Profession passed");
        }
    }

    @Test
    public void getSkillsByNameSetCostTest(){
      List<Profession> professions = testProfList.getProfessionList();
      for(Profession prof : professions){
        System.out.println("Checking profession: "+prof.getName());
        String skillNames = prof.getSkills();
        String skillCosts = prof.getSkillCost();
        String[] skillCostsToCheck = skillCosts.split(",");
        List<Skill> skills = SkillList.getSkillsByNameSetCost(skillNames,skillCosts);
        for(int i=0; i<skills.size(); i++){
          Skill skill = skills.get(i);
          System.out.println("Checking skill: "+skill.getName());
          System.out.println("Act Cost: "+skill.getBuildCost());
          System.out.println("Exp Cost: "+skillCostsToCheck[i]);
          assertThat(skill.getBuildCost(),is(Integer.valueOf(skillCostsToCheck[i])));
          System.out.println("Skill passed.");
        }
        System.out.println("Profession passed.");
      }
    }
}