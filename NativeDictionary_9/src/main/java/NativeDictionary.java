import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key)
    {
        int hash;
        hash = Math.abs(key.hashCode());
        String hashStr = Integer.toString(hash);
        hash = Math.abs(hashStr.hashCode());

        hash %= slots.length;

        return hash;
    }

    public boolean isKey(String key)
    {
        int len = slots.length;
        int index = hashFun(key);

        if(slots[index].equals(key))
            return true;

        for(int i=0; i<len; i++)
        {
            index += 1;

            if(index > len-1)
                index-=len;

            if(slots[index].equals(key))
                return true;
        }
        return false;
    }

    public void put(String key, T value)
    {
        int index = hashFun(key);
        int len = slots.length;

        if(slots[index] == null)
        {
            slots[index] = key;
            values[index] = value;
            return;
        }

        if(slots[index] == key)
        {
            values[index] = value;
            return;
        }

        for(int i=0; i<len; i++)
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
                return;
            }
        }
    }

    public T get(String key)
    {
        int len = slots.length;
        int index = hashFun(key);

        if(slots[index] == key)
        {
            return values[index];
        }

        for(int i=0; i<len; i++)
        {
            index += 1;

            if(index > len-1)
                index-=len;

            if(slots[index] == key)
                return values[index];
        }
        return null;
    }
}
