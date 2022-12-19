package draft;

public class NativeCache<T>
{
    public int size; // Размер кэша
    public String [] slots; // Массив с ключами словаря
    public T [] values; // Массив со значениями словаря
    public int [] hits; // Массив с числом обращений к элементам
    public int counter; // Счетчик заполненных элементов
    Class clazz;

    public NativeCache(int sz, Class clz) // Конструктор класса NativeCache
    {
        clazz = clz;
        size = sz;
        slots = new String[size];
        hits = new int[size];
        for(int i=0; i<size; i++)
        {
            slots[i] = null; // Заполняем null-ами массив slots
            hits[i] = 0; // Заполняем нулями массив hits
        }
        values = (T[]) java.lang.reflect.Array.newInstance(this.clazz, size); // Создаем массив значений
        counter = 0;
    }

    public int hashFun(String key) // хэш-функция для работы хэш-таблицы
    {
        long res = 0;
        int rand = 17;
        long len = key.length();

        for(int i=0; i<len; i++)
        {
            if (i == 0) continue;
            int code = key.charAt(i);
            res += (res * rand) + code;
        }
        return ((res > 0) ? (int)(res % size) : -(int)(res % size));
    }

    public void put(String key, T value) // Добавление элемента
    {
        int index = hashFun(key); // Получили индекс по ключу
        int len = slots.length;

        if(counter == size) // Если массив заполнен - вызываем метод поиска эл-та под обнуление
            clearSlot(indexForClearing()); // Ищем слот с минимальным hit и обнуляем его

        if(slots[index] == null) // Если по индексу слот пустой - просто добавляем новое значение
        {
            slots[index] = key;
            values[index] = value;
            counter++;
            return;
        }

        if(slots[index] == key) // Если такой ключ уже есть, то просто обновляем значение по ключу
        {
            values[index] = value;
            return;
        }

        for(int i=0; i<len; i++) // Если мы хотим добавить значение в уже заполненный слот - обработка коллизии
        {
            index += 1;

            if(index > len-1)
            {
                index-=len;
            }

            if(slots[index] == key)
            {
                values[index] = value;
                break;
            }

            if(slots[index] == null)
            {
                slots[index] = key;
                values[index] = value;
                counter++;
                return;
            }
        }
    }

    public int indexForClearing() // Определение индекса с минимальным значением в hits
    {
        int minIndex = this.hits[0];
        for(int i=0; i<this.size; i++)
        {
            if(hits[i] < minIndex)
                minIndex = i;
        }
        return minIndex;
    }

    public void clearSlot(int minIndex) // Очистка слота по индексу в hits
    {
        slots[minIndex] = null;
        values[minIndex] = null;
        hits[minIndex] = 0;
        counter--;
    }

    public void hit(String key) // Обращение к элементу по ключу
    {
        // вызов метода, который получает индекс по ключу
        // с полученным индексом обновить счетчик
        int index = getIndex(key);

        if(index != -1)
            hits[index]++;
    }

    public int getIndex(String key) // Получаем индекс по ключу, -1 - если не найдено
    {
        int len = slots.length;
        int index = hashFun(key);

        if(slots[index] == key)
        {
            return index;
        }

        for(int i=0; i<len; i++)
        {
            index += 1;

            if(index > len-1)
                index-=len;

            if(slots[index] == key)
                return index;
        }
        return -1;
    }

    // Тестовый метод для вывода содержимого кэша
    public void ShowCache()
    {
        // Вывод массива ключей
        for(String slot : slots) System.out.print(slot + " ");
        System.out.println();

        // Вывод массива значений
        for(T value : values) System.out.print(value + " ");
        System.out.println();

        // Вывод массива hits
        for(int hit : hits) System.out.print(hit + " ");
        System.out.println();
    }
}
