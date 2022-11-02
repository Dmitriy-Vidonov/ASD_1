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

    // 1. Добавьте в класс LinkedList метод удаления одного узла по его значению.
}