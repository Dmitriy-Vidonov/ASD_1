package fixedtailsversion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    LinkedList empty_list = new LinkedList();
    LinkedList one_node_list = new LinkedList();
    LinkedList fewSameAtBegin = new LinkedList();
    int one_node_value;
    int fewSameVal;
    LinkedList allNodesAreSame = new LinkedList();
    LinkedList allSameButFirst = new LinkedList();
    LinkedList allSameButLast = new LinkedList();
    LinkedList fewSameAtEnd = new LinkedList();
    LinkedList begin_center_end = new LinkedList();
    ArrayList<Node> testValuesArrList = new ArrayList<>();

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws IOException {
        one_node_value = 15;
        fewSameVal = 10;

        one_node_list.addInTail(new Node(one_node_value));
        allSameButFirst.addInTail(new Node(100));
        fewSameAtEnd.addInTail(new Node(500));
        fewSameAtEnd.addInTail(new Node(600));
        fewSameAtEnd.addInTail(new Node(530));

        for(int i=0; i<5; i++)
        {
            fewSameAtBegin.addInTail(new Node(fewSameVal));
            allNodesAreSame.addInTail(new Node(fewSameVal));
            allSameButFirst.addInTail(new Node(fewSameVal));
            allSameButLast.addInTail(new Node(fewSameVal));
            fewSameAtEnd.addInTail(new Node(fewSameVal));
            begin_center_end.addInTail(new Node(fewSameVal));
        }
        fewSameAtBegin.addInTail(new Node(40));
        fewSameAtBegin.addInTail(new Node(50));
        allSameButLast.addInTail(new Node(150));

        begin_center_end.addInTail(new Node(78));
        begin_center_end.addInTail(new Node(89));

        for(int i=0; i<5; i++)
            begin_center_end.addInTail(new Node(fewSameVal));

        begin_center_end.addInTail(new Node(178));
        begin_center_end.addInTail(new Node(289));

        for(int i=0; i<5; i++)
            begin_center_end.addInTail(new Node(fewSameVal));

        for(int i=0; i<15; i++)
            testValuesArrList.add(new Node(fewSameVal));
    }

    // List is empty
    @org.junit.jupiter.api.Test
    @DisplayName("1) List is empty")
    void removeAllEmptyList() throws Exception
    {
        LinkedList empty2 = new LinkedList();
        empty2.removeAll(10);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(empty_list)
                .equals(MethodsForTests.LinkedListCopy(empty2)));
    }

    // List with one node
    @org.junit.jupiter.api.Test
    @DisplayName("2) List with one node")
    void removeAllOneNodeList() throws Exception
    {
        one_node_list.removeAll(one_node_value);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(empty_list)
                .equals(MethodsForTests.LinkedListCopy(one_node_list)));
    }

    // List with few same nodes at the beginning
    @org.junit.jupiter.api.Test
    @DisplayName("3) List with few same nodes at the beginning")
    void removeAllFewNodesAtBegin() throws Exception
    {
        fewSameAtBegin.removeAll(fewSameVal);
        LinkedList few2 = new LinkedList();

        few2.addInTail(new Node(40));
        few2.addInTail(new Node(50));

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(fewSameAtBegin)
                .equals(MethodsForTests.LinkedListCopy(few2)));
        Assertions.assertEquals(true, fewSameAtBegin.head.value == few2.head.value);
        Assertions.assertEquals(true, fewSameAtBegin.tail.value == few2.tail.value);
    }

    // All nodes in list are the same
    @org.junit.jupiter.api.Test
    @DisplayName("4) All nodes in list are the same")
    void removeAllTheSame() throws Exception
    {
        allNodesAreSame.removeAll(fewSameVal);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(empty_list)
                .equals(MethodsForTests.LinkedListCopy(allNodesAreSame)));
    }

    // Only the first node is not target
    @org.junit.jupiter.api.Test
    @DisplayName("5) Remove all but not first")
    void removeAllButFirst() throws Exception
    {
        allSameButFirst.removeAll(fewSameVal);
        java.util.LinkedList<Integer> testList = new java.util.LinkedList<>();
        testList.add(100);

        Assertions.assertEquals(true, testList
                .equals(MethodsForTests.LinkedListCopy(allSameButFirst)));
        Assertions.assertEquals(true, allSameButFirst.head.value == 100);
        Assertions.assertEquals(true, allSameButFirst.tail.value == 100);
    }

    // Only the last node is not target
    @org.junit.jupiter.api.Test
    @DisplayName("6) Remove all but not last")
    void removeAllButLast() throws Exception
    {
        allSameButLast.removeAll(fewSameVal);

        java.util.LinkedList<Integer> testList = new java.util.LinkedList<>();
        testList.add(150);

        Assertions.assertEquals(true, testList
                .equals(MethodsForTests.LinkedListCopy(allSameButLast)));
        Assertions.assertEquals(true, allSameButLast.head.value == 150);
        Assertions.assertEquals(true, allSameButLast.tail.value == 150);
    }

    // List with the same nodes at the end of list
    @org.junit.jupiter.api.Test
    @DisplayName("7) Remove all nodes at the end")
    void removeAllAtTheEnd() throws Exception
    {
        fewSameAtEnd.removeAll(fewSameVal);

        java.util.LinkedList<Integer> testList = new java.util.LinkedList<>();
        testList.add(500);
        testList.add(600);
        testList.add(530);

        Assertions.assertEquals(true, testList
                .equals(MethodsForTests.LinkedListCopy(fewSameAtEnd)));
        Assertions.assertEquals(true, fewSameAtEnd.head.value == 500);
        Assertions.assertEquals(true, fewSameAtEnd.tail.value == 530);
    }

    // Target nodes are at the beginning, at the center and at the end of list
    @org.junit.jupiter.api.Test
    @DisplayName("8) Remove nodes at start, center, end")
    void removeFromStartCenterEnd() throws Exception
    {
        begin_center_end.removeAll(fewSameVal);

        java.util.LinkedList<Integer> testList = new java.util.LinkedList<>();
        testList.add(78);
        testList.add(89);
        testList.add(178);
        testList.add(289);

        Assertions.assertEquals(true, testList
                .equals(MethodsForTests.LinkedListCopy(begin_center_end)));
        Assertions.assertEquals(true, begin_center_end.head.value == 78);
        Assertions.assertEquals(true, begin_center_end.tail.value == 289);
    }

    // Find nodes with the same values from various places in the list. findAll() test
    @org.junit.jupiter.api.Test
    @DisplayName("9) findAll() for nodes in various places")
    void findAllFromVariousPlaces() throws Exception
    {
        ArrayList<Node> primeArrList = begin_center_end.findAll(fewSameVal);

        Assertions.assertEquals(true, MethodsForTests
                .twoArrListsValuesCompare(primeArrList,testValuesArrList));
    }
}