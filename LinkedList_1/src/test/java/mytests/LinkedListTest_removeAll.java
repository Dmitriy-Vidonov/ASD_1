package mytests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest_removeAll {

    LinkedList s_list = new LinkedList();
    LinkedList list_1 = new LinkedList();
    LinkedList list_7 = new LinkedList();
    LinkedList empty_list = new LinkedList();

    @BeforeEach
    void setUp() throws Exception {
        // Списки для регресионных тестов - заранее "эталонные" ответы
        // 1) Один элемент в начале + 2) Два элемента в начале + 3) Один элемент в середине
        // 4) Два элемента в середине + 5) Один элемент в конце + 6) Несколько элементов в конце
        list_1.addInTail(new Node(2));
        list_1.addInTail(new Node(3));
        list_1.addInTail(new Node(5));

        // 7) По одному элементу в начале, середине, конце
        list_7.addInTail(new Node(2));
        list_7.addInTail(new Node(3));
    }

    @Test
    @DisplayName("1) Один элемент в начале")
    void removeAll1NodeAtStart() throws Exception
    {
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(5));

        s_list.removeAll(1);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(s_list)
                .equals(MethodsForTests.LinkedListCopy(list_1)));
        Assertions.assertEquals(true, s_list.head.value == list_1.head.value); // head = 2
        Assertions.assertEquals(true, s_list.tail.value == list_1.tail.value); // tail = 5
    }

    @Test
    @DisplayName("2) Два элемента в начале")
    void removeAll2NodesAtStart() throws Exception
    {
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(5));

        s_list.removeAll(1);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(s_list)
                .equals(MethodsForTests.LinkedListCopy(list_1)));
        Assertions.assertEquals(true, s_list.head.value == list_1.head.value); // head = 2
        Assertions.assertEquals(true, s_list.tail.value == list_1.tail.value); // tail = 5
    }

    @Test
    @DisplayName("3) Один элемент в середине")
    void removeAll1NodesAtMid() throws Exception
    {
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(5));

        s_list.removeAll(1);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(s_list)
                .equals(MethodsForTests.LinkedListCopy(list_1)));
        Assertions.assertEquals(true, s_list.head.value == list_1.head.value); // head = 2
        Assertions.assertEquals(true, s_list.tail.value == list_1.tail.value); // tail = 5
    }

    @Test
    @DisplayName("4) Два элемента в середине")
    void removeAll2NodesAtMid() throws Exception
    {
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(5));

        s_list.removeAll(1);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(s_list)
                .equals(MethodsForTests.LinkedListCopy(list_1)));
        Assertions.assertEquals(true, s_list.head.value == list_1.head.value); // head = 2
        Assertions.assertEquals(true, s_list.tail.value == list_1.tail.value); // tail = 5
    }

    @Test
    @DisplayName("5) Один элемент в конце")
    void removeAll1NodesAtEnd() throws Exception
    {
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(5));
        s_list.addInTail(new Node(1));

        s_list.removeAll(1);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(s_list)
                .equals(MethodsForTests.LinkedListCopy(list_1)));
        Assertions.assertEquals(true, s_list.head.value == list_1.head.value); // head = 2
        Assertions.assertEquals(true, s_list.tail.value == list_1.tail.value); // tail = 5
    }

    @Test
    @DisplayName("6) Несколько элементов в конце")
    void removeAllNodesAtEnd() throws Exception
    {
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(5));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(1));

        s_list.removeAll(1);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(s_list)
                .equals(MethodsForTests.LinkedListCopy(list_1)));
        Assertions.assertEquals(true, s_list.head.value == list_1.head.value); // head = 2
        Assertions.assertEquals(true, s_list.tail.value == list_1.tail.value); // tail = 5
    }

    @Test
    @DisplayName("7) По одному элементу в начале, середине, конце")
    void removeAllNodesAtStartMidEnd() throws Exception
    {
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(1));

        s_list.removeAll(1);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(s_list)
                .equals(MethodsForTests.LinkedListCopy(list_7)));
        Assertions.assertEquals(true, s_list.head.value == list_7.head.value); // head = 2
        Assertions.assertEquals(true, s_list.tail.value == list_7.tail.value); // tail = 3
    }

    @Test
    @DisplayName("8) Список изначально пустой")
    void removeAllEmptyList() throws Exception
    {
        s_list.removeAll(1);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(s_list)
                .equals(MethodsForTests.LinkedListCopy(empty_list)));
    }

    @Test
    @DisplayName("9) Список из одного элемента на удаление")
    void removeOneNodetoEmpty() throws Exception
    {
        s_list.addInTail(new Node(1));
        s_list.removeAll(1);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(s_list)
                .equals(MethodsForTests.LinkedListCopy(empty_list)));
    }

    @Test
    @DisplayName("10) Все элементы списка - на удаление")
    void removeAllNodestoEmpty() throws Exception
    {
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(1));

        s_list.removeAll(1);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(s_list)
                .equals(MethodsForTests.LinkedListCopy(empty_list)));
    }

}