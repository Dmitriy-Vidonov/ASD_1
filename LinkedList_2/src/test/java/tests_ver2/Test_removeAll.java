package tests_ver2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test_removeAll {

    LinkedList2 workList = new LinkedList2();
    LinkedList2 regressionList = new LinkedList2();
    LinkedList2 emptyList = new LinkedList2();

    @Test
    @DisplayName("1) Один узел в начале")
    void removeAll_NodeAtStart() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3);
        regressionList.addInTail(n2); regressionList.addInTail(n3);

        workList.removeAll(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }

    @Test
    @DisplayName("2) Один узел в конце")
    void removeAll_NodeAtEnd() throws Exception
    {
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(1);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3); workList.addInTail(n4);
        regressionList.addInTail(n1); regressionList.addInTail(n2); regressionList.addInTail(n3);

        workList.removeAll(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }

    @Test
    @DisplayName("3) Два узла в начале")
    void removeAll_2NodesAtStart() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(3);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3); workList.addInTail(n4);
        regressionList.addInTail(n3); regressionList.addInTail(n4);

        workList.removeAll(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }

    @Test
    @DisplayName("4) Два узла в конце")
    void removeAll_2NodesAtEnd() throws Exception
    {
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(1);
        Node n5 = new Node(1);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3);
        workList.addInTail(n4); workList.addInTail(n5);

        regressionList.addInTail(n1); regressionList.addInTail(n2); regressionList.addInTail(n3);

        workList.removeAll(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }

    @Test
    @DisplayName("5) Один узел в середине")
    void removeAll_NodeAtMid() throws Exception
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

        workList.removeAll(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }

    @Test
    @DisplayName("6) Два узла в середине")
    void removeAll_2NodesAtMid() throws Exception
    {
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(1);
        Node n4 = new Node(1);
        Node n5 = new Node(4);
        Node n6 = new Node(5);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3);
        workList.addInTail(n4); workList.addInTail(n5); workList.addInTail(n6);

        regressionList.addInTail(n1); regressionList.addInTail(n2);
        regressionList.addInTail(n5); regressionList.addInTail(n6);

        workList.removeAll(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }

    @Test
    @DisplayName("7) Список пустой")
    void removeAll_EmptyList() throws Exception
    {
        workList.removeAll(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, emptyList));
    }

    @Test
    @DisplayName("8) Список из одного узла")
    void removeAll_OneNodeList() throws Exception
    {
        Node n1 = new Node(1);
        workList.addInTail(n1);

        workList.removeAll(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, emptyList));
    }

    @Test
    @DisplayName("9) Все узлы под удаление")
    void removeAll_AllNodes() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(1);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3); workList.addInTail(n4);

        workList.removeAll(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, emptyList));
    }

    @Test
    @DisplayName("10) Под удаление все кроме первого")
    void removeAll_AllNodesButFirst() throws Exception
    {
        Node n1 = new Node(2);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(1);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3); workList.addInTail(n4);

        regressionList.addInTail(n1);

        workList.removeAll(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }

    @Test
    @DisplayName("11) Под удаление все кроме последнего")
    void removeAll_AllNodesButLast() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(2);

        workList.addInTail(n1); workList.addInTail(n2);
        workList.addInTail(n3); workList.addInTail(n4);

        regressionList.addInTail(n4);

        workList.removeAll(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }

    @Test
    @DisplayName("12) Под удаление все кроме центра")
    void removeAll_AllNodesButMid() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(1);
        Node n5 = new Node(1);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3);
        workList.addInTail(n4); workList.addInTail(n5);

        regressionList.addInTail(n3);

        workList.removeAll(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }

    @Test
    @DisplayName("13) Под удаление узлы в начале, центре и конце")
    void removeAll_NodesAtStartMidEnd() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(1);
        Node n5 = new Node(4);
        Node n6 = new Node(1);

        workList.addInTail(n1); workList.addInTail(n2); workList.addInTail(n3);
        workList.addInTail(n4); workList.addInTail(n5); workList.addInTail(n6);

        regressionList.addInTail(n2); regressionList.addInTail(n3); regressionList.addInTail(n5);

        workList.removeAll(1);

        Assertions.assertTrue(MethodsForTesting.ListsEqualByNodes(workList, regressionList));
    }
}