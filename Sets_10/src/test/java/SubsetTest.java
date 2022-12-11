import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SubsetTest {

    PowerSet pwrSet1 = new PowerSet();
    PowerSet pwrSet2 = new PowerSet();
    PowerSet pwrSet3 = new PowerSet();
    PowerSet pwrSetBig1 = new PowerSet();
    PowerSet pwrSetBig2 = new PowerSet();

    @BeforeEach
    void setUp() throws IOException
    {
        pwrSet1.put("10");
        pwrSet1.put("20");
        pwrSet1.put("40");
        pwrSet1.put("100");

        pwrSet2.put("20");
        pwrSet2.put("40");

        pwrSet3.put("20");
        pwrSet3.put("40");
        pwrSet3.put("50");

        pwrSetBig1 = MethsForTest.setGenerator(0, 9999);
        pwrSetBig2 = MethsForTest.setGenerator(10000, 20000);
    }

    @Test
    @DisplayName("1) All parameter elements are in current multitude")
    void isSubset1() throws Exception
    {
        assertTrue(pwrSet1.isSubset(pwrSet2));
    }

    @Test
    @DisplayName("2) All current multitude elements are in parameter")
    void isSubset2() throws Exception
    {
        assertFalse(pwrSet2.isSubset(pwrSet1));
    }

    @Test
    @DisplayName("3) Not all parameter elements are in current multitude")
    void isSubset3() throws Exception
    {
        assertFalse(pwrSet1.isSubset(pwrSet3));
    }

    @Test
    @DisplayName("4) isSubset timeout test")
    void timeOutIsSubset() throws Exception
    {
        long currTime1 = java.lang.System.currentTimeMillis();
        pwrSetBig1.isSubset(pwrSetBig2);
        long currTime2 = java.lang.System.currentTimeMillis();

        Assertions.assertFalse(currTime2 - currTime1 > 2000,
                "Method(isSubset) is out of time!");
    }
}