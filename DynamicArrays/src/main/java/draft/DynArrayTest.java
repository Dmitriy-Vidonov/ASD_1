package draft;

import java.lang.reflect.Array;

public class DynArrayTest {
    public static void main(String[] args)
    {
        DynArray<Integer> testArr = new DynArray<Integer>(Integer.class);
        testArr.append(1);
        testArr.append(2);
        testArr.append(3);
        testArr.append(4);
        testArr.append(5);
        testArr.append(6);
        testArr.append(7);
        testArr.append(8);
        testArr.append(9);
        testArr.append(10);
        testArr.append(11);
        testArr.append(12);
        testArr.append(13);
        testArr.append(14);
        testArr.append(15);
        testArr.append(16);
       // testArr.append(17);

        testArr.showArr();
        System.out.println("count = " + testArr.count);
        System.out.println("capacity = " + testArr.capacity);

        testArr.remove(1);

        testArr.showArr();
        System.out.println("count = " + testArr.count);
        System.out.println("capacity = " + testArr.capacity);

        for(int i = 0; i<8; i++)
            testArr.remove(i);

        testArr.showArr();
        System.out.println("count = " + testArr.count);
        System.out.println("capacity = " + testArr.capacity);

        System.out.println("элемент по индексу - " + testArr.getItem(1));

        for(int i = 0; i<8; i++)
            testArr.append(88);

        testArr.insert(200, 16);

        testArr.showArr();
        System.out.println("count = " + testArr.count);
        System.out.println("capacity = " + testArr.capacity);

        for(int i = 16; i > 1; i--)
            testArr.remove(i);

        testArr.showArr();
        System.out.println("count = " + testArr.count);
        System.out.println("capacity = " + testArr.capacity);
    }
}
