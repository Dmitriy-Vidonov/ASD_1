package twostackqueue;

public class TwoStackQueueTest {
    public static void main(String[] args)
    {
        TwoStackQueue queueTest = new TwoStackQueue<>();

        queueTest.enqueue(1);
        queueTest.enqueue(2);
        queueTest.enqueue(3);

        queueTest.Show();
        System.out.println("size = " + queueTest.size());

        System.out.println("dequeue - " + queueTest.dequeue());
        System.out.println("dequeue - " + queueTest.dequeue());
        System.out.println("dequeue - " + queueTest.dequeue());
        System.out.println("dequeue - " + queueTest.dequeue());

        queueTest.Show();
        System.out.println("size = " + queueTest.size());

        System.out.println("enqueue - " + 3); queueTest.enqueue(3);

        queueTest.Show();
        System.out.println("size = " + queueTest.size());

        System.out.println("dequeue - " + queueTest.dequeue());

        queueTest.Show();
        System.out.println("size = " + queueTest.size());
    }
}
