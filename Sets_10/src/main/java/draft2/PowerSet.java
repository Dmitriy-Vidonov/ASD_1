package draft2;

import java.util.ArrayList;
import java.util.List;

public class PowerSet
{
    public int capacity;
    public int step;
    public String [] slots;
    protected java.util.List<Integer> indexes; // Массив для хранения индексов элементов

    public PowerSet()
    {
        capacity = 10;
        step = 1;
        slots = new String[capacity];
        indexes = new ArrayList<Integer>();
        for(String slot : slots) slot = null;
        // ваша реализация хранилища
    }

    public int size()
    {
        return indexes.size();
    }

    public void put(String value)
    {
        int index = seekSlot(value);

        if(index != -1 && this.get(value) == false)
        {
            slots[index] = value;
            indexes.add(index);
        }
        //return;
        // всегда срабатывает
    }

    public boolean get(String value)
    {
        // возвращает true если value имеется в множестве,
        // иначе false
        boolean res = false;

        int len = slots.length;
        int index = hashFun(value);

        if(slots[index] == value)
            return true;

        for(int i=0; i<len; i++)
        {
            index += step;

            if(index > len-1)
                index-=len;

            if(slots[index] == value)
            {
                return true;
            }
        }
        return res;
    }

    public boolean remove(String value)
    {
        int findIndex = find(value);

        if(findIndex != -1)
        {
            slots[findIndex] = null;
            return true;
        }
        // возвращает true если value удалено
        // иначе false
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        PowerSet pwrSet = new PowerSet();

        for(int i=0; i<indexes.size(); i++) { // Проходим по массиву с индексами
            if(set2.get(this.slots[indexes.get(i)]))  // Если элемент по индексу из основного множества есть во втором, то:
                pwrSet.put(this.slots[indexes.get(i)]); // Кладем его в pwrSet
        }

        return pwrSet;
        // пересечение текущего множества и set2
    }

    public PowerSet union(PowerSet set2)
    {
        PowerSet pwrSet = new PowerSet();

        int mainSize = this.size();
        int secondSize = set2.size();

        if(mainSize == 0 && secondSize == 0)
        {
            return pwrSet;
        }

        if(mainSize == 0 && secondSize != 0)
        {
            return set2;
        }

        if(mainSize >= secondSize)
        {
            this.clone(pwrSet);

            for(int i=0; i<set2.indexes.size(); i++) {
                if(!this.get(set2.slots[set2.indexes.get(i)]))
                    pwrSet.put(set2.slots[set2.indexes.get(i)]);
            }

            return pwrSet;
        }

        for(int i=0; i<this.indexes.size(); i++) {
            if(!set2.get(this.slots[this.indexes.get(i)]))
                pwrSet.put(this.slots[this.indexes.get(i)]);
        }

        return pwrSet;
        // объединение текущего множества и set2
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet pwrSet = new PowerSet();

        for(int i=0; i<this.indexes.size(); i++) {
            if(!set2.get(this.slots[this.indexes.get(i)]))
                pwrSet.put(this.slots[this.indexes.get(i)]);
        }

        return pwrSet;
        // разница текущего множества и set2
    }

    public boolean isSubset(PowerSet set2)
    {
        int counter = 0;

        for(int i=0; i<set2.indexes.size(); i++) {
            if(this.get(set2.slots[set2.indexes.get(i)]))
                counter++;
        }

        return (set2.size() == counter);

        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
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
        int loadCount = indexes.size();

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

   /* public int add(String value)
    {
        int index = seekSlot(value);
        if(index != -1 && value != slots[index])
        {
            slots[index] = value;
            loadCount += 1;
            return index;
        }
        return -1;
    }*/

    public int find(String value)
    {
        int res = -1;
        int len = slots.length;
        int index = hashFun(value);

        if(slots[index] == value)
            return index;

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

    public void clone(PowerSet set2)
    {
        for(int i=0; i<this.indexes.size(); i++)
            set2.put(this.slots[this.indexes.get(i)]);
    }

    public void ShowTable()
    {
        for (int i=0; i<slots.length; i++)
            System.out.print(slots[i] + " ");
        System.out.println();
        System.out.println("indexes:");

        for (int i=0; i<indexes.size(); i++)
            System.out.print(indexes.get(i) + " ");
        System.out.println();
    }

}
