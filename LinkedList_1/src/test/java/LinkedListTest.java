import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    java.util.LinkedList<Integer> testLL = new java.util.LinkedList<Integer>();
    LinkedList s_list = new LinkedList();
    LinkedList empty_list = new LinkedList();
    LinkedList one_elem_list = new LinkedList();
    LinkedList bigRandomList = new LinkedList();
    int randValue;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws IOException {
        // LinkedList from java.util library
        testLL.add(15);
        testLL.add(25);
        testLL.add(50);
        
        // usual LinkedList
        s_list.addInTail(new Node(50));
        s_list.addInTail(new Node(15));
        s_list.addInTail(new Node(50));
        s_list.addInTail(new Node(25));
        s_list.addInTail(new Node(50));

        // empty LinkedList
        LinkedList empty_list = new LinkedList();

        // LinkedList with just one element
        one_elem_list.addInTail(new Node(10));

        // LinkedList with length = 10_000 and values from 10 to 200
        bigRandomList = MethodsForTesting.LLGenerate(10, 200, 100000);

        // Random value
        randValue = (int)(Math.random() * (150 - 15) + 15);
    }

    // Delete one element by value. Regression test.
    @org.junit.jupiter.api.Test
    @DisplayName("Remove one element from various lists regression method")
    public void removeOneElemRegression() throws Exception
    {
        Assertions.assertEquals(true, one_elem_list.Remove(10));
        Assertions.assertEquals(false, one_elem_list.Remove(15));
        Assertions.assertEquals(true, s_list.Remove(25));
        Assertions.assertEquals(true, s_list.Remove(50));
        Assertions.assertEquals(false, empty_list.Remove(10));
    }

    // Delete one element from huge random LinkedList
    @org.junit.jupiter.api.Test
    @DisplayName("Remove one node from list with 100_000 nodes")
    public void removeOneElemHugeList() throws Exception
    {
        Assertions.assertEquals(true, bigRandomList.Remove(150));
    }

    // Multiple deletion random element from random linkedlist
    @RepeatedTest(10000)
    @DisplayName("Remove random node from random linked list 10000 times")
    public void removeOneElemMultipleTimes() throws Exception
    {
        LinkedList testList = MethodsForTesting.LLGenerate(10, 200, 10000);
        Assertions.assertEquals(true, testList.Remove(randValue));
    }

    // Removing of all nodes with given value. Regression test.
    @org.junit.jupiter.api.Test
    @DisplayName("Remove all nodes with given value. Regression test")
    public void removeAllRegression() throws Exception
    {
        s_list.removeAll(50);
        Assertions.assertEquals(true, s_list.find(50) == null);
        empty_list.removeAll(15);
        Assertions.assertEquals(true, empty_list.head == null);
        one_elem_list.removeAll(10);
        Assertions.assertEquals(true, one_elem_list.head == null);
    }

    // Delete all nodes with given value from huge random LinkedList
    @org.junit.jupiter.api.Test
    @DisplayName("Remove all nodes with given value from huge list")
    public void removeAllFromHugeList() throws Exception
    {
        bigRandomList.removeAll(150);
        Assertions.assertEquals(true, bigRandomList.find(150) == null);
    }

    // Multiple deletions of all nodes with random value from random linkedlist
    @RepeatedTest(10000)
    @DisplayName("Remove all nodes with random value from random list 10000 times")
    public void removeAllWithRandValue() throws Exception
    {
        int rand = randValue;
        LinkedList testList = MethodsForTesting.LLGenerate(100, 200, 1000);
        testList.removeAll(rand);
        Assertions.assertEquals(true, testList.find(rand) == null);
    }

    @org.junit.jupiter.api.Test
    void findAll() {
    }

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void count() {
    }

    @org.junit.jupiter.api.Test
    void insertAfter() {
    }
}