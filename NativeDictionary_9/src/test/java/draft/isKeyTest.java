package draft;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestIsKey {

    NativeDictionary dictionTest = new NativeDictionary<String>(10, String.class);

    @BeforeEach
    void setUp() throws Exception
    {
        dictionTest.put("one_key", "one_value");
    }

    @Test
    @DisplayName("1) Проверка присутствующего ключа")
    void isKeyExist() throws Exception
    {
        assertTrue(dictionTest.isKey("one_key"));
    }

    @Test
    @DisplayName("2) Проверка присутствующего ключа")
    void isKeyNotExist() throws Exception
    {
        assertFalse(dictionTest.isKey("another_key"));
    }
}