public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz)
    {
        clazz = clz;

        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        if(count == 0)
        {
            array = (T[]) java.lang.reflect.Array.newInstance(this.clazz, new_capacity);
            capacity = new_capacity;
            return;
        }

        T[] tempArray;
        tempArray = (T[]) java.lang.reflect.Array.newInstance(this.clazz, new_capacity);
        System.arraycopy(array, 0, tempArray, 0, count);
        array = tempArray;
        capacity = array.length;
    }

    public T getItem(int index)
    {
        if(index < 0 || index >= array.length)
            throw new IndexOutOfBoundsException("Index out of array bounds!");

        return array[index];
    }

    public void append(T itm)
    {
        if(this.count == this.capacity)
        {
            makeArray(capacity * 2);
            array[this.count] = itm;
            count++;
        } else
        {
            array[this.count] = itm;
            count++;
        }
    }

    public void insert(T itm, int index)
    {
        if (index < 0 || index > array.length)
            throw new IndexOutOfBoundsException("Index out of array bounds!");

        if(count == capacity || index == array.length)
            makeArray(capacity * 2);

        if(array[index] == null)
        {
            array[index] = itm;
            count++;
            return;
        }

        for (int i=index; array[i] != null || i < array.length-1; i++)
        {
            T temp = array[i];
            array[i] = itm;
            itm = temp;
        }
        count++;
    }

    public void remove(int index)
    {
        if(index < 0 || index >= array.length)
            throw new IndexOutOfBoundsException("Index out of array bounds!");

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

        int fullPercentage;
        fullPercentage = (int)count * 100 / capacity;

        if(fullPercentage <= 50)
        {
            int newSize = (int)(capacity / 1.5);
            if(newSize < 16)
                newSize = 16;

            makeArray(newSize);
        }
    }

    // Тестовый метод, перед проверкой удалить!
    public void showArr()
    {
        for (int i = 0; i<array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
