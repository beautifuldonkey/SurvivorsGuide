package beautifuldonkey.survivorsguide.Data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * basic unit test for profession lists
 * Created by jaw_m on 2/14/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProfessionListTest {

  @Test
  public void getProfessionListTest(){
    assertThat(ProfessionList.getProfessionList().size(),is(38));
  }

  @Test
  public void getProfessionByNameTest(){
    List <Profession> professionList = ProfessionList.getProfessionList();
    for (Profession profession : professionList){
      Profession foundProfession = ProfessionList.getProfessionByName(profession.getName());
      assertThat(foundProfession.getName(),is(profession.getName()));
    }
  }

  @Test
  public void getProfessionByNameNullTest(){
    Profession testNull = ProfessionList.getProfessionByName(null);
    assertThat(testNull.getName(),is(nullValue()));
  }

  @Test
  public void getProfessionListValidityTest(){
    List<Profession> professions = ProfessionList.getProfessionList();
    for(Profession prof : professions){
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