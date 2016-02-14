import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
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
        assertThat(testStrainList.getStrainByName("Genjian").getName(), is("Genjian"));
    }
}