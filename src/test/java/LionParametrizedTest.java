import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    String sex;
    boolean hasMane;

    public LionParametrizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Лев", false}
        };
    }

    @Test
    public void doesHasManeTest() {
        try {
            Lion lion = new Lion(new Feline(), sex);
            Assert.assertEquals(hasMane, lion.doesHaveMane());
        } catch (Exception e) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }
}
