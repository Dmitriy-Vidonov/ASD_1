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
        if (head == null) // поле head принадлежит списку и если элементов нет, то оно пустое
            head = item; // Если список не заполнен, то добавляем в начало узел item
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
}