package draft;

public class QueueTest {
    public static void main(String[] args)
    {
        Queue testQueue = new Queue();

        testQueue.enqueue(1);
        testQueue.enqueue(2);
        testQueue.enqueue(3);

        testQueue.Show();

        System.out.println("size = " + testQueue.size());

        System.out.println("from head = " + testQueue.dequeue());
        System.out.println("from head = " + testQueue.dequeue());
        System.out.println("from head = " + testQueue.dequeue());
        System.out.println("from head = " + testQueue.dequeue());

        testQueue.Show();
        System.out.println("size = " + testQueue.size());
    }
}
