package WorkingExample;

public class DynArraySimple {
    int[] intArray; // массив
    int size; // число занятых ячеек
    int capacity; // емкость массива

    public DynArraySimple() // конструктор класса
    {
        intArray = new int[16]; // создание минимального массива в 16 объектов
        size = 0; // из них занято - 0 ячеек
        capacity = 16; // емкость созданного массива - 16 элементов
    }

    public void addElementToArray(int a) // добавление элемента в массив
    {
        if(size == capacity) // если число занятых ячеек равно емкости массива
        {
            increaseArraySize(); // вызов метода для увеличения массива
        }
        intArray[size] = a;
        size++;
    }

    public void increaseArraySize() {
        int[] tempArray = null;
        if (size == capacity) {
            tempArray = new int[capacity * 2]; // создаем временный массив вдвое больше исходного
            {
                if (capacity >= 0) {
                    System.arraycopy(intArray, 0, tempArray, 0, capacity); // копирование массива
                }
            }
        }
        intArray = tempArray;
        capacity = capacity * 2;
    }

    public void shrinkSize() // уменьшение размера массива
    {
        int[] temp;
        if(size > 0)
        {
            temp = new int[size];
            System.arraycopy(intArray, 0, temp, 0, size);
            capacity = size;
            intArray = temp;
        }
    }

    public void removeElement()
    {
        if(size > 0)
        {
            intArray[size - 1] = 0;
            size--;
        }
    }
}
