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

    public boolean remove(int _value)
    {
        Node node = this.head;
        Node preNode = node;

        if(this.head == null)
        {
            return false;
        }
        else if (this.head.value == _value)
        {
            this.head = this.head.next;
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
                    preNode.next = node.next;
                    node = null;
                    return true;
                }
            }
        }
        return false;
    }

    public void removeAll(int _value)
    {
        Node node = this.head;
        Node preNode = node;

        while(node != null)
        {
            if (this.head.value == _value && this.head.next != null)
                this.head = this.head.next;

            else if(node.value == _value && this.head.next == null)
            {
                this.head = null;
                break;
            }

            else if(node.value != _value)
            {
                preNode = node;
                node = node.next;
            }
            else
            {
                preNode.next = node.next;
                node = preNode.next;
            }
        }
    }

    public void clear()
    {
        Node preNode = this.head;

        while (this.head != null) {
            preNode = this.head;
            this.head = head.next;
            preNode = null;
        }
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

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        Node node = this.head;
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