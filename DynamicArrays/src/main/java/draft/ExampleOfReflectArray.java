package draft;
import java.lang.reflect.Array;

// https://www.tutorialspoint.com/create-array-with-array-newinstance-with-java-reflection
public class ExampleOfReflectArray {
    public static void main(String[] args)
    {
        String[] arr = (String[]) Array.newInstance(String.class, 3); // Создаем новый массив
        Array.set(arr, 0, "First"); // Заносим элементы в массив
        Array.set(arr, 1, "Second");
        Array.set(arr, 2, "Third");

        System.out.println("Element 1 = " + Array.get(arr, 0));
        System.out.println("Element 2 = " + Array.get(arr, 1));
        System.out.println("Element 3 = " + Array.get(arr, 2));
    }

}
