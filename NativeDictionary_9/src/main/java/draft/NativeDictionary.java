package draft;
import java.lang.reflect.Array;

public class NativeDictionary<T> {
    public int size; // задаем размер словаря
    public String [] slots; // массив для хранения ключей
    public T [] values; // массив для хранения значений
    Class clazz;

    public NativeDictionary(int sz, Class clz) // Class clazz нужен для корректного приведения типов
    {
        clazz = clz;
        size = sz; // передаем размер словаря новому обьекту
        slots = new String[size]; // создаем новый массив типа String
        for(int i=0; i<size; i++) slots[i] = null; // заполнили null-ами массив с ключами
        values = (T[]) Array.newInstance(this.clazz, size); // создаем новый массив с дженерик-типами
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
        // String.valueOf вместо ==
        if(String.valueOf(slots[index]) == key) // если в ячейке сразу нашли нужный ключ, то завершаем метод с true
            return true;

        for(int i=0; i<len+1; i++) // если изначально ключ не нашли, идем перебором по другим ячейкам
        {
            index += 1;

            if(index > len-1)
                index-=len;
            // String.valueOf вместо ==
            if(String.valueOf(slots[index]) == key)
                return true;
        }
        // возвращает true если ключ имеется,
        // иначе false
        return false;
    }

    public void put(String key, T value)
    {
        int index = hashFun(key); // получили индекс ключа хэш-функцией
        int len = slots.length;

        if(slots[index] == null) // если индекс ведет на null-слот, то пишем в него ключ
        {
            slots[index] = key;
            values[index] = value;
            return;
        }

        // если index привел не в пустую ячейку
        // проверить, равен ли ключ тому, что мы хотим использовать
        // == заменил на .equals
        if(slots[index] == key) // если тот же ключ, то делаем перезапись value
        {
            values[index] = value;
            return;
        }
        // если же ключ отличен, то стоит искать другой слот
        for(int i=0; i<len; i++) // если изначально ключ не нашли, идем перебором по другим ячейкам
        {
            index += 1;

            if(index > len-1)
            {
                index-=len;
            }
            // == заменил на .equals
            if(slots[index] == key)
            {
                values[index] = value;
                break;
            }

            if(slots[index] == null)
            {
                slots[index] = key;
                values[index] = value;
                return;
            }
        }
        // гарантированно записываем
        // значение value по ключу key
    }

    public T get(String key)
    {
        int len = slots.length;
        int index = hashFun(key);
        // == заменил на .equals
        if(slots[index] == key) // если в ячейке сразу нашли нужный ключ, то завершаем метод с true
        {
            return values[index]; // возвращаем значение из values
        }

        for(int i=0; i<len; i++) // если изначально ключ не нашли, идем перебором по другим ячейкам
        {
            index += 1;

            if(index > len-1)
                index-=len;
            // == заменил на .equals
            if(slots[index] == key)
                return values[index];
        }
        // возвращает value для key,
        // или null если ключ не найден
        return null;
    }

    // тестовый вывод элементов
    public void ShowTable()
    {
        for (int i=0; i<slots.length; i++)
            System.out.print(slots[i] + " : " + values[i] + ", ");
        System.out.println();
    }
}
