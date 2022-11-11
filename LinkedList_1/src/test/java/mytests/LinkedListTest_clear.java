package mytests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest_clear
{

    LinkedList one_node_list = new LinkedList();
    LinkedList s_list = new LinkedList();
    LinkedList empty_list = new LinkedList();

    @BeforeEach
    void setUp() throws Exception
    {
        one_node_list.addInTail(new Node(1));

        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(4));
        s_list.addInTail(new Node(5));
    }

    @Test
    @DisplayName("1) Пустой список на вход")
    void clearEmptyList() throws Exception
    {
        empty_list.clear();
        Assertions.assertEquals(true, MethodsForTests.isListNull(empty_list));
    }

    @Test
    @DisplayName("2) Список из одного значения")
    void clear1NodeList() throws Exception
    {
        one_node_list.clear();
        Assertions.assertEquals(true, MethodsForTests.isListNull(one_node_list));
    }

    @Test
    @DisplayName("3) Список из множества значений")
    void clearManyNodesList() throws Exception
    {
        s_list.clear();
        Assertions.assertEquals(true, MethodsForTests.isListNull(s_list));
    }
}