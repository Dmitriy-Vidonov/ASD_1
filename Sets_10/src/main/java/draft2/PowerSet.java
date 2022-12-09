package draft2;

public class PowerSet
{
    public int capacity;
    public int step;
    public String [] slots;
    protected int loadCount = 0;

    public PowerSet()
    {
        capacity = 20000;
        step = 3;
        slots = new String[capacity];
        for(int i=0; i<capacity; i++) slots[i] = null;
        // ваша реализация хранилища
    }

    public int size()
    {
        return loadCount;
    }


    public void put(String value)
    {
        // всегда срабатывает
    }

    public boolean get(String value)
    {
        // возвращает true если value имеется в множестве,
        // иначе false
        return false;
    }

    public boolean remove(String value)
    {
        // возвращает true если value удалено
        // иначе false
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        // пересечение текущего множества и set2
        return null;
    }

    public PowerSet union(PowerSet set2)
    {
        // объединение текущего множества и set2
        return null;
    }

    public PowerSet difference(PowerSet set2)
    {
        // разница текущего множества и set2
        return null;
    }

    public boolean isSubset(PowerSet set2)
    {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        return false;
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
        int len = slots.length;
        int index = hashFun(value);

        if(loadCount == 0)
            return index;

        if(loadCount == len)
            return -1;

        if(slots[index] == null)
            return index;

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
        return res;
    }

    public int add(String value)
    {
        int index = seekSlot(value);
        if(index != -1 && value != slots[index])
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
        return res;
    }

    public void ShowTable()
    {
        for (int i=0; i<slots.length; i++)
            System.out.print(slots[i] + " ");
        System.out.println();
    }

}
