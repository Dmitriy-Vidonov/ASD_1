package fixedtailsversion;

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

    // LinkedLists comparison
    public static boolean CompareTwoLL(LinkedList list_1, LinkedList list_2) {
            return (LinkedListCopy(list_1).equals(LinkedListCopy(list_2)));
    }

 /*   public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        for(int i=0; i<10; i++) {
            list1.addInTail(new Node(10));
            list2.addInTail(new Node(10));
        }
       // list1.addInTail(new Node(4));

        System.out.println("равны ли списки - " + CompareTwoLL(list1, list2));
    }*/
}
