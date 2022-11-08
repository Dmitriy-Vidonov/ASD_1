import java.util.*;
public class ex8 {
    public static LinkedList ListsMerge(LinkedList list_1, LinkedList list_2) {
        LinkedList result_list = new LinkedList();

        if (!((list_1.count() != list_2.count()) | (list_1.head == null) | (list_2.head == null)))
        {
            Node node_list_1 = list_1.head;
            Node node_list_2 = list_2.head;

            result_list.addInTail(new Node(list_1.head.value + list_2.head.value));

            node_list_1 = node_list_1.next;
            node_list_2 = node_list_2.next;

            while (node_list_1 != null) {
                result_list.addInTail(new Node(node_list_1.value + node_list_2.value));
                node_list_1 = node_list_1.next;
                node_list_2 = node_list_2.next;
            }
        }
        return result_list;
    }
}
