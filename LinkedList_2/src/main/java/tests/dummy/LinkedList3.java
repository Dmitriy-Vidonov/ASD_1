package tests.dummy;

public class LinkedList3 {
    private static Node head;
    private static Node tail;

    public LinkedList3()
    {
        addInTail();
        addInTail();
    }

    private void addInTail()
    {
        Node _item = new Node(0);
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public void showList()
    {
        Node node = this.head.next;
        while (node.next != null)
        {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void addInTail(Node _item)
    {
        _item.prev = tail.prev;
        tail.prev.next = _item;
        _item.next = tail;
        tail.prev = _item;
    }

    public void removeAll(int _value)
    {
        Node node = this.head.next;
        while (node.next != null)
        {
            if (node.value == _value)
            {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node = node.next;
        }
    }

    public void remove(int _value)
    {
        Node node = this.head.next;
        while (node.next != null)
        {
            if (node.value == _value)
            {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                return;
            }
            node = node.next;
        }
    }
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}
