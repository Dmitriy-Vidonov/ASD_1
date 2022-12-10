import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionTest {

    PowerSet pwrSet1 = new PowerSet();
    PowerSet pwrSet2 = new PowerSet();
    PowerSet pwrSet3 = new PowerSet();
    PowerSet emptySet = new PowerSet();

    @BeforeEach
    void setUp()
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
    }

    @Test
    @DisplayName("1) Пустое множество в результате")
    void intersectionEmpty()
    {
        emptySet = pwrSet1.intersection(pwrSet3);
        assertSame(0, emptySet.size());
    }

    @Test
    @DisplayName("2) Непустое множество в результате")
    void intersectionNonEmpty()
    {
        emptySet = pwrSet1.intersection(pwrSet2);
        assertSame(2, emptySet.size());
    }
}