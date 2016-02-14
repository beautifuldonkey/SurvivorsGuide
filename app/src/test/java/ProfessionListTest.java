import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
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
    public void getStrainListTest(){
        assertThat(testProfList.getProfessionList().size(),is(38));
    }

    @Test
    public void getStrainByNameTest(){
        assertThat(testProfList.getProfessionByName("Assassin").getName(), is("Assassin"));
    }
}