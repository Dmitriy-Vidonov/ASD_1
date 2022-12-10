import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionTest {

    PowerSet pwrSet1 = new PowerSet();
    PowerSet pwrSet2 = new PowerSet();
    PowerSet pwrSet3 = new PowerSet();
    PowerSet emptySet = new PowerSet();
    PowerSet pwrSetBig1 = new PowerSet();
    PowerSet pwrSetBig2 = new PowerSet();

    @BeforeEach
    void setUp() throws IOException
    {
        pwrSet1.put("10");
        pwrSet1.put("20");
        pwrSet1.put("40");
        pwrSet1.put("100");

        pwrSet2.put("50");
        pwrSet2.put("80");
        pwrSet2.put("100");
        pwrSet2.put("20");

        pwrSet3.put("110");
        pwrSet3.put("120");
        pwrSet3.put("140");
        pwrSet3.put("200");

        pwrSetBig1 = MethsForTest.setGenerator(10000);
        pwrSetBig2 = MethsForTest.setGenerator(10000);
    }

    @Test
    @DisplayName("1) Empty multitude as result")
    void intersectionEmpty() throws Exception
    {
        emptySet = pwrSet1.intersection(pwrSet3);
        assertSame(0, emptySet.size());
    }

    @Test
    @DisplayName("2) Non-empty multitude as result")
    void intersectionNonEmpty() throws Exception
    {
        emptySet = pwrSet1.intersection(pwrSet2);
        assertSame(2, emptySet.size());
    }

    @Test
    @DisplayName("3) Timeout test")
    void timeOut() throws Exception
    {
        long currTime1 = java.lang.System.currentTimeMillis();
        pwrSetBig1.intersection(pwrSetBig2);
        long currTime2 = java.lang.System.currentTimeMillis();

        Assertions.assertTrue(currTime2 - currTime1 < 2000,
                "Method(intersection) is out of time!");
    }
}