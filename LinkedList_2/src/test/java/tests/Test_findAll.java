package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class Test_findAll {

    LinkedList2 LLnodes = new LinkedList2();
    ArrayList<Node> ArrLnodes = new ArrayList<Node>();
    ArrayList<Node> emptyArrNodes = new ArrayList<Node>();

    @Test
    @DisplayName("1) Один узел в начале списка")
    void findAll1NodeAtStart() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        LLnodes.addInTail(n1); LLnodes.addInTail(n2); LLnodes.addInTail(n3);
        ArrLnodes.add(n1);

        Assertions.assertEquals(true, LLnodes.findAll(1).equals(ArrLnodes));
        Assertions.assertEquals(false, LLnodes.findAll(10).equals(ArrLnodes));
        Assertions.assertEquals(true, LLnodes.findAll(10).equals(emptyArrNodes));
    }

    @Test
    @DisplayName("2) Два узла в начале списка")
    void findAll12NodesAtStart() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(3);

        LLnodes.addInTail(n1); LLnodes.addInTail(n2); LLnodes.addInTail(n3); LLnodes.addInTail(n4);
        ArrLnodes.add(n1); ArrLnodes.add(n2);

        Assertions.assertEquals(true, LLnodes.findAll(1).equals(ArrLnodes));
        Assertions.assertEquals(false, LLnodes.findAll(10).equals(ArrLnodes));
        Assertions.assertEquals(true, LLnodes.findAll(10).equals(emptyArrNodes));
    }

    @Test
    @DisplayName("3) Узел в середине списка")
    void findAll1NodeAtMid() throws Exception
    {
        Node n1 = new Node(2);
        Node n2 = new Node(1);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        LLnodes.addInTail(n1); LLnodes.addInTail(n2); LLnodes.addInTail(n3); LLnodes.addInTail(n4);
        ArrLnodes.add(n2);

        Assertions.assertEquals(true, LLnodes.findAll(1).equals(ArrLnodes));
        Assertions.assertEquals(false, LLnodes.findAll(10).equals(ArrLnodes));
        Assertions.assertEquals(true, LLnodes.findAll(10).equals(emptyArrNodes));
    }

    @Test
    @DisplayName("4) Два узла в середине списка")
    void findAll2NodesAtMid() throws Exception
    {
        Node n1 = new Node(2);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(3);

        LLnodes.addInTail(n1); LLnodes.addInTail(n2); LLnodes.addInTail(n3); LLnodes.addInTail(n4);
        ArrLnodes.add(n2); ArrLnodes.add(n3);

        Assertions.assertEquals(true, LLnodes.findAll(1).equals(ArrLnodes));
        Assertions.assertEquals(false, LLnodes.findAll(10).equals(ArrLnodes));
        Assertions.assertEquals(true, LLnodes.findAll(10).equals(emptyArrNodes));
    }

    @Test
    @DisplayName("5) Один узел в конце списка")
    void findAllNodeAtEnd() throws Exception
    {
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(1);

        LLnodes.addInTail(n1); LLnodes.addInTail(n2); LLnodes.addInTail(n3);
        ArrLnodes.add(n3);

        Assertions.assertEquals(true, LLnodes.findAll(1).equals(ArrLnodes));
        Assertions.assertEquals(false, LLnodes.findAll(10).equals(ArrLnodes));
        Assertions.assertEquals(true, LLnodes.findAll(10).equals(emptyArrNodes));
    }

    @Test
    @DisplayName("6) Два узла в конце списка")
    void findAll2NodesAtEnd() throws Exception
    {
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(1);
        Node n4 = new Node(1);

        LLnodes.addInTail(n1); LLnodes.addInTail(n2); LLnodes.addInTail(n3); LLnodes.addInTail(n4);
        ArrLnodes.add(n3); ArrLnodes.add(n4);

        Assertions.assertEquals(true, LLnodes.findAll(1).equals(ArrLnodes));
        Assertions.assertEquals(false, LLnodes.findAll(10).equals(ArrLnodes));
        Assertions.assertEquals(true, LLnodes.findAll(10).equals(emptyArrNodes));
    }

    @Test
    @DisplayName("7) Три узла в начале, середине и конце списка")
    void findAll3NodesAtStartMidEnd() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(1);
        Node n5 = new Node(4);
        Node n6 = new Node(1);

        LLnodes.addInTail(n1); LLnodes.addInTail(n2); LLnodes.addInTail(n3);
        LLnodes.addInTail(n4); LLnodes.addInTail(n5); LLnodes.addInTail(n6);
        ArrLnodes.add(n1); ArrLnodes.add(n4); ArrLnodes.add(n6);

        Assertions.assertEquals(true, LLnodes.findAll(1).equals(ArrLnodes));
        Assertions.assertEquals(false, LLnodes.findAll(10).equals(ArrLnodes));
        Assertions.assertEquals(true, LLnodes.findAll(10).equals(emptyArrNodes));
    }

    @Test
    @DisplayName("8) Список пустой")
    void findAllEmptyList() throws Exception
    {
        Assertions.assertEquals(true, LLnodes.findAll(1).equals(emptyArrNodes));
    }

    @Test
    @DisplayName("9) Список из одного узла")
    void findAllJustOneNode() throws Exception
    {
        Node n1 = new Node(1);

        LLnodes.addInTail(n1);
        ArrLnodes.add(n1);

        Assertions.assertEquals(true, LLnodes.findAll(1).equals(ArrLnodes));
        Assertions.assertEquals(false, LLnodes.findAll(10).equals(ArrLnodes));
        Assertions.assertEquals(true, LLnodes.findAll(10).equals(emptyArrNodes));
    }

    @Test
    @DisplayName("10) Все узлы под поиск")
    void findAllAllNodes() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(1);

        LLnodes.addInTail(n1); LLnodes.addInTail(n2); LLnodes.addInTail(n3); LLnodes.addInTail(n4);
        ArrLnodes.add(n1); ArrLnodes.add(n2); ArrLnodes.add(n3); ArrLnodes.add(n4);

        Assertions.assertEquals(true, LLnodes.findAll(1).equals(ArrLnodes));
        Assertions.assertEquals(false, LLnodes.findAll(10).equals(ArrLnodes));
        Assertions.assertEquals(true, LLnodes.findAll(10).equals(emptyArrNodes));
    }

    @Test
    @DisplayName("11) Все узлы кроме первого")
    void findAllAllNodesButFirst() throws Exception
    {
        Node n1 = new Node(2);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(1);

        LLnodes.addInTail(n1); LLnodes.addInTail(n2); LLnodes.addInTail(n3); LLnodes.addInTail(n4);
        ArrLnodes.add(n2); ArrLnodes.add(n3); ArrLnodes.add(n4);

        Assertions.assertEquals(true, LLnodes.findAll(1).equals(ArrLnodes));
        Assertions.assertEquals(false, LLnodes.findAll(10).equals(ArrLnodes));
        Assertions.assertEquals(true, LLnodes.findAll(10).equals(emptyArrNodes));
    }

    @Test
    @DisplayName("12) Все узлы кроме последнего")
    void findAllAllNodesButLast() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(2);

        LLnodes.addInTail(n1); LLnodes.addInTail(n2); LLnodes.addInTail(n3); LLnodes.addInTail(n4);
        ArrLnodes.add(n1); ArrLnodes.add(n2); ArrLnodes.add(n3);

        Assertions.assertEquals(true, LLnodes.findAll(1).equals(ArrLnodes));
        Assertions.assertEquals(false, LLnodes.findAll(10).equals(ArrLnodes));
        Assertions.assertEquals(true, LLnodes.findAll(10).equals(emptyArrNodes));
    }

    @Test
    @DisplayName("13) Все узлы кроме узла по центру")
    void findAllAllNodesButMid() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(1);
        Node n5 = new Node(1);

        LLnodes.addInTail(n1); LLnodes.addInTail(n2); LLnodes.addInTail(n3);
        LLnodes.addInTail(n4); LLnodes.addInTail(n5);

        ArrLnodes.add(n1); ArrLnodes.add(n2); ArrLnodes.add(n4); ArrLnodes.add(n5);

        Assertions.assertEquals(true, LLnodes.findAll(1).equals(ArrLnodes));
        Assertions.assertEquals(false, LLnodes.findAll(10).equals(ArrLnodes));
        Assertions.assertEquals(true, LLnodes.findAll(10).equals(emptyArrNodes));
    }
}