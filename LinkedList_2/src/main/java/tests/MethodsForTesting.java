package tests;

public class MethodsForTesting {

    public static void ShowNodesValues(LinkedList2 LL)
    {
        if (LL.head == null && LL.tail == null)
        {
            System.out.println("LinkedList is empty");
            return;
        }

        if ((LL.head == null && LL.tail != null) | (LL.head != null && LL.tail == null))
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

        public static int counter(LinkedList2 LL)
        {
            int count = 0;
            if(LL.head == null)
                return 0;
            else
            {
                Node node = LL.head;
                while(node != null)
                {
                    count++;
                    node = node.next;
                }
            }
            return count;
        }

        //
        public static boolean ListsEqualByNodes(LinkedList2 list1, LinkedList2 list2)
        {
            int count1 = counter(list1);
            int count2 = counter(list2);

            if(!(((count1 == 0) | (count2 == 0)) | count1 != count2))
            {
                Node node1 = list1.head;
                Node node2 = list2.head;

                for (int i = 0; i < count1; i++)
                {
                    if (node1.value != node2.value)
                        return false;

                    node1 = node1.next;
                    node2 = node2.next;
                }
                return true;
            }
            else if (count1 == 0 && count2 == 0)
            {
                return true;
            }
            return false;
        }

    public static void main(String[] args)
    {
    }
}
