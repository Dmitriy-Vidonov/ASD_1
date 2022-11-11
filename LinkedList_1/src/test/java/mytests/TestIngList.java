package mytests;

import java.util.ArrayList;

public class TestingList {
    public static void main(String[] args) {
        LinkedList empty_list = new LinkedList();

        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(1);
        Node n5 = new Node(2);
        Node n6 = new Node(3);
        Node n7 = new Node(12);

        Node _nodeToInsert = new Node(15);

        LinkedList s_list = new LinkedList(); // инициализировали новый список

        s_list.addInTail(n1);
    /*    s_list.addInTail(n2);
        s_list.addInTail(n3);
        s_list.addInTail(n4);
        s_list.addInTail(n5);
        s_list.addInTail(n6);*/
        //  s_list.addInTail(n7);

        s_list.showAll();
       // System.out.println("remove status = " + s_list.remove(1));
        // s_list.removeAll(1);
        s_list.clear();
        //s_list.remove(1);
        s_list.showAll();
        System.out.println("head after remove = " + s_list.head);
        System.out.println("tail after remove = " + s_list.tail);
        System.out.println("list after remove = " + s_list);


        System.out.println("пустой список - ");
        empty_list.showAll();
        System.out.println("empty head = " + empty_list.head);
        System.out.println("empty tail = " + empty_list.tail);
        System.out.println("пустой список вывод - " + empty_list);

       // System.out.println("head = " + s_list.head.value);
       // System.out.println("tail = " + s_list.tail.value);

    }
}
