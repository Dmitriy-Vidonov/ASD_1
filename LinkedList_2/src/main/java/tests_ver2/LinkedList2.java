package tests_ver2;

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


    public void clear()
    {
        // здесь будет ваш код очистки всего списка
    }

    public int count()
    {
        return 0; // здесь будет ваш код подсчёта количества элементов в списке
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        // здесь будет ваш код вставки узла после заданного узла

        // если _nodeAfter = null
        // добавьте новый элемент первым в списке
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
