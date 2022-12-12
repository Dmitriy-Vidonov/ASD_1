import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UnionTest {

    PowerSet pwrSet1 = new PowerSet();
    PowerSet pwrSet2 = new PowerSet();
    PowerSet emptySet = new PowerSet();
    PowerSet emptySet2 = new PowerSet();
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

        pwrSetBig1 = MethsForTest.setGenerator(0);
        pwrSetBig2 = MethsForTest.setGenerator(10000);
    }

    @Test
    @DisplayName("1) Both parameters are not empty")
    void unionBothNonEmpty() throws Exception
    {
        emptySet = pwrSet1.union(pwrSet2);
        assertEquals(6, emptySet.size());

        assertTrue(emptySet.get("10"));
        assertTrue(emptySet.get("20"));
        assertTrue(emptySet.get("50"));
        assertTrue(emptySet.get("40"));
        assertTrue(emptySet.get("80"));
        assertTrue(emptySet.get("100"));

        emptySet2 = pwrSetBig1.union(pwrSetBig2);
        assertEquals(20000, emptySet2.size());
        System.out.println("big1 size = " + pwrSetBig1.size());
        System.out.println("big2 size = " + pwrSetBig2.size());
    }

    @Test
    @DisplayName("2) Second parameter is empty multitude")
    void unionOneEmpty() throws Exception
    {
        emptySet = pwrSet1.union(emptySet2);
        assertEquals(pwrSet1.size(), emptySet.size());
    }

    @Test
    @DisplayName("3) Union timeout test")
    void timeOutUnion() throws Exception
    {
        long currTime1 = java.lang.System.currentTimeMillis();
        pwrSetBig1.union(pwrSetBig2);
        long currTime2 = java.lang.System.currentTimeMillis();

        Assertions.assertFalse(currTime2 - currTime1 > 2000,
                "Method(union) is out of time!");
    }

}