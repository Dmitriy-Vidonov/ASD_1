public class HashTable
{
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
        return res;
    }
}
