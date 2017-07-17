package beautifuldonkey.survivorsguide.Manager;

import android.content.Context;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static junit.framework.Assert.fail;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

  @Mock
  Context context;

  @Mock
  FileOutputStream fileOutputStream;

  @Mock
  FileInputStream fileInputStream;

  @Mock
  JSONObject jsonObject;

  @Mock
  JSONArray jsonArray;

  @Test
  public void deleteCharacterTest(){
    ArrayList<String> testList = new ArrayList<>();
    testList.add("name");

    String[] list = new String[2];
    list[0] = "name";
    list[1] = "name2";

    when(context.fileList()).thenReturn(list);

    Boolean deletedChar = CharacterManager.deleteCharacter(context,0);
    assertThat(deletedChar,is(false));
  }

  @Test
  public void getCharacterFilesTest(){
    ArrayList<String> list = CharacterManager.getCharacterFiles(context);
    assertThat(list.size(),notNullValue());
  }

  @Ignore
  @Test
  public void loadCharacterTest(){
    ArrayList<String> testList = new ArrayList<>();
    testList.add("name");

    String[] list = new String[2];
    list[0] = "name";
    list[1] = "name2";

    try {
//      when(testCharMgr.getCharacterFiles(context)).thenThrow(testList);

      when(context.openFileInput(anyString())).thenReturn(fileInputStream);

      when(context.fileList()).thenReturn(list);



      PlayerCharacter character = testCharMgr.loadCharacter(0,context);

      assertThat(character,notNullValue());
    }catch (Exception ex){
      ex.printStackTrace();
      fail();
    }
  }

  @Test
  public void saveCharacterTest(){
    PlayerCharacter playerCharacter = new PlayerCharacter();
    playerCharacter.setName("testName");
    try{
      when(context.openFileOutput(anyString(),anyInt())).thenReturn(fileOutputStream);
      CharacterManager.saveCharacter(playerCharacter,context);
      verify(context, times(1)).openFileOutput(anyString(),anyInt());
    }catch (FileNotFoundException ex){
      ex.printStackTrace();
      fail();
    }
  }

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

    assertThat(responseSkills.size(),is(22));

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
