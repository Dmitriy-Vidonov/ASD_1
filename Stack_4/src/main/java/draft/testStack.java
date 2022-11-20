package draft;

public class testStack {
    public static void main(String[] args)
    {
        Stack testStack = new Stack<>();

        testStack.push(10);
        testStack.push(20);
        testStack.push("one");

        testStack.Show();
        System.out.println("size = " + testStack.size());

        //System.out.println("pop = " + testStack.pop());
        //System.out.println("pop = " + testStack.pop());
        //System.out.println("pop = " + testStack.pop());

        testStack.Show();
        System.out.println("size = " + testStack.size());

        System.out.println(testStack.peek());
    }
}
