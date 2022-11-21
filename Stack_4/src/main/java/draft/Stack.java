package draft;
import java.util.*;

public class Stack<T>
{
    public LinkedList<T> stack;

    public Stack()
    {
        stack = new LinkedList<T>();
    }

    // tested
    public int size()
    {
        return stack.size();
    }

    // tested
    public T pop()
    {
        if(stack.size() == 0)
            return null;

        T element = stack.getLast();

        stack.removeLast();
        return element;
    }

    // tested
    public void push(T val)
    {
        stack.add(val);
    }

    // tested
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

// Мера сложности для pop() и push()
// для операции getlast() мера сложности O(1)