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

    // findAll is OK
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
    public void removeAll(int _value)
    {
        Node pre = null;
        // if list is empty
        if (this.head == null) {
            return;
        }
        // if list has only one node with target value
        else if(this.head.value == _value && head.next == null) {
            this.head = null;
            return;
        }

        else
        {
            pre = this.head;
            while (pre.next != null)
            {
                if(this.head.value == _value)
                { // if target value at the beginning of list - shift head
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
        if(this.head.value == _value) {
            this.head = null;
            this.tail = null;
            pre = null;
        }
    }

    // clear() is OK
    public void clear()
    {
        while (this.head != null)
            this.head = head.next;
    }

    // count() is OK
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
