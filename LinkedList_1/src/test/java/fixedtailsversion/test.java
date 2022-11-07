package fixedtailsversion;
import static fixedtailsversion.LinkedList.*;

public class test {
    public static void main(String[] args){
        LinkedList s_list = new LinkedList ();
        // s_list.addInTail(new Node(1));
        // s_list.addInTail(new Node(4));
        //  s_list.addInTail(new Node(4));
       // s_list.addInTail(new Node(4));
       // s_list.addInTail(new Node(5));
       //    for (int i=0; i<3; i++)
       //       s_list.addInTail(new Node(2));

       //  s_list.addInTail(new Node(5));
       // s_list.addInTail(new Node(1));

         showAll(s_list);
        // s_list.removeAll(1);
       //  s_list.removeAll(2);
        s_list.clear();
       //  System.out.println("Remove status = " + s_list.remove(1));
         showAll(s_list);

       //System.out.println("head = " + s_list.head.value);
       //  System.out.println("tail = " + s_list.tail.value);
        //  s_list.clear();

    }
}
