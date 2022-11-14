package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Test_remove {

    LinkedList2 workList = new LinkedList2();
    LinkedList2 regressionList = new LinkedList2();
    LinkedList2 emptyList = new LinkedList2();

    @Test
    @DisplayName("1) Один узел в начале")
    void remove_NodeAtStart() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3);
        regressionList.addInTail(n2); regressionList.addInTail(n3);

        workList.remove(1);

        Assertions.assertEquals(true, MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }

    @Test
    @DisplayName("2) Один узел в конце")
    void remove_NodeAtEnd() throws Exception
    {
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(1);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3); workList.addInTail(n4);
        regressionList.addInTail(n1); regressionList.addInTail(n2); regressionList.addInTail(n3);

        workList.remove(1);

        Assertions.assertEquals(true, MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }

    @Test
    @DisplayName("3) Два узла в начале")
    void remove_2NodesAtStart() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(3);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3); workList.addInTail(n4);
        regressionList.addInTail(n2); regressionList.addInTail(n3); regressionList.addInTail(n4);

        workList.remove(1);

        Assertions.assertEquals(true, MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }

    @Test
    @DisplayName("4) Два узла в конце")
    void remove_2NodesAtEnd() throws Exception
    {
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(1);
        Node n5 = new Node(1);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3);
        workList.addInTail(n4); workList.addInTail(n5);

        regressionList.addInTail(n1); regressionList.addInTail(n2);
        regressionList.addInTail(n3); regressionList.addInTail(n5);

        workList.remove(1);

        Assertions.assertEquals(true, MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }

    @Test
    @DisplayName("5) Один узел в середине")
    void remove_NodeAtMid() throws Exception
    {
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(1);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3);
        workList.addInTail(n4); workList.addInTail(n5);

        regressionList.addInTail(n1); regressionList.addInTail(n2);
        regressionList.addInTail(n4); regressionList.addInTail(n5);

        workList.remove(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }

    @Test
    @DisplayName("6) Два узла в середине")
    void remove_2NodesAtMid() throws Exception
    {
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(1);
        Node n4 = new Node(1);
        Node n5 = new Node(4);
        Node n6 = new Node(5);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3);
        workList.addInTail(n4); workList.addInTail(n5); workList.addInTail(n6);

        regressionList.addInTail(n1); regressionList.addInTail(n2); regressionList.addInTail(n4);
        regressionList.addInTail(n5); regressionList.addInTail(n6);

        workList.remove(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }

    @Test
    @DisplayName("7) Список пустой")
    void remove_EmptyList() throws Exception
    {
        workList.remove(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, emptyList));
    }

    @Test
    @DisplayName("8) Список из одного узла")
    void remove_OneNodeList() throws Exception
    {
        Node n1 = new Node(1);
        workList.addInTail(n1);

        workList.remove(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, emptyList));
    }

    @Test
    @DisplayName("9) Все узлы под удаление")
    void remove_AllNodes() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(1);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3); workList.addInTail(n4);
        regressionList.addInTail(n2); regressionList.addInTail(n3); regressionList.addInTail(n4);

        workList.remove(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }

    @Test
    @DisplayName("10) Под удаление все кроме первого")
    void remove_AllNodesButFirst() throws Exception
    {
        Node n1 = new Node(2);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(1);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3); workList.addInTail(n4);
        regressionList.addInTail(n1); regressionList.addInTail(n3); regressionList.addInTail(n4);

        workList.remove(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }

    @Test
    @DisplayName("11) Под удаление все кроме последнего")
    void remove_AllNodesButLast() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(2);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3); workList.addInTail(n4);
        regressionList.addInTail(n2); regressionList.addInTail(n3); regressionList.addInTail(n4);

        workList.remove(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }

    @Test
    @DisplayName("12) Под удаление все кроме центра")
    void remove_AllNodesButMid() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(1);
        Node n5 = new Node(1);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3);
        workList.addInTail(n4); workList.addInTail(n5);

        regressionList.addInTail(n2); regressionList.addInTail(n3);
        regressionList.addInTail(n4); regressionList.addInTail(n5);

        workList.remove(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }

    @Test
    @DisplayName("13) Под удаление узлы в начале, центре и конце")
    void remove_NodesAtStartMidEnd() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(1);
        Node n5 = new Node(4);
        Node n6 = new Node(1);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3);
        workList.addInTail(n4); workList.addInTail(n5); workList.addInTail(n6);

        regressionList.addInTail(n2); regressionList.addInTail(n3); regressionList.addInTail(n4);
        regressionList.addInTail(n5); regressionList.addInTail(n6);

        workList.remove(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }

}