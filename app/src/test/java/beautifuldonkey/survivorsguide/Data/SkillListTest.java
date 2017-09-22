package beautifuldonkey.survivorsguide.Data;

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

    private String testSkills = "Alert,Vanish,Teach,Rescue";

    @Mock
    private ProfessionList professionList;

    @Mock
    private StrainList strainList;

    @Test
    public void getSkillListTest() {
        List<Skill> skills = SkillList.getSkillList();
        assertThat(skills.size(),is(134));
      for (Skill skill: skills ) {
        assertThat(skill.getName(),notNullValue());
        assertThat(skill.getBuildCost(),notNullValue());
      }
    }

    @Test
    public void getSingleSkillByNameTest(){
        String testSkillName = "SCIENCE!";
        List<Skill> testSkill = SkillList.getSkillsByName(testSkillName);
        assertThat(testSkill.get(0).getName(),is(testSkillName));
    }

    @Test
    public void getSkillsByNameTest(){
      List<Skill> testList = SkillList.getSkillsByName(testSkills);
      for (Skill skill : testList){
        assertThat(testSkills,containsString(skill.getName()));
      }
    }

    @Test
    public void getSkillsByNameNullTest(){
      List<Skill> testNull = SkillList.getSkillsByName(null);
      assertThat(testNull.size(),is(0));
    }

    @Test
    public void getSkillsByNameSetCostTest(){
      String testCosts = "5,5,5,5";
      List<Skill> testList = SkillList.getSkillsByNameSetCost(testSkills,testCosts);
      for(Skill skill : testList){
        assertThat(skill.getName(),notNullValue());
        assertThat(skill.getBuildCost(),is(5));
      }

      List<Skill> testSingle = SkillList.getSkillsByNameSetCost("Alert","5");
      for(Skill skill : testSingle){
        assertThat(skill.getBuildCost(),is(5));
      }

    }

    @Test
    public void getSkillsByNameSetCostNullTest(){
      List<Skill> testNull = SkillList.getSkillsByNameSetCost(null,null);
      assertThat(testNull.size(),is(0));
    }

    @Test
    public void getOpenSkillsTest(){
      List<Skill> testOpenSkillList = SkillList.getOpenSkills();
      for(Skill skill : testOpenSkillList){
        assertThat(skill.getName(),notNullValue());
        assertThat(skill.getBuildCost(),notNullValue());
      }
    }

    @Test
    public void getProfSkillsTest(){
      List<Profession> profs = professionList.getProfessionList();
      for(Profession prof: profs){
        String profSkills = prof.getSkills();
        List<Skill> testList = SkillList.getSkillsByName(profSkills);
        for (Skill skill : testList){
          assertThat(skill.getName(),notNullValue());
        }
      }
    }

    @Test
    public void getStrainSkillsTest(){
      List<Strain> strains = strainList.getStrainList();
      for(Strain strain : strains){
        if(strain.getName().equals("Remnant")){ continue; }
        String strainSkills = strain.getSkills();
        List<Skill> foundStrainSkills = SkillList.getSkillsByName(strainSkills);
        for(Skill skill : foundStrainSkills){
          assertThat(skill.getName(),notNullValue());
        }
      }
    }

    @Test
    public void getAllSkillsTest(){
      List<Skill> testFullSkillList = SkillList.getSkillList();
      for(Skill skill : testFullSkillList){
        List<Skill> foundSkillList = SkillList.getSkillsByName(skill.getName());
        for(Skill foundSkill: foundSkillList){
          assertThat(foundSkill.getName(),notNullValue());
        }
      }
    }

    @Test
    public void skillTest(){

      String testName = "name";
      int testMpCost = 1;
      String testDesc = "desc";
      int testBuildCost = 2;
      int testCurrentRank = 3;
      int testAvailRank = 4;

      Skill testSkill = new Skill();

      testSkill.setName(testName);
      testSkill.setMpCost(testMpCost);
      testSkill.setDescription(testDesc);
      testSkill.setIsStrain(false);
      testSkill.setBuildCost(testBuildCost);
      testSkill.setCurrRank(testCurrentRank);
      testSkill.setAvailRank(testAvailRank);

      assertThat(testSkill.describeContents(),is(0));
      assertThat(testSkill.getName(),is(testName));
      assertThat(testSkill.getMpCost(),is(testMpCost));
      assertThat(testSkill.getDescription(),is(testDesc));
      assertThat(testSkill.getIsStrain(),is(false));
      assertThat(testSkill.getBuildCost(),is(testBuildCost));
      assertThat(testSkill.getCurrRank(),is(testCurrentRank));
      assertThat(testSkill.getAvailRank(),is(testAvailRank));
    }
}