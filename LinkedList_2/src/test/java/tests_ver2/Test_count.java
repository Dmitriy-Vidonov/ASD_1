package tests_ver2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test_count {

    LinkedList2 testList = new LinkedList2();

    @Test
    @DisplayName("1) Список пуст")
    void count_EmptyList() throws Exception
    {
        Assertions.assertTrue(testList.count() == 0);
    }

    @Test
    @DisplayName("2) Список из 1 узла")
    void count_1NodeList() throws Exception
    {
        testList.addInTail(new Node(1));

        Assertions.assertTrue(testList.count() == 1);
    }

    @Test
    @DisplayName("3) Список из нескольких узлов")
    void count_FewNodesList() throws Exception
    {
        testList.addInTail(new Node(1));
        testList.addInTail(new Node(2));
        testList.addInTail(new Node(3));

        Assertions.assertTrue(testList.count() == 3);
    }
}