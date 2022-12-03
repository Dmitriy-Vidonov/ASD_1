package draft3;

public class HashTable {
    public int size;
    public int step;
    public String [] slots;
    protected int loadCount = 0;

    public HashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
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
        int len = slots.length; // передали в переменную длину массива
        int index = hashFun(value); // вычислить индекс слота хэш-функцией

        if(loadCount == 0) // если в массиве все ячейки пусты, то просто вернем полученный индекс
            return index;

        if(loadCount == len) // если массив полностью заполнен, то вернем неудачу - свободных слотов нет
            return -1;

        // в иных случаях, когда свободные слоты есть
        if(slots[index] == null) // если найденный слот содержит null, то его можно использовать и вернуть его значение
            return index;

        // если на предыдущем шаге мы нашли заполненный слот, то надо идти по массиву и искать свободные слоты
        int res = -1;

        for(int i=0; i<len; i++)
        {
            index += step;

            if(index > len-1)
                index-=len;

            if(slots[index] == null)
            {
                res = index;
                break;
            }
        }
        // находит индекс пустого слота для значения, или -1
        return res;
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
        return -1;
    }

    public int find(String value)
    {
        int res = -1;
        int len = slots.length;
        int index = hashFun(value);

        for(int i=0; i<len; i++)
        {
            index += step;

            if(index > len-1)
                index-=len;

            if(slots[index] == value)
            {
                res = index;
                break;
            }
        }
        // находит индекс слота со значением, или -1
        return res;
    }

    public void ShowTable()
    {
        for (int i=0; i<slots.length; i++)
            System.out.print(slots[i] + " ");
        System.out.println();
    }

}
