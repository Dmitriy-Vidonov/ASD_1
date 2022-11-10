import java.util.*;

public class testForLinkedList {
    public static void main(String[] args) {
        Node n1 = new Node(1); // инициализировали первый узел
        Node n2 = new Node(1); // инициализировали второй узел
      //  n1.next = n2; // в указатель первого узла занесли второй узел
        Node n3 = new Node(2);
        Node n4 = new Node(3);
        Node n5 = new Node(5);
        Node n6 = new Node(129);
        Node n7 = new Node(123);
        Node _nodeToInsert = new Node(1);

        LinkedList s_list = new LinkedList(); // инициализировали новый список
        s_list.addInTail(n1); // в конец списка добавили первый узел, указанный ранее
        s_list.addInTail(n2); // в конец списка добавили второй узел, указанный ранее
        s_list.addInTail(n3);
        s_list.addInTail(n4);
        s_list.addInTail(n5);
       // s_list.addInTail(n6);
       // s_list.addInTail(n7);

        s_list.showAll(s_list);
        s_list.removeAll(1);
        //System.out.println("remove status - " + s_list.remove(12));
        s_list.showAll(s_list);

        System.out.println("head = " + s_list.head.value);
        System.out.println("tail = " + s_list.tail.value);
    }
}
