package Testing;
import java.util.*;

public class LinkedList {
    public Node head; // Переменная head типа Node
    public Node tail; // Переменная tail типа Node

    public LinkedList() // Конструктор класса LinkedList
    {   // Задаем значения по умолчанию
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null) // Если поле head в текущем объекте item равен null
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
        // Здесь будет ваш код поиска всех узлов
        return nodes;
    }

    public boolean remove(int _value)
    {
        // Здесь будет ваш код удаления одного узла по заданному значению
        return true; // Если узел был удален
    }

    public void removeAll(int _value)
    {
        // Здесь будет ваш код удаления всех узлов по заданному значению
    }

    public void clear()
    {
        // Здесь будет ваш код очистки всего списка
    }

    public int count()
    {
        return 0; // Здесь будет ваш код подсчета количества элементов в списке
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        // Здесь будет ваш код вставки узла после заданного

        // Если _nodeAfter = null,
        // добавьте новый элемент первым в списке
    }
}

class Node { // Класс "узел"
    public int value; // Значение в узле
    public Node next; // Следующий узел
    public Node (int _value) // Конструктор класса Node - задаем первичные значения
    {
        value = _value;
        next = null;
    }
}