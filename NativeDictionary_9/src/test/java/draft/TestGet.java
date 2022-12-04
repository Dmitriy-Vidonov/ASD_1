package draft;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestGet {
    NativeDictionary dictionTest = new NativeDictionary<String>(10, String.class);
    @BeforeEach
    void setUp() throws Exception
    {
        dictionTest.put("one_key", "one_value");
    }

    @Test
    @DisplayName("1) Извлечь значение по существующему ключу")
    void getExist() throws Exception
    {
        assertSame(dictionTest.get("one_key"), "one_value");
    }

    @Test
    @DisplayName("2) Извлечь значение по несуществующему ключу")
    void getNotExist() throws Exception
    {
        assertSame(dictionTest.get("another_key"), null);
    }
}