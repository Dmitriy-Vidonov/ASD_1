
public class DynArrayTest {
    public static void main(String[] args)
    {
        DynArray<Integer> arrTest = new DynArray<Integer>(Integer.class);

     /*   arrTest.append(10);
        arrTest.append(20);
        arrTest.append(30);
        arrTest.append(40);
        arrTest.append(50);
        arrTest.append(60);
        arrTest.append(70);
        arrTest.append(80);
        arrTest.append(90);
        arrTest.append(100);
        arrTest.append(110);
        arrTest.append(120);
        arrTest.append(130);
        arrTest.append(140);
        arrTest.append(150);
        arrTest.append(160);*/

        for(int i=1; i<=50; i++)
            arrTest.append(i);

        for (int i=0; i<17; i++)
            arrTest.remove(arrTest.count-1);

        arrTest.remove(arrTest.count-1);
        arrTest.remove(arrTest.count-1);
        arrTest.remove(arrTest.count);

        arrTest.showArr();
        System.out.println("count = " + arrTest.count);
        System.out.println("capacity = " + arrTest.capacity);
    }
}
