package MyTests;
import java.util.*;

public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() // Конструктор класса LinkedList
    {   // Задаем значения по умолчанию
        head = null;
        tail = null;
    }

    // Добавим элемент в конец списка
    public void add_in_tail(Node item) {
        // через this указываем, что head - это head нашего основного класса - LinkedList
        if (this.head == null) // поле head принадлежит списку и если элементов нет, то оно пустое
            this.head = item; // Если список не заполнен, то добавляем в начало узел item
        else // Если элементы в списке уже были
            tail.next = item; // В поле next объекта tail (тип Node - узел) - заносим текущий узел
        // т.е. в указатель на следующий элемент массива помещается текущий узел
        tail = item; // в поле tail класса LinkedList помещаем текущий элемент - список
        tail.next = null; // у текущего узла указатель next будет равен null, т.к. узел мы добавили в конец списка
    }

    // Перебор всех элементов списка
    public void checkAll() {
        Node node = head; // создали некий узел, в который поместили head-овый элемент нашего списка
        while (node != null) { // до тех пор, пока наш узел не станет null - проходим по списку
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    // Найти элемент списка по его индексу - простой вариант, без проверок по длине и ограничения по верхней границе
    public Node Get(int i) {
        Node node = head;
        for (int k = 0; k < i; k++)
            node = node.next;
        return node;
    }

    // Найти нужный узел по заданному value
    public Node findByValue(int val) {
        Node node = this.head;
        while (node != null) {
            if (node.value == val)
                return node;
            node = node.next;
        }
        return null;
    }

    // 1. Добавьте в класс LinkedList метод удаления одного узла по его значению. ОК
    public boolean Remove(int _value)
    {
        Node node = this.head;
        Node preNode = node;
        // Что если список пустой?
        if(this.head == null)
        {
            return false;
        }
        else
        {
            while(node != null)
            {
                if (this.head.value == _value)
                    this.head = this.head.next;

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
        return false; // если узел был удалён
    }

    // 3. Добавьте в класс LinkedList метод очистки всего содержимого (создание пустого списка).
    public void clear()
    {
        Node preNode = this.head;

        while (this.head != null) {
            preNode = this.head;
            this.head = head.next;
            preNode = null;
        }
    }

    // 4. Добавьте в класс LinkedList метод поиска всех узлов по конкретному значению
    // (возвращается список/массив найденных узлов).
    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head; // Установили ноду в начало
        while(node != null) // проход всех элементов списка
        {
            if(node.value == _value)
            {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    //5. Добавьте в класс LinkedList метод вычисления длины списка.
    public int count()
    {
        Node node = this.head; // устанавливаем узел в начало списка
        int count = 0;
        if(this.head == null) // если список пустой
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

    /*
    6. Добавьте в класс LinkedList метод вставки нового узла после заданного узла.
    Например, имеется список (a1,a2,a3,a4,a5) и новый узел a7;
    вставляя узел a7 после узла a3, получаем список (a1,a2,a3,a7,a4,a5).
    */
    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
     Node node = this.head;
     // Если изначально список пустой
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
        // здесь будет ваш код вставки узла после заданного

        // если _nodeAfter = null ,
        // добавьте новый элемент первым в списке
    }
}