public class NativeCache <T>
{
    public int size;
    public String [] slots;
    public T [] values;
    public int [] hits;
    public int counter;
    Class clazz;

    public NativeCache(int sz, Class clz)
    {
        clazz = clz;
        size = sz;
        slots = new String[size];
        hits = new int[size];
        for(int i=0; i<size; i++)
        {
            slots[i] = null;
            hits[i] = 0;
        }
        values = (T[]) java.lang.reflect.Array.newInstance(this.clazz, size);
        counter = 0;
    }

    public int hashFun(String key)
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

    public void put(String key, T value) // Add new element in cache hashTable
    {
        int index = hashFun(key);
        int len = slots.length;

        if(counter == size) // If hashTable is full, we call clearSlot() method
            clearSlot(indexForClearing()); // Finding slot with min hit and null it

        if(slots[index] == null) // If find null slot then add new value
        {
            slots[index] = key;
            values[index] = value;
            counter++;
            return;
        }

        if(slots[index] == key) // If get the same key, then update it's value
        {
            values[index] = value;
            return;
        }

        for(int i=0; i<len; i++) // Collision solving
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

    public int indexForClearing() // Finding index with minimal hit value
    {
        int minIndex = this.hits[0];
        for(int i=0; i<this.size; i++)
        {
            if(hits[i] < minIndex)
                minIndex = i;
        }
        return minIndex;
    }

    public void clearSlot(int minIndex) // Clearing slot with hits[minIndex]
    {
        slots[minIndex] = null;
        values[minIndex] = null;
        hits[minIndex] = 0;
        counter--;
    }

    public void hit(String key) // Performing one hit if key exists
    {
        int index = getIndex(key);

        if(index != -1)
            hits[index]++;
    }

    public int getIndex(String key) // Get index by key (-1 otherwise)
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
}
