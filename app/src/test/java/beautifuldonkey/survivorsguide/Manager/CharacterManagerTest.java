package beautifuldonkey.survivorsguide.Manager;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import beautifuldonkey.survivorsguide.Data.PlayerCharacter;
import beautifuldonkey.survivorsguide.Data.Profession;
import beautifuldonkey.survivorsguide.Data.Skill;
import beautifuldonkey.survivorsguide.Data.Strain;

/**
 * Defines tests for CharacterManager functions
 * Created by jaw_m on 6/19/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class CharacterManagerTest {

  @Mock
  CharacterManager testCharMgr;

  @Test
  public void updateAvailableSkillListTest(){
    Profession testProfOne = new Profession();
    Profession testProfTwo = new Profession();
    Profession testProfThree = new Profession();
    Strain testStrain = new Strain("name",2,3,1,"Parry","desc");

    testProfOne.setSkills("Alert");
    testProfTwo.setSkills("Alert,Backstab");
    testProfThree.setSkills("Barricade");

    List<Skill> responseSkills = testCharMgr.updateAvailableSkillList(testProfOne,testProfTwo,testProfThree,testStrain);

    assertThat(responseSkills.size(),is(24));

  }

  @Test
  public void isCharacterValidTest(){
    List<Profession> testProfListInvalid = new ArrayList<>();
    List<Profession> testProfListValid = new ArrayList<>();
    List<Skill> testSkillList = new ArrayList<>();

    Profession testProf = new Profession();
    testProfListValid.add(testProf);

    PlayerCharacter testInvalidChar = new PlayerCharacter("","","","","",testProfListInvalid,testSkillList,"","");
    PlayerCharacter testValidChar = new PlayerCharacter("name","12","11","strain","3",testProfListValid,testSkillList,"5","2");

    assertThat(testCharMgr.isCharacterValid(testInvalidChar),is(false));
    assertThat(testCharMgr.isCharacterValid(testValidChar),is(true));
  }
}
