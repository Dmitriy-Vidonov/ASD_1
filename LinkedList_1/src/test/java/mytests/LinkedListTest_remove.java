package mytests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinkedListTest_remove {

    LinkedList s_list = new LinkedList();
    LinkedList list_1 = new LinkedList();
    LinkedList list_2 = new LinkedList();
    LinkedList list_4 = new LinkedList();
    LinkedList list_6 = new LinkedList();
    LinkedList list_7 = new LinkedList();
    LinkedList list_10 = new LinkedList();

    LinkedList empty_list = new LinkedList();

    @BeforeEach
    void setUp() throws Exception {
        // Списки для регресионных тестов - заранее "эталонные" ответы
        // 1) Один элемент в начале + 3) Один элемент не в начале, не в конце
        // + 5) Один элемент в конце
        list_1.addInTail(new Node(2));
        list_1.addInTail(new Node(3));
        list_1.addInTail(new Node(5));

        // 2) Два элемента в начале
        list_2.addInTail(new Node(1));
        list_2.addInTail(new Node(2));
        list_2.addInTail(new Node(3));
        list_2.addInTail(new Node(5));

        // 4) Два элемента не в начале, не в конце
        list_4.addInTail(new Node(2));
        list_4.addInTail(new Node(1));
        list_4.addInTail(new Node(3));
        list_4.addInTail(new Node(5));

        // 6) Три элемента в конце
        list_6.addInTail(new Node(2));
        list_6.addInTail(new Node(3));
        list_6.addInTail(new Node(5));
        list_6.addInTail(new Node(1));
        list_6.addInTail(new Node(1));

        // 7) По одному элементу в начале, середине и конце
        list_7.addInTail(new Node(2));
        list_7.addInTail(new Node(1));
        list_7.addInTail(new Node(3));
        list_7.addInTail(new Node(1));

        // 10) Все элементы одинаковы
        list_10.addInTail(new Node(1));
        list_10.addInTail(new Node(1));
        list_10.addInTail(new Node(1));

    }

    @Test
    @DisplayName("1) Один элемент в начале")
    void remove1NodeAtStart() throws Exception
    {
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(5));

        s_list.remove(1);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(s_list)
                .equals(MethodsForTests.LinkedListCopy(list_1)));
        Assertions.assertEquals(true, s_list.head.value == list_1.head.value); // head = 2
        Assertions.assertEquals(true, s_list.tail.value == list_1.tail.value); // tail = 5
    }

    @Test
    @DisplayName("2) Два элемента в начале")
    void remove2NodesAtStart() throws Exception
    {
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(5));

        s_list.remove(1);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(s_list)
                .equals(MethodsForTests.LinkedListCopy(list_2)));
        Assertions.assertEquals(true, s_list.head.value == list_2.head.value); // head = 1
        Assertions.assertEquals(true, s_list.tail.value == list_2.tail.value); // tail = 5

    }

    @Test
    @DisplayName("3) Один элемент не в начале, не в конце")
    void remove1NodeInMiddle() throws Exception
    {
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(5));

        s_list.remove(1);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(s_list)
                .equals(MethodsForTests.LinkedListCopy(list_1)));
        Assertions.assertEquals(true, s_list.head.value == list_1.head.value); // head = 2
        Assertions.assertEquals(true, s_list.tail.value == list_1.tail.value); // tail = 5
    }

    @Test
    @DisplayName("4) Два элемента не в начале, не в конце")
    void remove2NodesInMiddle() throws Exception
    {
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(5));

        s_list.remove(1);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(s_list)
                .equals(MethodsForTests.LinkedListCopy(list_4)));
        Assertions.assertEquals(true, s_list.head.value == list_4.head.value); // head = 2
        Assertions.assertEquals(true, s_list.tail.value == list_4.tail.value); // tail = 5
    }

    @Test
    @DisplayName("5) Один элемент в конце")
    void remove1NodeAtEnd() throws Exception
    {
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(5));
        s_list.addInTail(new Node(1));

        s_list.remove(1);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(s_list)
                .equals(MethodsForTests.LinkedListCopy(list_1)));
        Assertions.assertEquals(true, s_list.head.value == list_1.head.value); // head = 2
        Assertions.assertEquals(true, s_list.tail.value == list_1.tail.value); // tail = 5
    }

    @Test
    @DisplayName("6) Три элемента в конце")
    void remove3NodesAtEnd() throws Exception
    {
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(5));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(1));

        s_list.remove(1);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(s_list)
                .equals(MethodsForTests.LinkedListCopy(list_6)));
        Assertions.assertEquals(true, s_list.head.value == list_6.head.value); // head = 2
        Assertions.assertEquals(true, s_list.tail.value == list_6.tail.value); // tail = 1
    }

    @Test
    @DisplayName("7) По одному элементу в начале, середине, конце")
    void remove3NodesAtStartMidEnd() throws Exception
    {
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(2));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(3));
        s_list.addInTail(new Node(1));

        s_list.remove(1);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(s_list)
                .equals(MethodsForTests.LinkedListCopy(list_7)));
        Assertions.assertEquals(true, s_list.head.value == list_7.head.value); // head = 2
        Assertions.assertEquals(true, s_list.tail.value == list_7.tail.value); // tail = 1
    }

    @Test
    @DisplayName("8) Список изначально пустой")
    void removeEmptyList() throws Exception
    {
        s_list.remove(1);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(s_list)
                .equals(MethodsForTests.LinkedListCopy(empty_list)));
    }

    @Test
    @DisplayName("9) Список из одного узла под удаление")
    void removeOnetoEmpty() throws Exception
    {
        s_list.addInTail(new Node(1));

        s_list.remove(1);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(s_list)
                .equals(MethodsForTests.LinkedListCopy(empty_list)));
    }

    @Test
    @DisplayName("10) Все узлы списка - под удаление")
    void removeAlltoEmpty() throws Exception
    {
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(1));
        s_list.addInTail(new Node(1));

        s_list.remove(1);

        Assertions.assertEquals(true, MethodsForTests.LinkedListCopy(s_list)
                .equals(MethodsForTests.LinkedListCopy(list_10)));
        Assertions.assertEquals(true, s_list.head.value == list_10.head.value); // head = 1
        Assertions.assertEquals(true, s_list.tail.value == list_10.tail.value); // tail = 1
    }
}