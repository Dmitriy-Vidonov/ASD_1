import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class DifferenceTest {

    PowerSet pwrSet1 = new PowerSet();
    PowerSet pwrSet2 = new PowerSet();
    PowerSet pwrSet3 = new PowerSet();
    PowerSet emptySet = new PowerSet();

    PowerSet pwrSetBig1 = new PowerSet();
    PowerSet pwrSetBig2 = new PowerSet();

    @BeforeEach
    void setUp()
    {
        pwrSet1.put("10");
        pwrSet1.put("20");
        pwrSet1.put("40");
        pwrSet1.put("100");

        pwrSet2.put("10");
        pwrSet2.put("20");
        pwrSet2.put("40");
        pwrSet2.put("100");

        pwrSet3.put("50");
        pwrSet3.put("80");
        pwrSet3.put("100");
        pwrSet3.put("20");

        pwrSetBig1 = MethsForTest.setGenerator(0, 9999);
        pwrSetBig2 = MethsForTest.setGenerator(10000, 20000);
    }

    @Test
    @DisplayName("1) Empty multitude in summary")
    void differenceEmpty() throws Exception
    {
        emptySet = pwrSet1.difference(pwrSet2);
        assertEquals(0, emptySet.size());
    }

    @Test
    @DisplayName("2) Non-empty multitude in summary")
    void differenceNonEmpty() throws Exception
    {
        emptySet = pwrSet1.difference(pwrSet3);
        assertEquals(2, emptySet.size());
    }

    @Test
    @DisplayName("3) Timeout test")
    void timeOut() throws IOException
    {
        long currTime1 = java.lang.System.currentTimeMillis();
        pwrSetBig1.difference(pwrSetBig2);
        long currTime2 = java.lang.System.currentTimeMillis();

        Assertions.assertFalse(currTime2 - currTime1 > 2000,
                "Method(difference) is out of time!");
    }
}