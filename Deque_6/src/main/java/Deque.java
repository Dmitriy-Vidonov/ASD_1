import java.util.*;

public class Deque<T>
{
    private LinkedList<T> deqList;

    public Deque()
    {
        deqList = new LinkedList<T>();
    }

    public void addFront(T item)
    {
        deqList.addFirst(item);
    }

    public void addTail(T item)
    {
        deqList.addLast(item);
    }

    public T removeFront()
    {
        if(deqList.size() == 0)
            return null;

        T head = deqList.getFirst();

        deqList.removeFirst();
        return head;
    }

    public T removeTail()
    {
        if(deqList.size() == 0)
            return null;

        T tail = deqList.getLast();

        deqList.removeLast();
        return tail;
    }

    public int size()
    {
        return deqList.size();
    }
}