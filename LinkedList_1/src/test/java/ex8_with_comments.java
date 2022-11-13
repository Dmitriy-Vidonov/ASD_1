public class ex8_with_comments {
    public static void ShowNodesValues(LinkedList LL)
    {
        if (LL.head == null && LL.tail == null)
        {
            System.out.println("LinkedList is empty");
            return;
        }

        if (LL.head == null && LL.tail != null)
        {
            System.out.println("LinkedList is broken:");
            System.out.println("head = " + LL.head);
            System.out.println("tail = " + LL.tail);
        }

        Node node = LL.head;
        while (node != null)
        {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static LinkedList ListsMerge(LinkedList list_1, LinkedList list_2)
    {
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

    public static void main(String[] args) {
        LinkedList list_1 = new LinkedList();
        LinkedList list_2 = new LinkedList();

        list_1.addInTail(new Node(15));
        list_1.addInTail(new Node(20));
        list_1.addInTail(new Node(50));

        list_2.addInTail(new Node(115));
        list_2.addInTail(new Node(120));
        list_2.addInTail(new Node(150));


        LinkedList result_list = ex8.ListsMerge(list_1, list_2);
        ShowNodesValues(result_list);


    }
}
