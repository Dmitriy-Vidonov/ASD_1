package draft;

public class DynArraySimpleTest {
    public static void main(String[] args)
    {
        DynArraySimple dynamicArrayTest = new DynArraySimple();

        dynamicArrayTest.addElementToArray(10);
        dynamicArrayTest.addElementToArray(20);
        dynamicArrayTest.addElementToArray(30);
        dynamicArrayTest.addElementToArray(40);
        dynamicArrayTest.addElementToArray(50);

        System.out.println("Items of array:");

        for (int i=0; i< dynamicArrayTest.capacity; i++)
            System.out.print(dynamicArrayTest.intArray[i] + " ");

        System.out.println();

        System.out.println("Capacity of the intArray: " + dynamicArrayTest.capacity);
        System.out.println("Size of the intArray: " + dynamicArrayTest.size);

        dynamicArrayTest.removeElement();

        System.out.println("\nItems after removing the last element");

        for (int i = 0; i < dynamicArrayTest.capacity; i++) {
            System.out.print(dynamicArrayTest.intArray[i] + " ");
        }

        System.out.println("\nCapacity of the intArray: " + dynamicArrayTest.capacity);
        System.out.println("Size of the intArray: " + dynamicArrayTest.size);

        dynamicArrayTest.shrinkSize();

        System.out.println("\nItems after removing unused space");

        for (int i = 0; i < dynamicArrayTest.capacity; i++) {
            System.out.print(dynamicArrayTest.intArray[i] + " ");
        }

        System.out.println("\nCapacity of the intArray: " + dynamicArrayTest.capacity);
        System.out.println("Size of the intArray: " + dynamicArrayTest.size);
    }
}
