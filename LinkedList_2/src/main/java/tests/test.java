package tests;

public class test {
    public static void main(String[] args) {
        LinkedList2 s_list2 = new LinkedList2();
        s_list2.addInTail(new Node(1));
        s_list2.addInTail(new Node(3));
        s_list2.addInTail(new Node(3));
        s_list2.addInTail(new Node(2));
        s_list2.addInTail(new Node(3));

        s_list2.showAll(s_list2);

        //System.out.println("статус удаления - " + s_list2.remove(4));
        //s_list2.removeAll(3);
        //s_list2.clear();
        System.out.println(s_list2.count());

        s_list2.showAll(s_list2);
        // System.out.println("head = " + s_list2.head.value);
        // System.out.println("tail = " + s_list2.tail.value);
    }
}
