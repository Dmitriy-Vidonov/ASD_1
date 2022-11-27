import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDelete {

    OrderedList ordListAsc = new OrderedList<>(true);
    OrderedList ordListDesc = new OrderedList<>(false);
    OrderedList emptyOrdList = new OrderedList<>(true);

    @BeforeEach
    void setUp() throws Exception
    {
        ordListAsc.add(10);
        ordListDesc.add(10);
    }

    @Test
    @DisplayName("1) Пустой список")
    void deleteEmpty() throws Exception
    {
        emptyOrdList.delete(10);

        assertEquals(0, emptyOrdList.count());
    }

    @Test
    @DisplayName("2) ASC: Список из 1 узла")
    void delete_Asc1Node() throws Exception
    {
        ordListAsc.delete(10);

        assertEquals(0, ordListAsc.count());
    }

    @Test
    @DisplayName("3) ASC: Удалить head")
    void delete_AscHead() throws Exception
    {
        ordListAsc.add(1);
        ordListAsc.add(2);
        ordListAsc.add(3);

        ordListAsc.delete(1);

        assertEquals(3, ordListAsc.count());
        assertEquals(2, ordListAsc.head.value);
    }

    @Test
    @DisplayName("4) ASC: Удалить tail")
    void delete_AscTail() throws Exception
    {
        ordListAsc.add(1);
        ordListAsc.add(2);
        ordListAsc.add(3);

        ordListAsc.delete(10);

        assertEquals(3, ordListAsc.count());
        assertEquals(3, ordListAsc.tail.value);
    }

    @Test
    @DisplayName("5) ASC: Список из одинаковых узлов")
    void delete_AscAllSame() throws Exception
    {
        ordListAsc.add(10);
        ordListAsc.add(10);
        ordListAsc.add(10);

        ordListAsc.delete(10);

        assertEquals(3, ordListAsc.count());
    }

    @Test
    @DisplayName("6) ASC: Список с дублем, удалить из середины")
    void delete_AscMidClone() throws Exception
    {
        ordListAsc.add(1);
        ordListAsc.add(2);
        ordListAsc.add(3);
        ordListAsc.add(3);

        ordListAsc.delete(3);

        assertEquals(4, ordListAsc.count());
        assertEquals(3, ordListAsc.tail.prev.value);
    }

    @Test
    @DisplayName("7) ASC: Удалить из середины")
    void delete_AscMid() throws Exception
    {
        ordListAsc.add(1);
        ordListAsc.add(2);
        ordListAsc.add(3);

        ordListAsc.delete(3);

        assertEquals(3, ordListAsc.count());
        assertEquals(2, ordListAsc.tail.prev.value);
    }
    
    //DESCENDING

    @Test
    @DisplayName("8) DESC: Список из 1 узла")
    void delete_Desc1Node() throws Exception
    {
        ordListDesc.delete(10);

        assertEquals(0, ordListDesc.count());
    }

    @Test
    @DisplayName("9) DESC: Удалить head")
    void delete_DescHead() throws Exception
    {
        ordListDesc.add(1);
        ordListDesc.add(2);
        ordListDesc.add(3);

        ordListDesc.delete(10);

        assertEquals(3, ordListDesc.count());
        assertEquals(3, ordListDesc.head.value);
    }

    @Test
    @DisplayName("10) DESC: Удалить tail")
    void delete_DescTail() throws Exception
    {
        ordListDesc.add(1);
        ordListDesc.add(2);
        ordListDesc.add(3);

        ordListDesc.delete(1);

        assertEquals(3, ordListDesc.count());
        assertEquals(2, ordListDesc.tail.value);
    }

    @Test
    @DisplayName("11) DESC: Список из одинаковых узлов")
    void delete_DescAllSame() throws Exception
    {
        ordListDesc.add(10);
        ordListDesc.add(10);
        ordListDesc.add(10);

        ordListDesc.delete(10);

        assertEquals(3, ordListDesc.count());
    }

    @Test
    @DisplayName("12) DESC: Список с дублем, удалить из середины")
    void delete_DescMidClone() throws Exception
    {
        ordListDesc.add(1);
        ordListDesc.add(2);
        ordListDesc.add(3);
        ordListDesc.add(3);

        ordListDesc.delete(3);

        assertEquals(4, ordListDesc.count());
        assertEquals(3, ordListDesc.head.next.value);
    }

    @Test
    @DisplayName("13) DESC: Удалить из середины")
    void delete_DescMid() throws Exception
    {
        ordListDesc.add(1);
        ordListDesc.add(2);
        ordListDesc.add(3);

        ordListDesc.delete(3);

        assertEquals(3, ordListDesc.count());
        assertEquals(2, ordListDesc.head.next.value);
    }
}