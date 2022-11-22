package twostackqueue;
import java.util.*;

public class TwoStackQueue <T>
{
    private Stack stack1;
    private Stack stack2;

    public TwoStackQueue()
    {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(T item)
    {
        stack1.push(item);
    }

    public T dequeue()
    {
        T element = null;

        if(stack1.size() == 0 && stack2.size() == 0)
            return element;

        if(stack2.size() == 0) // Копирование запускаем, если второй стек пуст
        {
            while (stack1.size() > 0)
                stack2.push(stack1.pop()); // Элемент из хвоста первого стека добавляем во второй
        }
        element = (T) stack2.pop();

        return element;
    }

    public int size()
    {
        return stack1.size() + stack2.size();
    }

    public void Show()
    {
        int index = 0;
        System.out.print("stack1: ");
        while (index < stack1.size())
        {
            System.out.print(stack1.get(index) + " ");
            index++;
        }
        System.out.println();

        index = 0;
        System.out.print("stack2: ");
        while (index < stack2.size())
        {
            System.out.print(stack2.get(index) + " ");
            index++;
        }
        System.out.println();
    }

}
