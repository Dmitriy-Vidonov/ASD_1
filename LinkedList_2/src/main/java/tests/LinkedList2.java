package tests;

import java.util.ArrayList;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
        if(head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        }
        else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    // find is OK
    public Node find(int _value) {
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

    // findAll is OK
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

    // remove is OK
    public boolean remove(int _value) {
        // Если значение оказалось в head
        if (this.head.value == _value) {
            this.head.next.prev = null;
            this.head = this.head.next;
            return true;
        }
        // Если знечение оказалось не в head и не в tail
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
        return false; // если узел не был удален
    }

    public void removeAll(int _value) {
        // здесь будет ваш код удаления всех узлов по заданному значению
    }

    public void clear() {
        // здесь будет ваш код очистки всего списка
    }

    public int count() {
        return  0; // здесь будет ваш код подсчета всех элементов в списке
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        // здесь будет ваш код вставки узла после заданного узла

        // если _nodeAfter = null
        // добавьте элемент первым в списке
    }

    // show all nodes from list
    public void showAll(LinkedList2 LL){
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
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}
