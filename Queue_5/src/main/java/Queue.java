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
}
