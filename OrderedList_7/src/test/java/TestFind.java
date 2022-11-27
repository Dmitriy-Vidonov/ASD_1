import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestFind {

    OrderedList ordListAsc = new OrderedList<>(true);
    OrderedList emptyOrdList = new OrderedList<>(true);

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws Exception
    {
        ordListAsc.add(10);
    }

    @Test
    @DisplayName("1) Пустой список")
    void findEmpty() throws Exception
    {
        assertEquals(null, emptyOrdList.find(10));
    }

    @Test
    @DisplayName("2) Узел есть в списке")
    void findOk() throws Exception
    {
        ordListAsc.add(1);
        ordListAsc.add(2);
        ordListAsc.add(3);

        assertEquals(10, ordListAsc.find(10).value);
    }

    @Test
    @DisplayName("3) Узла нет в списке")
    void findNone() throws Exception
    {
        ordListAsc.add(1);
        ordListAsc.add(2);
        ordListAsc.add(3);

        assertEquals(null, ordListAsc.find(15));
    }
}