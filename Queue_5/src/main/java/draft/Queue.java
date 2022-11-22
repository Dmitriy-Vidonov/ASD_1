package draft;
import java.util.*;

public class Queue<T>
{
    public LinkedList<T> QueueList;

    public Queue()
    {
        QueueList = new LinkedList<T>();
    }

    public void enqueue(T item)
    {
        QueueList.add(item);
    }

    public T dequeue()
    {
        if(QueueList.size() == 0)
            return null;

        T element = QueueList.getFirst();

        QueueList.removeFirst();
        return element;
    }

    public int size()
    {
        return QueueList.size();
    }

    public void Show()
    {
        int index = 0;
        while (index < QueueList.size())
        {
            System.out.print(QueueList.get(index) + " ");
            index++;
        }
        System.out.println();
    }
}

// Оценить меру сложности для enqueue() и dequeue()
// enqueue() = add item in tail in LinkedList, thus it's big O notation is O(1)
// dequeue() = remove item from head in LinkedList, thus it's big O notation is O(1)