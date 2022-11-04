
public class ex8 {
    public static void main(String[] args) {
        LinkedList list_1 = new LinkedList();
        LinkedList list_2 = new LinkedList();
        LinkedList result_list = new LinkedList();

        list_1.addInTail(new Node(15));
        list_1.addInTail(new Node(20));
        list_1.addInTail(new Node(50));

        list_2.addInTail(new Node(115));
        list_2.addInTail(new Node(120));
        list_2.addInTail(new Node(150));

        Node node_list_1 = list_1.head;
        Node node_list_2 = list_2.head;

            while (node_list_1 != null)
            {
                if(list_1.count() == list_2.count() && result_list.head == null)
                {
                    result_list.addInTail(new Node(node_list_1.value + node_list_2.value));
                    node_list_1 = node_list_1.next;
                    node_list_2 = node_list_2.next;
                }
                else if (list_1.count() == list_2.count() && result_list.head != null)
                {
                    result_list.addInTail(new Node(node_list_1.value + node_list_2.value));
                    node_list_1 = node_list_1.next;
                    node_list_2 = node_list_2.next;
                }
            }

        Node node = result_list.head; // создали некий узел, в который поместили head-овый элемент нашего списка
        while (node != null) { // до тех пор, пока наш узел не станет null - проходим по списку
            System.out.print(node.value + " ");
            node = node.next;
        }

    }
}
