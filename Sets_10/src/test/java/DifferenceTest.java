import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DifferenceTest {

    PowerSet pwrSet1 = new PowerSet();
    PowerSet pwrSet2 = new PowerSet();
    PowerSet pwrSet3 = new PowerSet();
    PowerSet emptySet = new PowerSet();
    
    @BeforeEach
    void setUp() throws Exception
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
    }

    @Test
    @DisplayName("1) В результате пустое множество")
    void differenceEmpty() throws Exception
    {
        emptySet = pwrSet1.difference(pwrSet2);
        assertEquals(0, emptySet.size());
    }

    @Test
    @DisplayName("2) В результате непустое множество")
    void differenceNonEmpty() throws Exception
    {
        emptySet = pwrSet1.difference(pwrSet3);
        assertEquals(2, emptySet.size());
    }

}