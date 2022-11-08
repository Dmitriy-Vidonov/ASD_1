
public class ex8_with_comments {
    public static LinkedList ListsMerge(LinkedList list_1, LinkedList list_2)
    {
        LinkedList result_list = new LinkedList();
        Node node_list_1 = list_1.head;
        Node node_list_2 = list_2.head;

        if (list_1.count() != list_2.count())
            result_list.head = null;
        else
        {
            while (node_list_1 != null)
            {
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
      //  list_1.addInTail(new Node(20));
     //   list_1.addInTail(new Node(50));

        list_2.addInTail(new Node(115));
      //  list_2.addInTail(new Node(120));
      //  list_2.addInTail(new Node(150));


        LinkedList result_list = ex8.ListsMerge(list_1, list_2);
       // if(result_list.head == null) System.out.println("nullll");
        Node node;
        if(result_list.head != null) {
            node = result_list.head;

            while (node != null) {
                System.out.print(node.value + " ");
                node = node.next;
            }
        }
        else
            System.out.println("null list");
    }
}
