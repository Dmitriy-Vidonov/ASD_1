import java.util.*;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
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

    public Node find(int _value) {
        if (this.head == null) {
            return null;
        } else {
            Node node = this.head;
            while (node != null) {
                if (node.value == _value)
                    return node;
                node = node.next;
            }
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        if (this.head == null) {
            return nodes;
        } else {
            Node node = this.head;
            while (node != null) {
                if (node.value == _value) {
                    nodes.add(node);
                }
                node = node.next;
            }
        }
        return nodes;
    }

    public boolean remove(int _value) {
        if (this.head == null)
            return false;

        if (this.head.value == _value && this.head.next != null) {
            this.head.next.prev = null;
            this.head = this.head.next;
            this.head.prev = null;
            return true;
        } else if (this.head.value == _value && this.head.next == null) {
            this.head = null;
            this.tail = null;
            return true;
        }

        Node node = this.head;
        while (node.next != null) {
            if (node.value == _value) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                return true;
            }
            node = node.next;
        }
        if (node.value == _value) {
            tail = node.prev;
            tail.next = null;
            node.prev = null;
            return true;
        }
        return false;
    }

    public void removeAll(int _value) {
        if (this.head == null) {
            return;
        }

        Node node = this.head;
        while (node.next != null) {
            if (this.head.value == _value) {
                this.head.next.prev = null;
                this.head = this.head.next;
            } else if (node.value == _value) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node = node.next;
        }
        if (this.head.value == _value) {
            this.head = null;
            this.tail = null;
        } else if (node.value == _value) {
            this.tail = node.prev;
            this.tail.next = null;
        }
    }

    public void clear() {
        if (this.head != null) {
            Node node = this.head;

            while (node != null) {
                this.head.next = null;
                head = node;
                node = node.next;
            }
            head = null;
            tail = null;
        }
    }

    public int count() {
        Node node = this.head;
        int count = 0;
        if (this.head == null) {
            return 0;
        } else {
            while (node != null) {
                count++;
                node = node.next;
            }
        }
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {

        if (_nodeAfter == null && this.head == null)
        {
            this.head = _nodeToInsert;
            this.tail = _nodeToInsert;
            return;
        }

        if (_nodeAfter == null && this.head != null)
        {
            _nodeToInsert.next = this.head;
            this.head.prev = _nodeToInsert;
            this.head = _nodeToInsert;
            this.head.prev = null;
            return;
        }

        if (_nodeAfter == this.tail && this.tail.prev != null)
        {
            this.tail.next = _nodeToInsert;
            _nodeToInsert.prev = this.tail;
            this.tail = _nodeToInsert;
        }
        else
        {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next.prev = _nodeToInsert;
            _nodeAfter.next = _nodeToInsert;
            _nodeToInsert.prev = _nodeAfter;
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