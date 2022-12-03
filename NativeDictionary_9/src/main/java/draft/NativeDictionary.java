package draft;
import java.lang.reflect.Array;

public class NativeDictionary<T> {
    public int size; // задаем размер словаря
    public String [] slots; // массив для хранения ключей
    public T [] values; // массив для хранения значений
    protected int loadCount = 0; // переменная для хранения числа заполненных элементов

    public NativeDictionary(int sz, Class clazz) // Class clazz нужен для корректного приведения типов
    {
        size = sz; // передаем размер словаря новому обьекту
        slots = new String[size]; // создаем новый массив типа String
        for(int i=0; i<size; i++) slots[i] = null; // заполнили null-ами массив с ключами
        values = (T[]) Array.newInstance(clazz, this.size); // создаем новый массив с дженерик-типами
    }

    public int hashFun(String key) // на основе key, ключа - считаем хэш и формируем индекс для массива
    {
        int hash;
        hash = Math.abs(key.hashCode());
        String hashStr = Integer.toString(hash);
        hash = Math.abs(hashStr.hashCode());

        hash %= slots.length;

        return hash;
    }

    public boolean isKey(String key) // проверка - имеется ли в слотах указанный ключ
    {
        int len = slots.length;
        int index = hashFun(key);

        if(slots[index] == key) // если в ячейке сразу нашли нужный ключ, то завершаем метод с true
            return true;

        for(int i=0; i<len; i++) // если изначально ключ не нашли, идем перебором по другим ячейкам
        {
            index += 1;

            if(index > len-1)
                index-=len;

            if(slots[index] == key)
                return true;
        }
        // возвращает true если ключ имеется,
        // иначе false
        return false;
    }

    public void put(String key, T value)
    {
        int index = seekSlot(key);

        if(index != -1)
        {
            slots[index] = key;
            values[index] = value;
            loadCount++;
        }
        // гарантированно записываем
        // значение value по ключу key
    }

    public T get(String key)
    {
        int len = slots.length;
        int index = hashFun(key);

        if(slots[index] == key) // если в ячейке сразу нашли нужный ключ, то завершаем метод с true
        {
            return values[index]; // возвращаем значение из values
        }

        for(int i=0; i<len; i++) // если изначально ключ не нашли, идем перебором по другим ячейкам
        {
            index += 1;

            if(index > len-1)
                index-=len;

            if(slots[index] == key)
                return values[index];
        }

        // возвращает value для key,
        // или null если ключ не найден
        return null;
    }

    public int seekSlot(String key)
    {
        int len = slots.length;
        int index = hashFun(key);

        if(loadCount == 0)
            return index;

        if(loadCount == len)
            return -1;

        if(slots[index] == null)
            return index;

        int res = -1;

        for(int i=0; i<len; i++)
        {
            index += 1;

            if(index > len-1)
                index-=len;

            if(slots[index] == null)
            {
                res = index;
                break;
            }
        }
        return res;
    }
    
}
