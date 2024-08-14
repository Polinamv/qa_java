import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    private Feline feline;
    private String sex;
    private boolean hasMane;

    public LionParametrizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Before
    public void setUp() {
        feline = mock(Feline.class); // Создаем мок для Feline
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void testConstructorWithValidSex() throws Exception {
        Lion lion = new Lion(feline, sex);
        assertEquals(hasMane, lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testConstructorWithInvalidSex() throws Exception {
        new Lion(feline, "Неизвестный пол");
    }
}
