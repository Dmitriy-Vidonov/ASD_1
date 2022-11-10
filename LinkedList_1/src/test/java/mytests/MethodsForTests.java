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
}
