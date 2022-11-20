package draft;
import java.util.*;

public class Stack<T>
{
    public LinkedList<T> stack;

    public Stack()
    {
        stack = new LinkedList<T>();
    }

    public int size()
    {
        return stack.size();
    }

    public T pop()
    {
        T Object = stack.getLast();

        if(stack.size() == 0)
            return null;

        stack.removeLast();
        return Object;
    }

    public void push(T val)
    {
        stack.add(val);
    }

    public T peek()
    {
        if(stack.size() > 0)
            return(stack.getLast());
        return null;
    }

    public void Show()
    {
        int index = 0;
        while (index < stack.size())
        {
            System.out.print(stack.get(index) + " ");
            index++;
        }
        System.out.println();
    }
}