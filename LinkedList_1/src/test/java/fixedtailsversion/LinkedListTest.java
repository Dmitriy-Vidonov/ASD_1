package fixedtailsversion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;

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
}