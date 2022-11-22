package draft;

public class QueueTest
{
    public static void rotate (Queue queue, int count)
    {
        for(int i=0; i<count; i++)
        {
            queue.enqueue(queue.dequeue());
        }
    }

    public static void main(String[] args)
    {
        Queue testQueue = new Queue();

        testQueue.enqueue(1);
        testQueue.enqueue(2);
        testQueue.enqueue(3);
        testQueue.enqueue(4);

        testQueue.Show();

        System.out.println("size = " + testQueue.size());

        System.out.println(testQueue.dequeue());
        System.out.println(testQueue.dequeue());
        System.out.println(testQueue.dequeue());
        System.out.println(testQueue.dequeue());

       // rotate(testQueue, 3);

        testQueue.Show();
    }
}
