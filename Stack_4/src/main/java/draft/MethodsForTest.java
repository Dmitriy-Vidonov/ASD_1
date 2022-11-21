package draft;

public class MethodsForTest {
    public static Stack genStack(int size)
    {
        Stack stack = new Stack<>();
        for(int i=0; i<size; i++)
        {
            stack.push(i);
        }
        return stack;
    }

    public static void main(String[] args)
    {
        Stack arrTest = genStack(100000);
        arrTest.Show();
        System.out.println("size = " + arrTest.size());
    }
}
