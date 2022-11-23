package draft;

public class deqTest {
    public static void main(String[] args)
    {
        Deque deque = new Deque<>();

        deque.addFront(1);
        deque.addFront(2);
        deque.addFront(3);

        deque.addTail(1);
        deque.addTail(2);
        deque.addTail(3);

        deque.Show();
        System.out.println("size = " + deque.size());

        deque.removeFront();
        deque.removeTail();

        deque.Show();
        System.out.println("size = " + deque.size());

        deque.removeFront();
        deque.removeTail();
        deque.removeFront();
        deque.removeTail();

        deque.Show();
        System.out.println("size = " + deque.size());

        System.out.println("removeFront - " + deque.removeFront());
        System.out.println("removeTail - " + deque.removeTail());

        deque.addFront(3);
        deque.addTail(1);

        deque.Show();
        System.out.println("size = " + deque.size());
    }
}

/*
2. Как можно понизить (выровнять) сложность addHead/removeHead и addTail/removeTail,
 с помощью какого ранее изученного типа данных?

  - при помощи связного списка мы легко можем оперировать с головой и хвостом без
  необходимости сдвига всех других элементов в ту или иную сторону
*/

