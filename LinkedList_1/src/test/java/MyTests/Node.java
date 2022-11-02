package MyTests;
import java.util.*;

public class Node {
    public int value; // Данное
    public Node next; // Указатель на следующий узел типа Node

    public Node(int _value) {
        value = _value; // Передаем значение из конструктора в переменную value
        next = null; // Изначально nex == null, что говорит о конце списка
    }
}
