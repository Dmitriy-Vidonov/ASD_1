import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class delete_Test {

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

        Assertions.assertTrue(emptyOrdList.count() == 0);
    }

    @Test
    @DisplayName("2) ASC: Список из 1 узла")
    void delete_Asc1Node() throws Exception
    {
        ordListAsc.delete(10);

        Assertions.assertTrue(ordListAsc.count() == 0);
    }

    @Test
    @DisplayName("3) ASC: Удалить head")
    void delete_AscHead() throws Exception
    {
        ordListAsc.add(1);
        ordListAsc.add(2);
        ordListAsc.add(3);

        ordListAsc.delete(1);

        Assertions.assertTrue(ordListAsc.count() == 3);
        Assertions.assertTrue(ordListAsc.head.value.equals(2));
    }

    @Test
    @DisplayName("4) ASC: Удалить tail")
    void delete_AscTail() throws Exception
    {
        ordListAsc.add(1);
        ordListAsc.add(2);
        ordListAsc.add(3);

        ordListAsc.delete(10);

        Assertions.assertTrue(ordListAsc.count() == 3);
        Assertions.assertTrue(ordListAsc.tail.value.equals(3));
    }

    @Test
    @DisplayName("5) ASC: Список из одинаковых узлов")
    void delete_AscAllSame() throws Exception
    {
        ordListAsc.add(10);
        ordListAsc.add(10);
        ordListAsc.add(10);

        ordListAsc.delete(10);

        Assertions.assertTrue(ordListAsc.count() == 3);
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

        Assertions.assertTrue(ordListAsc.count() == 4);
        Assertions.assertTrue(ordListAsc.tail.prev.value.equals(3));
    }

    @Test
    @DisplayName("7) ASC: Удалить из середины")
    void delete_AscMid() throws Exception
    {
        ordListAsc.add(1);
        ordListAsc.add(2);
        ordListAsc.add(3);

        ordListAsc.delete(3);

        Assertions.assertTrue(ordListAsc.count() == 3);
        Assertions.assertTrue(ordListAsc.tail.prev.value.equals(2));
    }
    
    //DESCENDING

    @Test
    @DisplayName("8) DESC: Список из 1 узла")
    void delete_Desc1Node() throws Exception
    {
        ordListDesc.delete(10);

        Assertions.assertTrue(ordListDesc.count() == 0);
    }

    @Test
    @DisplayName("9) DESC: Удалить head")
    void delete_DescHead() throws Exception
    {
        ordListDesc.add(1);
        ordListDesc.add(2);
        ordListDesc.add(3);

        ordListDesc.delete(10);

        Assertions.assertTrue(ordListDesc.count() == 3);
        Assertions.assertTrue(ordListDesc.head.value.equals(3));
    }

    @Test
    @DisplayName("10) DESC: Удалить tail")
    void delete_DescTail() throws Exception
    {
        ordListDesc.add(1);
        ordListDesc.add(2);
        ordListDesc.add(3);

        ordListDesc.delete(1);

        Assertions.assertTrue(ordListDesc.count() == 3);
        Assertions.assertTrue(ordListDesc.tail.value.equals(2));
    }

    @Test
    @DisplayName("11) DESC: Список из одинаковых узлов")
    void delete_DescAllSame() throws Exception
    {
        ordListDesc.add(10);
        ordListDesc.add(10);
        ordListDesc.add(10);

        ordListDesc.delete(10);

        Assertions.assertTrue(ordListDesc.count() == 3);
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

        Assertions.assertTrue(ordListDesc.count() == 4);
        Assertions.assertTrue(ordListDesc.head.next.value.equals(3));
    }

    @Test
    @DisplayName("13) DESC: Удалить из середины")
    void delete_DescMid() throws Exception
    {
        ordListDesc.add(1);
        ordListDesc.add(2);
        ordListDesc.add(3);

        ordListDesc.delete(3);

        Assertions.assertTrue(ordListDesc.count() == 3);
        Assertions.assertTrue(ordListDesc.head.next.value.equals(2));
    }

}