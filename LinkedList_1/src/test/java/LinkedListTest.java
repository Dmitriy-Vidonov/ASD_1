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
    java.util.LinkedList<Integer> LLcopyOfBigRandList = new java.util.LinkedList<>();
    int randValue;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws IOException {
        // LinkedList from java.util library
        testLL.add(50);
        testLL.add(15);
        testLL.add(50);
        testLL.add(25);
        testLL.add(50);
        
        // LinkedList from default package
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
        LLcopyOfBigRandList = MethodsForTesting.LinkedListCopy(bigRandomList);

        // Random value
        randValue = (int)(Math.random() * (150 - 15) + 15);
    }

    // Delete one element by value. Regression test.
    @Test
    @DisplayName("Remove one element from various lists regression method")
    void removeOneElemRegression() throws Exception
    {
        assertEquals(true, one_elem_list.remove(10));
        assertEquals(false, one_elem_list.remove(15));
        assertEquals(true, s_list.remove(25));
        assertEquals(true, s_list.remove(50));
        assertEquals(false, empty_list.remove(10));
    }

    // Delete one element from huge random LinkedList
    @org.junit.jupiter.api.Test
    @DisplayName("Remove one node from list with 100_000 nodes")
    void removeOneElemHugeList() throws Exception
    {
        Assertions.assertEquals(true, bigRandomList.remove(150));
    }

    // Multiple deletion random element from random linkedlist
    @RepeatedTest(10000)
    @DisplayName("Remove random node from random linked list 10000 times")
    void removeOneElemMultipleTimes() throws Exception
    {
        LinkedList testList = MethodsForTesting.LLGenerate(10, 200, 10000);
        Assertions.assertEquals(true, testList.remove(randValue));
    }

    // Removing of all nodes with given value. Regression test.
    @org.junit.jupiter.api.Test
    @DisplayName("Remove all nodes with given value. Regression test")
    void removeAllRegression() throws Exception
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
    void removeAllFromHugeList() throws Exception
    {
        bigRandomList.removeAll(150);
        Assertions.assertEquals(true, bigRandomList.find(150) == null);
    }

    // Multiple deletions of all nodes with random value from random linkedlist
    @RepeatedTest(10000)
    @DisplayName("Remove all nodes with random value from random list 10000 times")
    void removeAllWithRandValue() throws Exception
    {
        int rand = randValue;
        LinkedList testList = MethodsForTesting.LLGenerate(100, 200, 1000);
        testList.removeAll(rand);
        Assertions.assertEquals(true, testList.find(rand) == null);
    }

    // Testing clear() method. Regression test.
    @org.junit.jupiter.api.Test
    @DisplayName("Clear linked list. Regression test.")
    void clear() throws Exception{
        one_elem_list.clear();
        Assertions.assertEquals(true, one_elem_list.head == null);
    }

    // Testing clear() method on huge linked list
    @org.junit.jupiter.api.Test
    @DisplayName("Clear huge linked list")
    void clearHugeList() throws Exception
    {
        bigRandomList.clear();
        Assertions.assertEquals(true, bigRandomList.head == null);
    }

    // Testing clear() method multiple times with random linked lists
    @RepeatedTest(10000)
    @DisplayName("Clear list multiple times")
    void clearMultiple() throws Exception
    {
        LinkedList testList = MethodsForTesting.LLGenerate(10, 200, 10000);
        testList.clear();
        Assertions.assertEquals(true, testList.head == null);
    }

    // Testing findAll() method. Regression test.
    @org.junit.jupiter.api.Test
    @DisplayName("Regression test for findAll() method")
    void findAll() throws Exception
    {
        Assertions.assertEquals(true, MethodsForTesting.listsComparison(s_list, testLL, 15));
    }

    // Testing findAll() with huge lists
    @org.junit.jupiter.api.Test
    @DisplayName("Test findAll() method on huge list")
    void findAllHugeList() throws Exception
    {
        Assertions.assertEquals(true, MethodsForTesting
                .listsComparison(bigRandomList, LLcopyOfBigRandList, 15));
    }

    // Testing findAll() multiple times
    @RepeatedTest(10000)
    @DisplayName("Test findAll() with rand lists multiple times")
    void findAllMultipleTimes() throws Exception
    {
        LinkedList test_LL = MethodsForTesting.LLGenerate(10, 100, 1000);
        java.util.LinkedList<Integer> java_LL = MethodsForTesting.LinkedListCopy(test_LL);
        Assertions.assertEquals(true, MethodsForTesting.listsComparison(test_LL, java_LL, 15));
    }

    // Testing count(). Regression test
    @org.junit.jupiter.api.Test
    @DisplayName("Regression test for count()")
    void countRegression() throws Exception
    {
        Assertions.assertEquals(true, s_list.count() == 5);
        Assertions.assertEquals(true, bigRandomList.count() == 100000);
    }

    // Testing count() with random length lists
    @RepeatedTest(10000)
    @DisplayName("count() with rand lengths")
    void countRandLenLists() throws Exception
    {
        LinkedList testLL = MethodsForTesting.LLGenerate(10, 100,
                ((int) (Math.random() * (5000 - 1000)) + 1000));
        Assertions.assertEquals(true,
                testLL.count() == MethodsForTesting.LinkedListCopy(testLL).size());
    }

    // Regression test for insertAfter() method
    @org.junit.jupiter.api.Test
    @DisplayName("Regression test for insertAfter()")
    void insertAfterRegression() throws Exception
    {
        empty_list.insertAfter(null, new Node(15));
        Assertions.assertEquals(true, empty_list.head.value == 15);
        s_list.insertAfter(s_list.tail, new Node(25));
        Assertions.assertEquals(true, s_list.tail.value == 25);
    }
}