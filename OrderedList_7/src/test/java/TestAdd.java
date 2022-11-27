import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class TestAdd {

    OrderedList ordListAsc = new OrderedList<>(true);
    OrderedList ordListDesc = new OrderedList<>(false);
    OrderedList emptyOrdList = new OrderedList<>(true);

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws Exception
    {
        ordListAsc.add(10);
        ordListDesc.add(10);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("1) Добавление в пустой список")
    void add_Empty() throws Exception
    {
        emptyOrdList.add(10);
        assertEquals(1, emptyOrdList.count());
        assertEquals(10, emptyOrdList.head.value);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("2) ASC: Добавление дубля в список из 1 узла")
    void add_Asc_Add1() throws Exception
    {
        ordListAsc.add(10);
        assertEquals(2, ordListAsc.count());
        assertEquals(10, (ordListAsc.head.value));
        assertEquals(10, ordListAsc.tail.value);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("3) ASC: Добавление дубля в голову")
    void add_Asc_CloneHead() throws Exception
    {
        ordListAsc.add(1);
        ordListAsc.add(2);
        ordListAsc.add(3);
        ordListAsc.add(1);

        assertEquals(5, ordListAsc.count());
        assertEquals(1, ordListAsc.head.value);
        assertEquals(10, ordListAsc.tail.value);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("4) ASC: Добавление дубля в хвост")
    void add_Asc_CloneTail() throws Exception
    {
        ordListAsc.add(1);
        ordListAsc.add(2);
        ordListAsc.add(3);
        ordListAsc.add(10);

        assertEquals(5, ordListAsc.count());
        assertEquals(1, ordListAsc.head.value);
        assertEquals(10, ordListAsc.tail.value);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("5) ASC: Добавление дубля в середину")
    void add_Asc_CloneMid() throws Exception
    {
        ordListAsc.add(1);
        ordListAsc.add(2);
        ordListAsc.add(3);
        ordListAsc.add(2);

        assertEquals(5, ordListAsc.count());
        assertEquals(2, ordListAsc.head.next.value);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("6) ASC: Значение < head")
    void add_Asc_LessThanHead() throws Exception
    {
        ordListAsc.add(9);

        assertEquals(2, ordListAsc.count());
        assertEquals(9, ordListAsc.head.value);
        assertEquals(10, ordListAsc.tail.value);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("7) ASC: Значение > tail")
    void add_Asc_BiggerThanTail() throws Exception
    {
        ordListAsc.add(12);

        assertEquals(2, ordListAsc.count());
        assertEquals(10, ordListAsc.head.value);
        assertEquals(12, ordListAsc.tail.value);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("8) ASC: Значение между head и tail")
    void add_Asc_UsualMid() throws Exception
    {
        ordListAsc.add(15);
        ordListAsc.add(12);

        assertEquals(3, ordListAsc.count());
        assertEquals(10, ordListAsc.head.value);
        assertEquals(15, ordListAsc.tail.value);
    }

    //DESCENDING

    @org.junit.jupiter.api.Test
    @DisplayName("9) DESC: Добавление дубля в список из 1 узла")
    void add_Desc_Add1() throws Exception
    {
        int node = 10;
        ordListDesc.add(node);

        assertEquals(2, ordListDesc.count());
        assertEquals(node, ordListDesc.head.value);
        assertEquals(node, ordListDesc.tail.value);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("10) DESC: Добавление дубля в голову")
    void add_Desc_CloneHead() throws Exception
    {
        ordListDesc.add(1);
        ordListDesc.add(2);
        ordListDesc.add(3);
        ordListDesc.add(10);

        assertEquals(5, ordListDesc.count());
        assertEquals(10, ordListDesc.head.value);
        assertEquals(1, ordListDesc.tail.value);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("11) DESC: Добавление дубля в хвост")
    void add_Desc_CloneTail() throws Exception
    {
        ordListDesc.add(1);
        ordListDesc.add(2);
        ordListDesc.add(3);
        ordListDesc.add(1);

        assertEquals(5, ordListDesc.count());
        assertEquals(10, ordListDesc.head.value);
        assertEquals(1, ordListDesc.tail.value);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("12) DESC: Добавление дубля в середину")
    void add_Desc_CloneMid() throws Exception
    {
        ordListDesc.add(1);
        ordListDesc.add(2);
        ordListDesc.add(3);
        ordListDesc.add(3);

        assertEquals(5, ordListDesc.count());
        assertEquals(3, ordListDesc.head.next.next.value);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("13) DESC: Значение > head")
    void add_Desc_LessThanHead() throws Exception
    {
        ordListDesc.add(15);

        assertEquals(2, ordListDesc.count());
        assertEquals(15, ordListDesc.head.value);
        assertEquals(10, ordListDesc.tail.value);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("14) DESC: Значение < tail")
    void add_Desc_BiggerThanTail() throws Exception
    {
        ordListDesc.add(5);

        assertEquals(2, ordListDesc.count());
        assertEquals(10, ordListDesc.head.value);
        assertEquals(5, ordListDesc.tail.value);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("15) DESC: Значение между head и tail")
    void add_Desc_UsualMid() throws Exception
    {
        ordListDesc.add(5);
        ordListDesc.add(7);

        assertEquals(3, ordListDesc.count());
        assertEquals(10, ordListDesc.head.value);
        assertEquals(5, ordListDesc.tail.value);
    }

}