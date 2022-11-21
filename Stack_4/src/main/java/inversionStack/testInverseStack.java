package inversionStack;

public class testInverseStack {
    public static void main(String[] args)
    {
        InverseStack testStack = new InverseStack<>();

        testStack.push(10);
        testStack.push(20);
        testStack.push(30);

        testStack.Show();
        System.out.println("size = " + testStack.size());
        System.out.println("peek = " + testStack.peek());
    }
}
