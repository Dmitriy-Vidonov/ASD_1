package draft;
import java.util.*;

class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private boolean _ascending; // asc - по возрастанию. true - значит по возрастанию. false - по убыванию

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
        // Проверяем, является ли значение числовым
        // Для целочисленных значений
        if(((v1.getClass().getTypeName().endsWith("Integer")) &&
                (v2.getClass().getTypeName().endsWith("Integer"))
        ) && ((int)v1 < (int)v2)
        ) return -1;  // -1 если v1 < v2

        if(((v1.getClass().getTypeName().endsWith("Integer")) &&
                (v2.getClass().getTypeName().endsWith("Integer"))
        ) && ((int)v1 == (int)v2)
        ) return 0; // 0 если v1 == v2

        if(((v1.getClass().getTypeName().endsWith("Integer")) &&
                (v2.getClass().getTypeName().endsWith("Integer"))
        ) && ((int)v1 > (int)v2)
        ) return 1; // +1 если v1 > v2


        // Для чисел с плавающей точкой
        if(((v1.getClass().getTypeName().endsWith("Float") || v1.getClass().getTypeName().endsWith("Double")) &&
                (v2.getClass().getTypeName().endsWith("Float") || v2.getClass().getTypeName().endsWith("Double"))
        ) && ((double)v1 < (double)v2)
        ) return -1;  // -1 если v1 < v2

        if(((v1.getClass().getTypeName().endsWith("Float") || v1.getClass().getTypeName().endsWith("Double")) &&
                (v2.getClass().getTypeName().endsWith("Float") || v2.getClass().getTypeName().endsWith("Double"))
        ) && ((double)v1 == (double)v2)
        ) return 0; // 0 если v1 == v2

        if(((v1.getClass().getTypeName().endsWith("Float") || v1.getClass().getTypeName().endsWith("Double")) &&
                (v2.getClass().getTypeName().endsWith("Float") || v2.getClass().getTypeName().endsWith("Double"))
        ) && ((double)v1 > (double)v2)
        ) return 1; // +1 если v1 > v2

        // Если у нас строки
        if(v1.getClass().getTypeName().endsWith("String") && v2.getClass().getTypeName().endsWith("String"))
        {
            String s1 = "";
            String s2 = "";
            s1 = (String) v1;
            s2 = (String) v2;
            // Очистка строк от начальных и конечных пробелов
            s1 = s1.trim();
            s2 = s2.trim();

            return s1.compareTo(s2);
        }

        return 0;
    }

    public void add(T value)
    {
        // автоматическая вставка value
        // в нужную позицию
    }

    public Node<T> find(T val)
    {
        return null; // здесь будет ваш код
    }

    public void delete(T val)
    {
        // здесь будет ваш код
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        // здесь будет ваш код
    }

    public int count()
    {
        return 0; // здесь будет ваш код подсчёта количества элементов в списке
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного
    // списка в виде стандартного списка
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}
