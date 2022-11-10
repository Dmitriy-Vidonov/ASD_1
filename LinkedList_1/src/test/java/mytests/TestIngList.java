package mytests;

import java.util.ArrayList;

public class TestIngList {
    public static void main(String[] args) {
        Node n1 = new Node(1); // инициализировали первый узел
        Node n2 = new Node(2); // инициализировали второй узел
        n1.next = n2; // в указатель первого узла занесли второй узел
        Node n3 = new Node(1);
        Node n4 = new Node(3);
        Node n5 = new Node(1);
        Node n6 = new Node(1);
        Node n7 = new Node(12);
        Node _nodeToInsert = new Node(15);

        LinkedList s_list = new LinkedList(); // инициализировали новый список
        s_list.addInTail(n1); // в конец списка добавили первый узел, указанный ранее
        s_list.addInTail(n2); // в конец списка добавили второй узел, указанный ранее
        s_list.addInTail(n3);
        s_list.addInTail(n4);
        s_list.addInTail(n5);
       // s_list.addInTail(n6);
      //  s_list.addInTail(n7);

        s_list.showAll();
        //System.out.println("remove status = " + s_list.remove(1));
        s_list.removeAll(1);
        s_list.showAll();

        System.out.println("head = " + s_list.head.value);
        System.out.println("tail = " + s_list.tail.value);

    }
}
