package draft;

public class HashTable
{
    public int size; // Размер таблицы. Лучше простое число (делится только на 1 и само себя). Напр. 17 или 19
    public int step; // Длина шага, кол-во слотов для поиска след. свободного слота. Например, 3.
    public String [] slots; // Массив для хранения элементов таблицы. Можно сразу сделать его фиксированным.

    protected int loadCount = 0;

    public HashTable(int sz, int stp) // Конструктор нашего класса
    {
        size = sz; // Передаем в создаваемый объект размер таблицы
        step = stp; // Задаем шаг, который будем использовать для проходки по таблице
        slots = new String[size]; // Создаем массив для хранения данных
        for(int i=0; i<size; i++) slots[i] = null; // "Зануляем" все элементы массива
    }

    public int hashFun(String value)
    {
        int hash;
        hash = Math.abs(value.hashCode());
        String hashStr = Integer.toString(hash);
        hash = Math.abs(hashStr.hashCode());

        hash %= slots.length;

        return hash;
    }

    public int seekSlot(String value)
    {
        // находит индекс пустого слота для значения, или -1
        int len = slots.length;

        // находит индекс пустого слота для значения, или -1
        int index = hashFun(value);

        if(loadCount == len)
            return -1;

        if(slots[index] == null)
            return index;

        int count = index;

        while (slots[count] != null && loadCount < len) // пока в списке есть свободные места, load_count < len
        {
            if((count + step) > (len-1))
            {
                count = ((count + step) - len);
                continue;
            }
            count+=1;
        }
        return count;
    }

    public int put(String value)
    {
        int index = seekSlot(value);

        if(index != -1)
        {
            slots[index] = value;
            loadCount += 1;
            return index;
        }
        // записываем значение по хэш-функции

        // возвращается индекс слота или -1
        // если из-за коллизий элемент не удаётся разместить
        return -1;
    }

    public int find(String value)
    {
        int len = slots.length;
        int index = hashFun(value);

        if(slots[index].equals(value))
            return index;

        int counter = 0;

        while ((!slots[index].equals(value)) && (counter < len)) // пока в списке есть свободные места, load_count < len
        {
            if((index + step) > (len-1))
            {
                index = ((index + step) - len);
                continue;
            }
            index++;
            counter++;
        }

        if(!slots[index].equals(value))
            return -1;

        return index;
        // находит индекс слота со значением, или -1
    }
}
