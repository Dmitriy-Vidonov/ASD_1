import java.util.ArrayList;

public class MethodsForTesting {

    // random LinkedList generation in given range of numbers
    public static LinkedList LLGenerate(int min, int max, int listLength) {
        LinkedList genLL = new LinkedList();
        for (int i = 0; i < listLength; i++) {
            genLL.addInTail(new Node((int) (Math.random() * (max - min)) + min));
        }
        return genLL;
    }

    // get values from our list after findAll method into ArrayList
    public static ArrayList myListOfValues(LinkedList LL, int val)
    { // сравнить потом длины и значения в полученном массиве из нашего списка и из стандартного списка
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

    public static void main(String[] args) {
        LinkedList empty_list = new LinkedList();
        empty_list.addInTail(new Node(15));
        empty_list.addInTail(new Node(18));
        empty_list.addInTail(new Node(20));
        empty_list.addInTail(new Node(18));
        empty_list.addInTail(new Node(55));

        System.out.println("Список после добавления элементов: "); empty_list.checkAll(); System.out.println();

        // our linked list
        LinkedList my_LL = new LinkedList();
        my_LL.addInTail(new Node(10));
        my_LL.addInTail(new Node(15));
        my_LL.addInTail(new Node(55));
        my_LL.addInTail(new Node(15));

        // java Linked List
        java.util.LinkedList<Integer> java_LL = new java.util.LinkedList<>();
        java_LL.add(10);
        java_LL.add(15);
        java_LL.add(55);
        java_LL.add(15);

        int val = 15;

        System.out.println(listsComparison(my_LL, java_LL, val));
    }
}
