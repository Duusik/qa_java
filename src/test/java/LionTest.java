import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }


    @Test
    public void getFoodTest() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(food);
        Lion lion = new Lion("Самец", feline);
        assertEquals(food, lion.getFood());
    }

    @Test
    public void unknownGenderTest() {
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            new Lion("неизвестно", feline);
        });
        assertEquals( "Используйте допустимые значения пола животного - самец или самка" , exception.getMessage());
    }
}