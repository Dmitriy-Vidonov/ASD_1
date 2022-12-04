package draft;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class TestPut {

    NativeDictionary dictionTest = new NativeDictionary<String>(10, String.class);
    NativeDictionary emptyDictionary = new NativeDictionary<String>(10, String.class);

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws Exception
    {
        dictionTest.put("one_key", "one_value");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("1) Добавить значение по новому ключу")
    void putAddNew() throws Exception
    {
        String key = "example_key";
        String value = "example_value";

        emptyDictionary.put(key, "example_value");
        assertTrue(emptyDictionary.isKey(key));
        assertSame(emptyDictionary.get(key), value);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("2) Добавить значение по уже существующему ключу")
    void putAddExisting() throws Exception
    {
        String key = "one_key";
        String value = "new_value";

        dictionTest.put(key, value);
        assertSame(dictionTest.get(key), value);
    }
}