import java.util.*;

public class MethodsForTesting {

    // random LinkedList generation in given range of numbers
    public static LinkedList LLGenerate(int min, int max, int listLength) {
        LinkedList genLL = new LinkedList();
        for (int i = 0; i < listLength; i++) {
            genLL.addInTail(new Node((int) (Math.random() * (max - min)) + min));
        }
        return genLL;
    }

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

    // get values from our list after findAll method into ArrayList
    public static ArrayList myListOfValues(LinkedList LL, int val)
    {
        ArrayList<Integer> arrList = new ArrayList<>();
        int size = LL.findAll(val).size();

        for(int i=0; i<size; i++)
            arrList.add(LL.findAll(val).get(i).value); // get value from given node from LL after findAll() method
        return arrList;
    }

    // get ArrayList from java.util.LinkedList with given value
    public static ArrayList notMyListOfValues(java.util.LinkedList LL, int val)
    {
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int i=0; i<LL.size(); i++)
        {
            if((int)LL.get(i) == val)
            {
                arrList.add((int)LL.get(i));
            }
        }
        return arrList;
    }

    // compare myListOfValues results with notMyListOfValues
    public static boolean listsComparison(LinkedList my_LL, java.util.LinkedList java_LL, int val)
    {
        return ((myListOfValues(my_LL, val).size() == notMyListOfValues(java_LL, val).size()));
    }

    /*
    // show all nodes from list
    public static void showAll(LinkedList LL){
        if (LL.head != null)
        {
            Node node = LL.head;
            while(node != null){
                System.out.print(node.value + " ");
                node = node.next;
            }
            System.out.println();
        }
        else System.out.println("null list");
    }
    * */
}
