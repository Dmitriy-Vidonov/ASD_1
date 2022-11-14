package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Test_clear {

    LinkedList2 workList = new LinkedList2();
    LinkedList2 emptyList = new LinkedList2();

    @Test
    @DisplayName("1) Список пуст")
    void clear_EmptyList() throws Exception
    {
        workList.clear();

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, emptyList));
        Assertions.assertTrue(workList.head == null);
        Assertions.assertTrue(workList.tail == null);
    }

    @Test
    @DisplayName("2) Список из 1 узла")
    void clear_Just1NodeList() throws Exception
    {
        Node n1 = new Node(1);

        workList.addInTail(n1);

        workList.clear();

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, emptyList));
        Assertions.assertTrue(workList.head == null);
        Assertions.assertTrue(workList.tail == null);
    }

    @Test
    @DisplayName("3) Список из ряда узлов")
    void clear_ManyNodesList() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3);

        workList.clear();

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, emptyList));
        Assertions.assertTrue(workList.head == null);
        Assertions.assertTrue(workList.tail == null);
    }

}