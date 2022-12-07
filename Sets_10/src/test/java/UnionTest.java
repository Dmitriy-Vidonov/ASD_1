import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnionTest {

    PowerSet pwrSet1 = new PowerSet();
    PowerSet pwrSet2 = new PowerSet();
    PowerSet emptySet = new PowerSet();
    PowerSet emptySet2 = new PowerSet();

    @BeforeEach
    void setUp() throws Exception
    {
        pwrSet1.put("10");
        pwrSet1.put("20");
        pwrSet1.put("40");
        pwrSet1.put("100");

        pwrSet2.put("50");
        pwrSet2.put("80");
        pwrSet2.put("100");
        pwrSet2.put("20");
    }

    @Test
    @DisplayName("1) Оба параметра не пустые")
    void unionBothNonEmpty() throws Exception
    {
        emptySet = pwrSet1.union(pwrSet2);
        assertEquals(6, emptySet.size());
    }

    @Test
    @DisplayName("2) Один из параметров - пустое множество")
    void unionOneEmpty() throws Exception
    {
        emptySet = pwrSet1.union(emptySet2);
        assertEquals(pwrSet1.size(), emptySet.size());
    }
}