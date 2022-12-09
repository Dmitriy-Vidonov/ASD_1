package draft2;

public class testSet {
    public static void main(String[] args)
    {
        PowerSet set1 = new PowerSet();

        set1.add("one");
        set1.add("two");
        set1.add("three");
        set1.add("one");

        set1.ShowTable();
    }
}
