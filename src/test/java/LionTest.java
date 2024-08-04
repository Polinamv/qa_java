import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private Lion lion;
    private Feline feline;

    @Before
    public void setUp() throws Exception {
        feline = Mockito.mock(Feline.class);
        lion = new Lion(feline, "Самец");
    }

    @Test
    public void getKittensLionTest() {
        when(feline.getKittens()).thenReturn(3);
        int actualKittens = lion.getKittens();
        assertEquals(3, actualKittens);
        verify(feline).getKittens();
    }

    @Test
    public void getFoodLionTest() throws Exception {
        List<String> expectedResult = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedResult);
        List<String> actualResult = lion.getFood();
        assertEquals("Используйте тип животного - Хищник!", expectedResult, actualResult);
        verify(feline).getFood("Хищник");
    }
}
