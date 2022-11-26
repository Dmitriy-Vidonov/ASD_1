package draft;

public class tests<T> {

    public static void ShowNodesValues(OrderedList LL, boolean full)
    {
        if (LL.head == null && LL.tail == null)
        {
            System.out.println("OrderedList is empty");
            return;
        }

        if ((LL.head == null && LL.tail != null) | (LL.head != null && LL.tail == null))
        {
            System.out.println("OrderedList is broken:");
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

        if(full == true)
        {
            System.out.println("head = " + LL.head);
            System.out.println("head value = " + LL.head.value);
            System.out.println("head next = " + LL.head.next);
            System.out.println("head prev = " + LL.head.prev);
            System.out.println("tail = " + LL.tail);
            System.out.println("tail value = " + LL.tail.value);
            System.out.println("tail next = " + LL.tail.next);
            System.out.println("tail prev = " + LL.tail.prev);
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        OrderedList orderList = new OrderedList<>(false); // true - возрастание, false - убывание
        orderList.add(1);
        orderList.add(3);
        orderList.add(3);
        orderList.add(5);
        orderList.add(4);
        orderList.add(2);

        orderList.delete(3);
        orderList.delete(3);
        ShowNodesValues(orderList, true);

    }
}