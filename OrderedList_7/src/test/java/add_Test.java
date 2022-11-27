import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class add_Test {

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
        Assertions.assertTrue(emptyOrdList.count() == 1);
        Assertions.assertTrue(emptyOrdList.head.value.equals(10));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("2) ASC: Добавление дубля в список из 1 узла")
    void add_Asc_Add1() throws Exception
    {
        ordListAsc.add(10);
        Assertions.assertTrue(ordListAsc.count() == 2);
        Assertions.assertTrue(ordListAsc.head.value.equals(10));
        Assertions.assertTrue(ordListAsc.tail.value.equals(10));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("3) ASC: Добавление дубля в голову")
    void add_Asc_CloneHead() throws Exception
    {
        ordListAsc.add(1);
        ordListAsc.add(2);
        ordListAsc.add(3);
        ordListAsc.add(1);

        Assertions.assertTrue(ordListAsc.count() == 5);
        Assertions.assertTrue(ordListAsc.head.value.equals(1));
        Assertions.assertTrue(ordListAsc.tail.value.equals(10));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("4) ASC: Добавление дубля в хвост")
    void add_Asc_CloneTail() throws Exception
    {
        ordListAsc.add(1);
        ordListAsc.add(2);
        ordListAsc.add(3);
        ordListAsc.add(10);

        Assertions.assertTrue(ordListAsc.count() == 5);
        Assertions.assertTrue(ordListAsc.head.value.equals(1));
        Assertions.assertTrue(ordListAsc.tail.value.equals(10));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("5) ASC: Добавление дубля в середину")
    void add_Asc_CloneMid() throws Exception
    {
        ordListAsc.add(1);
        ordListAsc.add(2);
        ordListAsc.add(3);
        ordListAsc.add(2);

        Assertions.assertTrue(ordListAsc.count() == 5);
        Assertions.assertTrue(ordListAsc.head.next.value.equals(2));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("6) ASC: Значение < head")
    void add_Asc_LessThanHead() throws Exception
    {
        ordListAsc.add(9);

        Assertions.assertTrue(ordListAsc.count() == 2);
        Assertions.assertTrue(ordListAsc.head.value.equals(9));
        Assertions.assertTrue(ordListAsc.tail.value.equals(10));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("7) ASC: Значение > tail")
    void add_Asc_BiggerThanTail() throws Exception
    {
        ordListAsc.add(12);

        Assertions.assertTrue(ordListAsc.count() == 2);
        Assertions.assertTrue(ordListAsc.head.value.equals(10));
        Assertions.assertTrue(ordListAsc.tail.value.equals(12));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("8) ASC: Значение между head и tail")
    void add_Asc_UsualMid() throws Exception
    {
        ordListAsc.add(15);
        ordListAsc.add(12);

        Assertions.assertTrue(ordListAsc.count() == 3);
        Assertions.assertTrue(ordListAsc.head.value.equals(10));
        Assertions.assertTrue(ordListAsc.tail.value.equals(15));
    }


    //DESCENDING

    @org.junit.jupiter.api.Test
    @DisplayName("9) DESC: Добавление дубля в список из 1 узла")
    void add_Desc_Add1() throws Exception
    {
        ordListDesc.add(10);

        Assertions.assertTrue(ordListDesc.count() == 2);
        Assertions.assertTrue(ordListDesc.head.value.equals(10));
        Assertions.assertTrue(ordListDesc.tail.value.equals(10));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("10) DESC: Добавление дубля в голову")
    void add_Desc_CloneHead() throws Exception
    {
        ordListDesc.add(1);
        ordListDesc.add(2);
        ordListDesc.add(3);
        ordListDesc.add(10);

        Assertions.assertTrue(ordListDesc.count() == 5);
        Assertions.assertTrue(ordListDesc.head.value.equals(10));
        Assertions.assertTrue(ordListDesc.tail.value.equals(1));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("11) DESC: Добавление дубля в хвост")
    void add_Desc_CloneTail() throws Exception
    {
        ordListDesc.add(1);
        ordListDesc.add(2);
        ordListDesc.add(3);
        ordListDesc.add(1);

        Assertions.assertTrue(ordListDesc.count() == 5);
        Assertions.assertTrue(ordListDesc.head.value.equals(10));
        Assertions.assertTrue(ordListDesc.tail.value.equals(1));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("12) DESC: Добавление дубля в середину")
    void add_Desc_CloneMid() throws Exception
    {
        ordListDesc.add(1);
        ordListDesc.add(2);
        ordListDesc.add(3);
        ordListDesc.add(3);

        Assertions.assertTrue(ordListDesc.count() == 5);
        Assertions.assertTrue(ordListDesc.head.next.next.value.equals(3));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("13) DESC: Значение > head")
    void add_Desc_LessThanHead() throws Exception
    {
        ordListDesc.add(15);

        Assertions.assertTrue(ordListDesc.count() == 2);
        Assertions.assertTrue(ordListDesc.head.value.equals(15));
        Assertions.assertTrue(ordListDesc.tail.value.equals(10));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("14) DESC: Значение < tail")
    void add_Desc_BiggerThanTail() throws Exception
    {
        ordListDesc.add(5);

        Assertions.assertTrue(ordListDesc.count() == 2);
        Assertions.assertTrue(ordListDesc.head.value.equals(10));
        Assertions.assertTrue(ordListDesc.tail.value.equals(5));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("15) DESC: Значение между head и tail")
    void add_Desc_UsualMid() throws Exception
    {
        ordListDesc.add(5);
        ordListDesc.add(7);

        Assertions.assertTrue(ordListDesc.count() == 3);
        Assertions.assertTrue(ordListDesc.head.value.equals(10));
        Assertions.assertTrue(ordListDesc.tail.value.equals(5));
    }

}