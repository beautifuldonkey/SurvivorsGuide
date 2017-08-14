package beautifuldonkey.survivorsguide.Data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import beautifuldonkey.survivorsguide.Data.StrainList;

/**
 * basic unit test for strain lists
 * Created by jaw_m on 2/14/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class StrainListTest {

  @Mock
  StrainList testStrainList;

  @Test
  public void getStrainListTest(){
    assertThat(testStrainList.getStrainList().size(),is(21));
  }

  @Test
  public void getStrainByNameTest(){
    List<Strain> strainList = testStrainList.getStrainList();
    for(Strain strain: strainList){
      Strain foundStrain = testStrainList.getStrainByName(strain.getName());
      assertThat(foundStrain.getName(), is(strain.getName()));
    }
  }

  @Test
  public void strainTest(){
    String testName = "name";
    int testBody = 1;
    int testMind = 2;
    int testInf = 3;
    String testSkills = "skills";
    String testDesc = "desc";

    Strain testStrain = new Strain();

    testStrain.setName(testName);
    testStrain.setBody(testBody);
    testStrain.setMind(testMind);
    testStrain.setInfection(testInf);
    testStrain.setSkills(testSkills);
    testStrain.setDescription(testDesc);

    assertThat(testStrain.getName(),is(testName));
    assertThat(testStrain.getBody(),is(testBody));
    assertThat(testStrain.getMind(),is(testMind));
    assertThat(testStrain.getInfection(),is(testInf));
    assertThat(testStrain.getSkills(),is(testSkills));
    assertThat(testStrain.getDescription(),is(testDesc));
  }
}