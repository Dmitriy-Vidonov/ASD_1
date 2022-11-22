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
        if(stack.size() == 0)
            return null;

        T element = stack.getLast();

        stack.removeLast();
        return element;
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
}