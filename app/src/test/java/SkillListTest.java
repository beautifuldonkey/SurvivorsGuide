import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.List;
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

    @Test
    public void getSkillListTest() {
        assertThat(testSkillList.getSkillList().size(),is(134));
    }

    @Test
    public void getSingleSkillByName(){
        String testSkillName = "Backstab";
        String testSkillNameCheck = "Backstab";
        List<Skill> testSkill = testSkillList.getSkillsByName(testSkillName);
        assertThat(testSkill.get(0).getName(),is(testSkillNameCheck));
    }

    @Test
    public void getMultipleSkillsByName(){
        String testSkillName = "Backstab,Income";
        String testSkillNameCheckFirst = "Backstab";
        String testSkillNameCheckSecond = "Income";
        List<Skill> testSkill = testSkillList.getSkillsByName(testSkillName);
        assertThat(testSkill.get(0).getName(),is(testSkillNameCheckFirst));
        assertThat(testSkill.get(1).getName(), is(testSkillNameCheckSecond));
    }
}