package tests;

import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
    {
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
    // find is OK (tested)
    public Node find(int _value)
    {
        if(this.head == null){
            return null;
        }
        else {
            Node node = this.head;
            while (node != null) {
                if (node.value == _value)
                    return node;
                node = node.next;
            }
        }
        return null;
    }
    // findAll is OK (tested)
    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();

        if(this.head == null){
            return nodes;
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

    // remove is OK (tested)
    public boolean remove(int _value)
    {
        if (this.head == null)
            return false;

        if (this.head.value == _value && this.head.next != null) {
            this.head.next.prev = null;
            this.head = this.head.next;
            return true;
        }
        else if (this.head.value == _value && this.head.next == null) {
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
        // Если значение оказалось в tail
        if (node.value == _value) {
            tail = node.prev;
            tail.next = null;
            node.prev = null;
            return true;
        }
        return false;
    }

    // removeAll is OK (tested)
    public void removeAll(int _value)
    {
        // Если список пустой
        if (this.head == null)
        {
            return;
        }

        Node node = this.head;
        while (node.next != null)
        {
            // Если значение в head - его надо передвинуть
            if (this.head.value == _value)
            {
                this.head.next.prev = null;
                this.head = this.head.next;
            }
            // Если значение не в head - то стандартная операция
            else if (node.value == _value)
            {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            // В любом случае мы переходим на следующий узел
            node = node.next;
        }
        // ниже - код для работы с tail-ами разных вариаций
        // Если перед tail ничего нет, то есть мы в head
        if (this.head.value == _value)
        {
            this.head = null;
            this.tail = null;
        }
        // если мы в tail и перед ним есть элементы
        else if (node.value == _value)
        {
            this.tail = node.prev;
            this.tail.next = null;
        }
    }

    // clear() is OK (tested)
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
        }
    }

    // count is OK (tested)
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
        // либо список пуст и вставляем первый элемент в null
        if (_nodeAfter == null && this.head == null)
        {
            this.head = _nodeToInsert;
            this.tail = _nodeToInsert;
            //return;
        }
        // либо список не пуст и вставляем перед ним первым элементом
        else if (_nodeAfter == null && this.head != null)
        {
            _nodeToInsert.next = this.head;
            this.head.prev = _nodeToInsert;
            this.head = _nodeToInsert;
            this.head.prev = null;
            //return;
        }

        else if (_nodeAfter == this.tail && this.tail.prev != null)
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
