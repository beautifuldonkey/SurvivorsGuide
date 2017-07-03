package beautifuldonkey.survivorsguide.Data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import beautifuldonkey.survivorsguide.Data.ProfessionList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * basic unit test for profession lists
 * Created by jaw_m on 2/14/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProfessionListTest {

  @Mock
  ProfessionList testProfList;

  @Test
  public void getProfessionListTest(){
    assertThat(testProfList.getProfessionList().size(),is(38));
  }

  @Test
  public void getProfessionByNameTest(){
    assertThat(testProfList.getProfessionByName("Assassin").getName(), is("Assassin"));
  }

  @Test
  public void getProfessionListValidityTest(){
    List<Profession> professions = testProfList.getProfessionList();
    for(Profession prof : professions){
      String profName = prof.getName();
      System.out.println("Profession being tested: "+prof.getName());
      String[] profSkillNames =  prof.getSkills().split(",");
      String[] profSkillCosts = prof.getSkillCost().split(",");
      assertThat(profSkillNames.length, is(profSkillCosts.length));
      System.out.println("Profession passed");
    }
  }

  @Test
  public void testProfession(){
    String testName = "name";
    String testDescription = "desc";
    String testSkills = "Alert";
    String testStrainReqs = "reqs";
    String testSkillCost = "cost";

    Profession testProf = new Profession();

    testProf.setName(testName);
    testProf.setDescription(testDescription);
    testProf.setSkills(testSkills);
    testProf.setStrainReqs(testStrainReqs);
    testProf.setSkillCost(testSkillCost);

    assertThat(testProf.getName(),is(testName));
    assertThat(testProf.getDescription(),is(testDescription));
    assertThat(testProf.getSkills(),is(testSkills));
    assertThat(testProf.getStrainReqs(),is(testStrainReqs));
    assertThat(testProf.getSkillCost(),is(testSkillCost));
  }
}