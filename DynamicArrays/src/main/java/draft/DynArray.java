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
        array = (T[]) java.lang.reflect.Array.newInstance(this.clazz, new_capacity); // Создание нового массива с емкостью new_cap
        capacity = new_capacity;
    }

    // Добавление элемента в конец массива
    public void append(T itm)
    {
        // если число занятых ячеек равно емкости массива
        if(this.count == this.capacity)
        {
            // Рост происходит в 2 раза
            T[] tempArray;
            tempArray = (T[]) java.lang.reflect.Array.newInstance(this.clazz, capacity * 2);
            System.arraycopy(array, 0, tempArray, 0, array.length);
            array = tempArray;
            capacity = array.length;

            array[this.count] = itm;
            count++;
        } else
        {
            array[this.count] = itm;
            count++;
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

        while (index < array.length-1 && array[index+1] != null)
        {
            array[index] = array[index+1];
            array[index+1] = null;
            index++;
        }

        // Проверка заполненности массива после удаления элемента
        int fullPercentage;
        fullPercentage = (int)count * 100 / capacity;
        System.out.println("percentage after remove = " + fullPercentage);

        if(fullPercentage <= 50) // Если после удаления % заполненности массива строго меньше 50%
        { // Уменьшаем массив
            // Если новый размер массива < 16, то присвоить 16 (мин значение)
            // для теста сделаем меньше - 10 вместо 16
            int newSize = (int)(capacity / 1.5);
            if(newSize < 16)
                newSize = 16;

            T[] tempArray;
            tempArray = (T[]) java.lang.reflect.Array.newInstance(this.clazz, newSize);
            System.arraycopy(array, 0, tempArray, 0, count); // В новый массив - только ячейки с данными
            array = tempArray;
            capacity = array.length;
        }
    }

    // Получение объекта по его индексу
    // Здесь встроить проверку корректности индекса в рамках границ и генерацию исключений
    public T getItem(int index)
    {
        if(index < 0 || index >= array.length)
            throw new IndexOutOfBoundsException("Выход за границы массива!");

        return array[index];
    }

    public void insert(T itm, int index)
    {
        if (index == array.length)
        {
            array[(array.length - 1)] = itm;
            return;
        }

        // Проверяем диапазон индекса
        if (index < 0 || index > array.length)
            throw new IndexOutOfBoundsException("Выход за границы массива!");

        if(array[index] == null)
        {
            array[index] = itm;
            count++;
            return;
        }

        if(count == capacity)
        {
            // Рост происходит в 2 раза
            T[] tempArray;
            tempArray = (T[]) java.lang.reflect.Array.newInstance(this.clazz, capacity * 2);
            System.arraycopy(array, 0, tempArray, 0, array.length);
            array = tempArray;
            capacity = array.length;
        }

        for (int i=index; array[i] != null || i < array.length-1; i++)
        {
            T temp = array[i];
            array[i] = itm;
            itm = temp;
        }
        count++;
    }


}
