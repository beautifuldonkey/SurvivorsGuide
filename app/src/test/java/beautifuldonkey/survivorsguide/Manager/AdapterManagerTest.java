package beautifuldonkey.survivorsguide.Manager;

import android.content.Context;
import android.widget.ArrayAdapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import beautifuldonkey.survivorsguide.Data.Skill;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

/**
 * Created by jaw_m on 6/19/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class AdapterManagerTest {

  @InjectMocks
  AdapterManager adapterManager;

  @Mock
  Context context;

  @Mock
  ArrayAdapter adapter;

  @Test
  public void getSimpleSkillAdapterTest(){

//    Encountering more issues mocking, last resolved by adding test dependency to project build

//    List<Skill> testSkills = new ArrayList<>();
//
//    Skill skill = new Skill();
//    skill.setName("name");
//    skill.setBuildCost(2);
//    skill.setIsStrain(false);
//    testSkills.add(skill);
//
//    when(adapterManager.getSimpleSkillAdapter(context,testSkills)).thenReturn(adapter);
//
//    ArrayAdapter<Skill> testAdapter = adapterManager.getSimpleSkillAdapter(context,testSkills);
//
//    assertThat(testAdapter.isEmpty(),is(false));
  }
}
