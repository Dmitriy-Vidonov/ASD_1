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

        testStack.pop();
        testStack.pop();
        testStack.pop();

        testStack.Show();
        System.out.println("size of stack = " + testStack.size());

        System.out.println(testStack.pop());

        java.util.Stack classicStack = new java.util.Stack<>();
        classicStack.push(1);
        classicStack.push("five");
        classicStack.push(15.6);

        System.out.println("pop = " + classicStack.pop());
        System.out.println("pop = " + classicStack.pop());


        System.out.println(classicStack.pop().equals(1));
    }
}
