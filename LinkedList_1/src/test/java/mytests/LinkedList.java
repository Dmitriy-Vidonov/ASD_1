package mytests;
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
        if(this.head == null){
            return null;
        }
        else {
            Node node = this.head;
            while (node != null) {
                if (node.value == value)
                    return node;
                node = node.next;
            }
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        if(this.head == null){
            return null;
        }
        else {
            Node node = this.head;
            while(node != null)
            {
                if(node.value == _value)
                {
                    nodes.add(node);
                }
                node = node.next;
            }
        }
        return nodes;
    }

    // remove
    public boolean remove(int _value) {
        // Если список изначально пустой
        if (this.head == null)
            return false;

        // Если head.value == _value
        if (this.head.value == _value
                && this.head.next != null)
        { // Если узел на удаление в начале, но список не из 1 узла
            Node node = this.head;
            this.head = this.head.next;
            node = null;
            return true;
        }
        if (this.head.value == _value
                && this.head.next == null) // Если узел на удаление в начале и список из 1 узла
        {
            head = null;
            tail = null;
            return true;
        }
        else {
            Node node = this.head.next;
            Node prev = this.head;

            while (node != null) { // пока не дойдем до последнего узла, который обработаем отдельно
                if(node.value == _value && node.next != null) { // пока мы не в конце списка (node.next != null)
                    prev.next = node.next;
                    node = node.next;
                    return true;
                }
                else if(node.value == _value && node.next == null) { // если tail.value == _value
                    tail = prev;
                    tail.next = null;
                    return true;
                }
                node = node.next;
                prev = prev.next;
            }
        }
        return false;
    }

    public void removeAll(int _value)
    {
        if (this.head == null) {
            return;
        }
        else if(this.head.value == _value && head.next == null) {
            this.head = null;
            return;
        }

        else
        {
            Node pre = this.head;
            while (pre.next != null)
            {
                if(this.head.value == _value)
                {
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
        }
    }

    public void clear()
    {
        if(this.head != null) {
            Node node = this.head;

            while (node != null)
            {
                this.head.next = null;
                head = node;
                node = node.next;
            }

            head = null;
            tail = null;
            node = null;
        }

        else
            return;

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
        if (_nodeAfter == this.tail)
        {
            this.tail = _nodeToInsert;
        }
        if (this.head == null)
        {
            this.head = _nodeToInsert;
            _nodeToInsert.next = null;
        }
        if (_nodeAfter == null)
        {
            _nodeToInsert.next = head;
            head = _nodeToInsert;
        }
        else
        {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
        }
    }

    // show all nodes from list
    public void showAll(){
        if (this.head != null)
        {
            Node node = this.head;
            while(node != null){
                System.out.print(node.value + " ");
                node = node.next;
            }
            System.out.println();
        }
        else System.out.println("null list");
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
