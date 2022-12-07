import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class PutRemoveTest {

    PowerSet pwrSet = new PowerSet();

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws Exception
    {
        pwrSet.put("1");
        pwrSet.put("2");
        pwrSet.put("3");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("1) Возможность добавления отсутствующего элемента")
    void putNotExisting() throws Exception
    {
        pwrSet.put("4");
        assertTrue(pwrSet.get("4"));
        assertEquals(4, pwrSet.size());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("2) Невозможность добавления присутствующего элемента")
    void putExisting() throws Exception
    {
        pwrSet.put("1");
        assertEquals(3, pwrSet.size());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("3) Удаление присутствующего элемента")
    void putRemove() throws Exception
    {
        pwrSet.remove("1");
        assertEquals(2, pwrSet.size());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("4) Удаление отсутствующего элемента")
    void putRemove2() throws Exception
    {
        pwrSet.remove("10");
        assertEquals(3, pwrSet.size());
    }
}