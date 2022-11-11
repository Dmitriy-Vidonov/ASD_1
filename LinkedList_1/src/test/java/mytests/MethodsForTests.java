package mytests;

public class MethodsForTests {
    // make copy from default package LinkedList into java LinkedList
    public static java.util.LinkedList LinkedListCopy(LinkedList LL)
    {
        java.util.LinkedList<Integer> java_LL = new java.util.LinkedList<>();
        Node node = LL.head;
        while (node != null)
        {
            java_LL.add(node.value);
            node = node.next;
        }
        return java_LL;
    }

    public void showAll(LinkedList LL){
        if (LL.head != null)
        {
            Node node = LL.head;
            while(node != null){
                System.out.print(node.value + " ");
                node = node.next;
            }
            System.out.println();
        }
        else if (LL.head == null && LL.tail == null)
            System.out.println("null list");
        else {
            System.out.println("something wrong:");
            System.out.println("head of null list: " + LL.head);
            System.out.println("tail of null list: " + LL.tail);
        }
    }

    // Show us if LinkedList in really empty (head and tail == null)
    public static boolean isListNull(LinkedList LL)
    {
        return  (LL.head == null && LL.tail == null);
    }

    // Show us all values from nodes of given LinkedList
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

}
