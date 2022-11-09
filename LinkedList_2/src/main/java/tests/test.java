package tests;

public class test {
    public static void main(String[] args) {
        LinkedList2 s_list2 = new LinkedList2();
        s_list2.addInTail(new Node(15));
       // s_list2.addInTail(new Node(20));
       // s_list2.addInTail(new Node(35));

        System.out.println(s_list2.find(15).value);
    }
}
