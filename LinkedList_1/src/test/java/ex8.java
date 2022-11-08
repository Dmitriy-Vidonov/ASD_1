import java.util.*;
public class ex8 {
    // Надо внимательно и корректно обработать - работу с head и tail
    // плюс надо проверить корректность при работе с пустыми входными списками
    public static LinkedList ListsMerge(LinkedList list_1, LinkedList list_2) {
        LinkedList result_list = new LinkedList();
        Node node_list_1 = list_1.head;
        Node node_list_2 = list_2.head;

        if (list_1.count() != list_2.count())
        {
            result_list.head = null;
            result_list.tail = null;
        }
        else {
            while (node_list_1 != null) {
                result_list.addInTail(new Node(node_list_1.value + node_list_2.value));
                node_list_1 = node_list_1.next;
                node_list_2 = node_list_2.next;
            }
        }
        return result_list;
    }
}
