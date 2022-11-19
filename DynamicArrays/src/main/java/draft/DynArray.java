package draft;

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
        makeArray(3);
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
        array = (T[]) java.lang.reflect.Array.newInstance(this.clazz, new_capacity); // Создание нового массива с емкостью new_cap
    }

    public void append(T itm)
    {
        if(this.count == capacity) // если число занятых ячеек равно емкости массива
        {
            //increaseArraySize(); // вызов метода для увеличения массива
        }
        array[this.count] = itm;
        count++;

        // пока что тестово смоделируем ситуацию, что нам нужно копировать данные в новый массив при count = 4
        // на рост массива
        if(count == 3)
        {
            T[] tempArray;
            tempArray = (T[]) java.lang.reflect.Array.newInstance(this.clazz, 10);
            System.arraycopy(array, 0, tempArray, 0, array.length);
            array = tempArray;
        }
    }

    // Отображение всех элементов массива
    public void showArr()
    {
        for (int i = 0; i<array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public void remove(int index)
    {
        // Генерация исключения при неверном индексе
        if(index < 0 || index >= array.length)
            throw new IndexOutOfBoundsException("Выход за пределы массива");

        // Отсутствие дальнейших вычислений при попытке удалить пустое значение
        if(array[index] == null)
            return;

        array[index] = null;
        count--;

        while (array[index+1] != null)
        {
            array[index] = array[index+1];
            array[index+1] = null;
            index++;
        }
    }

}
