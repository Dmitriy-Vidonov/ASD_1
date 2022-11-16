package tests.dummy;

public class testLL3 {
    public static void main(String[] args)
    {
        LinkedList3 list3 = new LinkedList3();

        list3.addInTail(new Node(1));
        list3.addInTail(new Node(2));
        list3.addInTail(new Node(3));
        list3.addInTail(new Node(2));
        list3.addInTail(new Node(3));

        list3.showList();

        list3.removeAll(2);
        list3.remove(3);
        list3.remove(1);
        list3.remove(3);
        list3.remove(34);

        list3.showList();



    }
}
