import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubsetTest {

    PowerSet pwrSet1 = new PowerSet();
    PowerSet pwrSet2 = new PowerSet();
    PowerSet pwrSet3 = new PowerSet();

    @BeforeEach
    void setUp()
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
    }

    @Test
    @DisplayName("1) Все элементы параметра входят в текущее множество")
    void isSubset1()
    {
        assertTrue(pwrSet1.isSubset(pwrSet2));
    }

    @Test
    @DisplayName("2) Все элементы текущего множества входят в параметр")
    void isSubset2()
    {
        assertFalse(pwrSet2.isSubset(pwrSet1));
    }

    @Test
    @DisplayName("3) Не все элементы параметра входят в текущее множество")
    void isSubset3()
    {
        assertFalse(pwrSet1.isSubset(pwrSet3));
    }
}