import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PutRemoveTest {

    PowerSet pwrSet = new PowerSet();
    PowerSet pwrSetBig1 = new PowerSet();
    PowerSet pwrSetBig2 = new PowerSet();

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws IOException
    {
        pwrSet.put("1");
        pwrSet.put("2");
        pwrSet.put("3");
        pwrSetBig1 = MethsForTest.setGenerator(0);
        pwrSetBig2 = MethsForTest.setGenerator(10000);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("1) The possibility to put non-existing element")
    void putNotExisting() throws IOException
    {
        pwrSet.put("4");
        assertTrue(pwrSet.get("4"));
        assertEquals(4, pwrSet.size());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("2) The impossibility to put existing element")
    void putExisting() throws IOException
    {
        pwrSet.put("1");
        assertEquals(3, pwrSet.size());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("3) Removing existing element")
    void putRemove() throws IOException
    {
        pwrSet.remove("1");
        assertFalse(pwrSet.get("1"));
        assertEquals(2, pwrSet.size());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("4) Removing absent element")
    void putRemove2() throws IOException
    {
        pwrSet.remove("10");
        assertFalse(pwrSet.remove("10"));
        assertEquals(3, pwrSet.size());
    }

    @Test
    @DisplayName("5) Put timeout test")
    void timeOutPut() throws Exception
    {
        long currTime1 = java.lang.System.currentTimeMillis();
        pwrSetBig1.put("800");
        long currTime2 = java.lang.System.currentTimeMillis();

        Assertions.assertFalse(currTime2 - currTime1 > 2000,
                "Method(put) is out of time!");
    }

    @Test
    @DisplayName("6) Remove timeout test")
    void timeOutRemove() throws Exception
    {
        long currTime1 = java.lang.System.currentTimeMillis();
        pwrSetBig2.remove("3");
        long currTime2 = java.lang.System.currentTimeMillis();

        Assertions.assertFalse(currTime2 - currTime1 > 2000,
                "Method(remove) is out of time!");
    }

}