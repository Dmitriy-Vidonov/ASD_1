package draft;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TestIsKey {

    NativeDictionary<String> dictionTest = new NativeDictionary<String>(10, String.class);
    NativeDictionary<String> bigNative = TestMethods.GenerateNative(10000);

    @BeforeEach
    void setUp() throws Exception
    {
        dictionTest.put("0_key", "0_value");
        dictionTest.put("1_key", "1_value");
        dictionTest.put("2_key", "2_value");
        dictionTest.put("3_key", "3_value");
        dictionTest.put("4_key", "4_value");
        dictionTest.put("5_key", "5_value");
        dictionTest.put("6_key", "6_value");
        dictionTest.put("7_key", "7_value");
        dictionTest.put("8_key", "8_value");
        dictionTest.put("9_key", "9_value");
    }

    @Test
    @DisplayName("1) Проверка присутствующего ключа")
    void isKeyExist() throws Exception
    {
        assertTrue(dictionTest.isKey("1_key"));
    }

    @Test
    @DisplayName("2) Проверка присутствующего ключа")
    void isKeyNotExist() throws Exception
    {
        assertFalse(dictionTest.isKey("another_key"));
    }

 //   @RepeatedTest(10000)
   // @Test
    @DisplayName("3) 10 000 проверок")
    void isKeyRepeated() throws Exception
    {
        //bigNative.ShowTable();

        int a = 0;
        int b = 9999;
        assertTrue(bigNative.isKey(String.valueOf((int)(a + Math.random()*(b-a))) + "_key"));
        //assertTrue(bigNative.isKey("1_key"));
    }
}