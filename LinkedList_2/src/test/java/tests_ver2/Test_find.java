package tests_ver2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class Test_find {

    LinkedList2 testList = new LinkedList2();

    @org.junit.jupiter.api.Test
    @DisplayName("1) Один узел в начале списка")
    void find1NodeAtStart() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        testList.addInTail(n1);
        testList.addInTail(n2);
        testList.addInTail(n3);

        Assertions.assertEquals(true, testList.find(1) == n1);
        Assertions.assertEquals(true, testList.find(4) == null);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("2) Два узла в начале списка")
    void find1NodeFrom2AtStart() throws Exception
    {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(3);

        testList.addInTail(n1);
        testList.addInTail(n2);
        testList.addInTail(n3);
        testList.addInTail(n4);

        Assertions.assertEquals(true, testList.find(1) == n1);
        Assertions.assertEquals(true, testList.find(1) != n2);
        Assertions.assertEquals(true, testList.find(4) == null);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("3) Один узел в середине списка")
    void find1NodeAtMid() throws Exception
    {
        Node n1 = new Node(2);
        Node n2 = new Node(1);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        testList.addInTail(n1);
        testList.addInTail(n2);
        testList.addInTail(n3);
        testList.addInTail(n4);

        Assertions.assertEquals(true, testList.find(1) == n2);
        Assertions.assertEquals(true, testList.find(5) == null);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("4) Два узла в середине списка")
    void find2NodesAtMid() throws Exception
    {
        Node n1 = new Node(2);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(3);

        testList.addInTail(n1);
        testList.addInTail(n2);
        testList.addInTail(n3);
        testList.addInTail(n4);

        Assertions.assertEquals(true, testList.find(1) == n2);
        Assertions.assertEquals(true, testList.find(1) != n3);
        Assertions.assertEquals(true, testList.find(4) == null);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("5) Один узел в конце списка")
    void findNodeAtEnd() throws Exception
    {
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(1);

        testList.addInTail(n1);
        testList.addInTail(n2);
        testList.addInTail(n3);

        Assertions.assertEquals(true, testList.find(1) == n3);
        Assertions.assertEquals(true, testList.find(4) == null);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("6) Два узла в конце списка")
    void find2NodesAtEnd() throws Exception
    {
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(1);
        Node n4 = new Node(1);

        testList.addInTail(n1);
        testList.addInTail(n2);
        testList.addInTail(n3);
        testList.addInTail(n4);

        Assertions.assertEquals(true, testList.find(1) == n3);
        Assertions.assertEquals(true, testList.find(1) != n4);
        Assertions.assertEquals(true, testList.find(4) == null);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("7) Список пустой")
    void findEmptyList() throws Exception
    {
        Assertions.assertEquals(true, testList.find(1) == null);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("8) Список из единственного узла")
    void findOneNodeList() throws Exception
    {
        Node n = new Node(1);
        testList.addInTail(n);

        Assertions.assertEquals(true, testList.find(1) == n);
        Assertions.assertEquals(true, testList.find(4) == null);
    }
}