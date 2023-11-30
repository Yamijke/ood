package kiss.fool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoolTest {

    @Test
    public void answers() {
        assertEquals("1", Fool.ret(1), "Ошибка при 1");
        assertEquals("Fizz", Fool.ret(3), "Ошибка при 3");
        assertEquals("Buzz", Fool.ret(5), "Ошибка при 5");
        assertEquals("FizzBuzz", Fool.ret(15), "Ошибка при 15");
    }
}