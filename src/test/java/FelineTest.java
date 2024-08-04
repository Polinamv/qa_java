import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void eatMeatFelineTest() throws Exception {

        Feline spyFeline = Mockito.spy(feline);
        List<String> expectedResult = Arrays.asList("Животные", "Птицы", "Рыба");
        when(spyFeline.getFood("Хищник")).thenReturn(expectedResult);
        List<String> actualResult = spyFeline.eatMeat();
        assertEquals("Используйте тип животного - Хищник!", expectedResult, actualResult);
        verify(spyFeline).getFood("Хищник");
    }

    @Test
    public void getFamilyFelineTest() {
        String expectedResult = "Кошачьи";
        String actualResult = feline.getFamily();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getKittensWithParameterFelineTest() {
        int expectedResult = 10;
        int actualResult = feline.getKittens(expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getKittensFelineTest() {
        int expectedResult = 1;
        int actualResult = feline.getKittens();
        assertEquals(expectedResult, actualResult);
    }
}