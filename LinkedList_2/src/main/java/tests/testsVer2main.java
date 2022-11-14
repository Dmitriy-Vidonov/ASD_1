package tests;

import java.util.ArrayList;

public class testsVer2main {
    public static void main(String[] args)
    {
        // *** СРАВНЕНИЕ 2-х УЗЛОВ ***
        System.out.println("Сравнение 2-х узлов:");

        Node n1 = new Node(1); Node n2 = new Node(2); Node n3 = new Node(3);
        LinkedList2 testList = new LinkedList2();
        testList.addInTail(n1); testList.addInTail(n2); testList.addInTail(n3);

        System.out.println("равны ли узлы: " + (n1 == n1) + " или " + (n1 == n2)); // true и false

        // *** СРАВНЕНИЕ 2-х ArrayList<Node> ***
        System.out.println("Сравнение 2-х ArrayList<Node>:");

        ArrayList<Node> nodes1 = new ArrayList<Node>();
        ArrayList<Node> nodes2 = new ArrayList<Node>();

        nodes1.add(n1);
        nodes1.add(n2);
        nodes1.add(n3);

        nodes2.add(n1);
        //nodes2.add(n2);
        nodes2.add(n3);

        System.out.println("Равны ли списки: " + nodes1.equals(nodes2)); // Возвращает true или false
        System.out.println("nodes1 = " + nodes1);
        System.out.println("nodes2 = " + nodes2);
        System.out.println("*");

        // *** СРАВНЕНИЕ 2-х LinkedList() ***
        System.out.println("Сравнение 2-х LinkedList():");

        LinkedList2 list_1 = new LinkedList2();
        LinkedList2 list_2 = new LinkedList2();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(1);

        // Следует решить, как сравнивать LinkedList-ы
        list_1.addInTail(node1);
        list_1.addInTail(node2);
        list_1.addInTail(node3);

        list_2.addInTail(node1);
        list_2.addInTail(node4);
        list_2.addInTail(node2);
        list_2.addInTail(node3);

        System.out.println("Равны ли два LinkedList():" + list_1.equals(list_2));
        System.out.println("*");

        // *** ПРОВЕРКА МЕТОДА remove() ***
        System.out.println("Проверка метода remove()");
        System.out.println("удаление элемента - " + list_1.remove(10)); // true или false
        System.out.println("*");

        // *** ПРОВЕРКА МЕТОДА removeAll() ***
        Node nn1 = new Node(1);
        Node nn2 = new Node(3);
        Node nn3 = new Node(4);
        Node nn4 = new Node(4);
        Node nn5 = new Node(4);

        LinkedList2 list_3 = new LinkedList2();

        list_3.addInTail(nn1); list_3.addInTail(nn2); list_3.addInTail(nn3);
        list_3.addInTail(nn4); list_3.addInTail(nn5);

        System.out.println("Проверка метода removeAll()");
        MethodsForTesting.ShowNodesValues(list_3);
        list_3.removeAll(1);
        MethodsForTesting.ShowNodesValues(list_3);
        if (list_3.head != null)
        {
            System.out.println("head = " + list_3.head.value);
            System.out.println("tail = " + list_3.tail.value);
        }
        System.out.println("*");

        // *** ПРОВЕРКА МЕТОДА insertAfter() ***
        System.out.println("ПРОВЕРКА МЕТОДА insertAfter()");

        Node insNode1 = new Node(1);
        Node insNode2 = new Node(2);
        Node insNode3 = new Node(3);

        LinkedList2 emptyList = new LinkedList2();

        Node toInsert = new Node(10);

        emptyList.addInTail(insNode1); emptyList.addInTail(insNode2); emptyList.addInTail(insNode3);

        MethodsForTesting.ShowNodesValues(emptyList);

        emptyList.insertAfter(insNode2, toInsert);

        MethodsForTesting.ShowNodesValues(emptyList);

        if (emptyList.head != null)
        {
            System.out.println("head = " + emptyList.head.value);
            System.out.println("tail = " + emptyList.tail.value);
            System.out.println("head.prev = " + emptyList.head.prev);
            System.out.println("head.next = " + emptyList.head.next.value);
            System.out.println("tail.prev = " + emptyList.tail.prev.value);
            System.out.println("tail.next = " + emptyList.tail.next);
        }

    }
}
