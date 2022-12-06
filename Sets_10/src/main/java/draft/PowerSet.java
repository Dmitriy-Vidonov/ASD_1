package draft;

public class PowerSet
{
    private int storageSize;
    private java.util.Hashtable<String, String> hashT;
    public PowerSet()
    {
        hashT = new java.util.Hashtable<String, String>(20000);
        // ваша реализация хранилища
    }

    public int size()
    {
        return storageSize;
    }

    public void put(String value)
    {
        if(this.hashT.containsKey(String.valueOf(value)))
            return;

        this.hashT.put(value, value);
        storageSize++;
        // всегда срабатывает
    }

    public boolean get(String value)
    {
        // возвращает true если value имеется в множестве,
        // иначе false
        return (this.hashT.containsKey(value));
    }

    public boolean remove(String value)
    {
        if(this.hashT.remove(value, value) == true)
        {
            storageSize--;
            return true;
        }
        // возвращает true если value удалено
        // иначе false
        return false;
    }

    public void ShowSet(PowerSet pwrSet)
    {
        for (Object key : pwrSet.hashT.keySet() ) {
            System.out.print( key + " " );
        }
    }

    public PowerSet intersection(PowerSet set2)
    {
        PowerSet pwrSet = new PowerSet();

        for (Object key : this.hashT.keySet() ) {
            if(set2.hashT.containsKey(key))
                pwrSet.put(String.valueOf(key));
        }
        // пересечение текущего множества и set2
        return pwrSet;
    }

    public PowerSet union(PowerSet set2)
    {
        int mainSize = this.hashT.size();
        int secondSize = set2.hashT.size();

        // определяем большее множество
        if(mainSize >= secondSize) // если размер основного множества больше, то пробегаем по меньшему и смотрим разницу
        {
            for (Object key : set2.hashT.keySet())
            {
                if(!this.hashT.containsKey(key))
                    this.hashT.put(String.valueOf(key), String.valueOf(key));
            }
            return this;
        }

       // if(mainSize < secondSize)
       // {
            for (Object key : this.hashT.keySet())
            {
                if(!set2.hashT.containsKey(key))
                    set2.hashT.put(String.valueOf(key), String.valueOf(key));
            }
            return set2;
      //  }
        // объединение текущего множества и set2
        //return null;
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet pwrSet = new PowerSet();

        for (Object key : this.hashT.keySet())
        {
            if(!set2.hashT.containsKey(key))
                pwrSet.hashT.put(String.valueOf(key), String.valueOf(key));
        }
        // разница текущего множества и set2
        return pwrSet;
    }

    public boolean isSubset(PowerSet set2)
    {
        int counter = 0;
        for (Object key : set2.hashT.keySet())
        {
            if(this.hashT.containsKey(key))
                counter++;
        }
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        //return (counter == set2.hashT.size());
        return (set2.hashT.size() == counter);
    }
}

