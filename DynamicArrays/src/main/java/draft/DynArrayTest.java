package draft;

import java.lang.reflect.Array;

public class DynArrayTest {
    public static void main(String[] args)
    {
        DynArray<Integer> testArr = new DynArray<Integer>(Integer.class);
        testArr.append(10);
        testArr.append(20);
        testArr.append(30);
        testArr.showArr();
        System.out.println("count = " + testArr.count);

        testArr.remove(9);

        testArr.showArr();
        System.out.println("count = " + testArr.count);
    }
}
