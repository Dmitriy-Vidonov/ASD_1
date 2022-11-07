package fixedtailsversion;

import java.util.ArrayList;

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

   // Compare values of two ArrayList<Node>
    public static boolean twoArrListsValuesCompare(ArrayList<Node> arrList1, ArrayList<Node> arrList2) {
        boolean res = true;

        if(arrList1.size() == arrList2.size()) {
            for (int i=0; i<arrList1.size(); i++)
            {
                if(arrList1.get(i).value != arrList2.get(i).value)
                    res = false;
                    break;
            }
        }
        else
            res = false;

        return res;
    }
}
