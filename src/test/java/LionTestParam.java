import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTestParam {
    private final String sex;
    private final boolean expected;

    public LionTestParam(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[] data() {
        return new Object[][]{
                {"Самка", false},
                {"Самец", true},
        };
    }

     @Mock
    private Feline feline;

    @Test
    public void haveManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals("Используйте допустимые значения пола животного - самец или самка", expected, actual);
    }
}