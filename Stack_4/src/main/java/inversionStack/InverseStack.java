package inversionStack;
import java.util.*;

public class InverseStack<T>
{
    public LinkedList<T> stack;

    public InverseStack()
    {
        stack = new LinkedList<T>();
    }

    public int size()
    {
        return stack.size();
    }

    // ok
    public T pop()
    {
        if(stack.size() == 0)
            return null;

        T element = stack.getFirst();

        stack.removeFirst();
        return element;
    }

    // ok
    public void push(T val)
    {
        stack.addFirst(val);
    }

    // ok
    public T peek()
    {
        if(stack.size() > 0)
            return(stack.getFirst());
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