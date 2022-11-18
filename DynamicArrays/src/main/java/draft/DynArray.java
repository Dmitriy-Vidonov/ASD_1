package draft;
import java.lang.reflect.*;

public class DynArray <T> // <T> - это то, что класс юзает дженерики
{
    public T [] array; // массив фикс. длины
    public int count; // текущее кол-во элементов в массиве
    public int capacity; // текущая емкость буфера
    Class clazz; // clazz - переменная объекта Class

    public DynArray(Class clz) // конструктор нашего класса DynArray
    {
        clazz = clz; // нужен для безопасного приведения типов - когда один тип автоматом преобразуется в другой
        // например new DynArray<Integer>(Integer.class);
        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        /*
        *  java.lang.reflect.Array.newInstance(Class<?> componentType, int length)
        *  method forms a new array with the component type and length as specified in the arguments
        *  https://www.tutorialspoint.com/create-integer-array-with-array-newinstance-in-java
        *
        *  java.lang.reflect.Array - статические методы для динамического создания массивов Java
        *
        *  Вот пример создания массива
        * https://www.delftstack.com/ru/howto/java/java-dynamic-array/
        *
        * public static Object newInstance(Class<?> componentType, int length)
        *  throws IllegalArgumentException, NegativeArraySizeException
        * */
        array = (T[]) Array.newInstance(this.clazz, new_capacity);

    }

}
