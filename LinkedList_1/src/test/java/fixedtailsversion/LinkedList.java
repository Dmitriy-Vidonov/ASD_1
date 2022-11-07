package fixedtailsversion;

import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while(node != null)
        {
            if(node.value == _value)
            {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    // remove method is OK
    public boolean remove(int _value)
    {
        if(this.head == null){
            return false;
        }

        Node node = this.head;
        Node preNode = node;

        if (this.head.value == _value
                && this.head.next != null)
        {
            this.head = this.head.next;
            return true;
        }
        else if (this.head.value == _value
                && this.head.next == null)
        {
            this.head = null;
            this.tail = null;
            return true;
        }
        else
        {
            while(node != null)
            {
                if(node.value != _value)
                {
                    preNode = node;
                    node = node.next;
                }
                else
                {
                    if (node.next != null)
                    {
                        preNode.next = node.next;
                        return true;
                    }
                    else {
                        preNode.next = null;
                        tail = preNode;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // removeAll is OK
   /* public void removeAll(int _value)
    {
        Node node = this.head;
        Node preNode = node;

        while(node != null)
        {
            if (this.head.value == _value && this.head.next != null) {
                this.head = this.head.next;
                node = this.head;
            }

            else if(node.value == _value && this.head.next == null)
            {
                this.head = null;
                this.tail = null;
                break;
            }

            else if (node.value == _value && node.next != null) {
                node = node.next;
            }

            else
            {
                preNode.next = node.next;
                node = preNode.next;
               // tail = preNode;
            }
        }
    } */
    public void removeAll(int _value)
    {

    }

    public void remove2(int _value) {
        Node pre = null;
        // частный случай, когда список пустой
        if (this.head == null) {
            return;
        }
        // частный случай когда всего 1 узел в списке
        else if(this.head.value == _value && head.next == null) {
            this.head = null;
        }

        else
        {
            pre = this.head;
            while (pre.next != null)
            {
                if(this.head.value == _value)
                { // если значение попалось в начале, сдвигаем head
                        this.head = this.head.next;
                        pre = this.head;
                }

                else if(pre.next.value == _value) {
                    Node del = pre.next;
                    Node aft = del.next;
                    pre.next = aft;
                }
                else {
                    pre = pre.next;
                }
                tail = pre;
            }
        }
    }

    // clear() is OK
    public void clear()
    {
        while (this.head != null)
            this.head = head.next;
    }

    public int count()
    {
        Node node = this.head;
        int count = 0;
        if(this.head == null)
        {
            return 0;
        }
        else
        {
            while(node != null)
            {
                count++;
                node = node.next;
            }
        }
        return count;
    }

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
    // insert after is ok
    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == this.tail)
        {
            this.tail = _nodeToInsert;
        }
        if (this.head == null)
        {
            this.head = _nodeToInsert;
            _nodeToInsert.next = null;
        }
        else
        {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
        }
    }

    public static void main(String[] args){
        LinkedList s_list = new LinkedList ();
        s_list.addInTail(new Node(2));
        //  s_list.addInTail(new Node(4));
        //for (int i=0; i<5; i++)
        //  s_list.addInTail(new Node(3));
        //  s_list.addInTail(new Node(4));
        // s_list.addInTail(new Node(5));
        //s_list.addInTail(new Node(4));

        showAll(s_list);
        s_list.removeAll(2);
        // System.out.println("Remove status = "
        // + s_list.remove(4));
        // System.out.println("head = "
        // + s_list.head.value);
        //  System.out.println("tail = "
        //  + s_list.tail.value);
        //  s_list.clear();
        showAll(s_list);
    }
}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}
