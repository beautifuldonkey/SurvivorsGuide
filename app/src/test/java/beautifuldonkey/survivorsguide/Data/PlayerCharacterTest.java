package beautifuldonkey.survivorsguide.Data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests the character class extended to the user
 * Created by jaw_m on 7/3/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class PlayerCharacterTest {

  @Test
  public void playerCharacterTest(){
    String testName = "name";
    String testHealth = "health";
    String testMind = "mind";
    String testStrain = "strain";
    String testInf = "infec";
    List<Profession> testProfList = new ArrayList<>();
    List<Skill> testSkillList = new ArrayList<>();
    String testAvailBuild = "build";
    String testReqBuild = "build";

    PlayerCharacter testChar = new PlayerCharacter();

    testChar.setName(testName);
    testChar.setHealth(testHealth);
    testChar.setMind(testMind);
    testChar.setStrain(testStrain);
    testChar.setInfection(testInf);
    testChar.setProfessions(testProfList);
    testChar.setSelectedSkills(testSkillList);
    testChar.setAvailBuild(testAvailBuild);
    testChar.setRequiredBuild(testReqBuild);

    assertThat(testChar.getName(),is(testName));
    assertThat(testChar.getHealth(),is(testHealth));
    assertThat(testChar.getMind(),is(testMind));
    assertThat(testChar.getStrain(),is(testStrain));
    assertThat(testChar.getInfection(),is(testInf));
    assertThat(testChar.getProfessions(),is(testProfList));
    assertThat(testChar.getSelectedSkills(),is(testSkillList));
    assertThat(testChar.getAvailBuild(),is(testAvailBuild));
    assertThat(testChar.getRequiredBuild(),is(testReqBuild));

    PlayerCharacter testChar2 = new PlayerCharacter(testName,testHealth,testMind,testStrain,testInf,testProfList,testSkillList,testAvailBuild,testReqBuild);

    assertThat(testChar2.getName(),is(testName));

  }
}
