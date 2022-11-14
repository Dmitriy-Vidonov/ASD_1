package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Test_insertAfter {

    LinkedList2 testList = new LinkedList2();
    LinkedList2 regressionList = new LinkedList2();
    LinkedList2 emptyList = new LinkedList2();
    LinkedList2 OneNodeList = new LinkedList2();

    @Test
    @DisplayName("1) Список пуст")
    void insertAfter_EmptyList() throws Exception
    {
        Node n1 = new Node(1);

        regressionList.addInTail(n1);

        emptyList.insertAfter(null, n1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(emptyList, regressionList));
        Assertions.assertTrue(emptyList.head.value == n1.value && emptyList.tail.value == n1.value);
    }

    @Test
    @DisplayName("2) Список из одного узла, вставка перед ним")
    void insertAfter_1NodeListInsertBeforeNode() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);

        OneNodeList.addInTail(n1);

        regressionList.addInTail(n2);
        regressionList.addInTail(n1);

        OneNodeList.insertAfter(null, n2);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(OneNodeList, regressionList));
        Assertions.assertTrue(OneNodeList.head.value == n2.value && OneNodeList.tail.value == n1.value);
    }

    @Test
    @DisplayName("3) Список из одного узла, вставка после него")
    void insertAfter_1NodeListInsertAfterNode() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);

        OneNodeList.addInTail(n1);

        regressionList.addInTail(n1);
        regressionList.addInTail(n2);

        OneNodeList.insertAfter(n1, n2);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(OneNodeList, regressionList));
        Assertions.assertTrue(OneNodeList.head.value == n1.value && OneNodeList.tail.value == n2.value);
    }

    @Test
    @DisplayName("4) Список из ряда узлов, вставка первым узлом")
    void insertAfter_FewNodeListInsertAtVeryStart() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node toInsert = new Node(10);

        regressionList.addInTail(toInsert);
        regressionList.addInTail(n1);
        regressionList.addInTail(n2);
        regressionList.addInTail(n3);

        testList.addInTail(n1);
        testList.addInTail(n2);
        testList.addInTail(n3);

        testList.insertAfter(null, toInsert);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(testList, regressionList));
        Assertions.assertTrue(testList.head.value == toInsert.value && testList.tail.value == n3.value);
    }

    @Test
    @DisplayName("5) Список из ряда узлов, вставка после первого узлом")
    void insertAfter_InsertAfterFirst() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node toInsert = new Node(10);

        regressionList.addInTail(n1);
        regressionList.addInTail(toInsert);
        regressionList.addInTail(n2);
        regressionList.addInTail(n3);

        testList.addInTail(n1);
        testList.addInTail(n2);
        testList.addInTail(n3);

        testList.insertAfter(n1, toInsert);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(testList, regressionList));
    }

}