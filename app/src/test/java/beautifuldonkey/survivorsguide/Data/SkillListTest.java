package beautifuldonkey.survivorsguide.Data;

import android.content.Intent;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.List;

/**
 * basic unit test for skill lists & skills
 * Created by jaw_m on 2/12/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class SkillListTest {

    @Mock
    SkillList testSkillList;

    @Mock
    Intent testIntent;

    String testSkills = "Alert,Teach";
    String testCosts = "5,5";

    @Test
    public void getSkillListTest() {
        List<Skill> skills = testSkillList.getSkillList();
        assertThat(skills.size(),is(134));
      for (Skill skill: skills ) {
        assertThat(skill.getName(),notNullValue());
        assertThat(skill.getBuildCost(),notNullValue());
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

      List<Skill> testSingle = testSkillList.getSkillsByNameSetCost("Alert","5");
      for(Skill skill : testSingle){
        assertThat(skill.getBuildCost(),is(5));
      }

    }

    @Test
    public void getOpenSkillsTest(){
      List<Skill> testOpenSkillList = testSkillList.getOpenSkills();
      for(Skill skill : testOpenSkillList){
        assertThat(skill.getName(),notNullValue());
        assertThat(skill.getBuildCost(),notNullValue());
      }
    }

    @Test
    public void skillTest(){

      String testName = "name";
      int testMpCost = 1;
      String testDesc = "desc";
      Boolean testIsStrain = false;
      int testBuildCost = 2;
      int testCurrentRank = 3;
      int testAvailRank = 4;

      Skill testSkill = new Skill();

      testSkill.setName(testName);
      testSkill.setMpCost(testMpCost);
      testSkill.setDescription(testDesc);
      testSkill.setIsStrain(testIsStrain);
      testSkill.setBuildCost(testBuildCost);
      testSkill.setCurrRank(testCurrentRank);
      testSkill.setAvailRank(testAvailRank);

      assertThat(testSkill.describeContents(),is(0));
      assertThat(testSkill.getName(),is(testName));
      assertThat(testSkill.getMpCost(),is(testMpCost));
      assertThat(testSkill.getDescription(),is(testDesc));
      assertThat(testSkill.getIsStrain(),is(testIsStrain));
      assertThat(testSkill.getBuildCost(),is(testBuildCost));
      assertThat(testSkill.getCurrRank(),is(testCurrentRank));
      assertThat(testSkill.getAvailRank(),is(testAvailRank));

    }
}