import java.util.Objects;

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

        if(loadCount == len)
            return -1;

        if(slots[index] == null)
            return index;

        int count = index;

        while (slots[count] != null && loadCount < len)
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

        return -1;
    }

    public int find(String value)
    {
        int len = slots.length;
        int index = hashFun(value);

        if(loadCount == 0)
            return -1;

        if(slots[index].equals(value))
            return index;

        int counter = 0;

        while (!(slots[index] == null) || (!(Objects.equals(slots[index], value)) && (counter < len)))
        {
            if((index + step) > (len-1))
            {
                index = ((index + step) - len);
                continue;
            }
            index++;
            counter++;
        }

        if(!Objects.equals(slots[index], value))
            return -1;

        return index;
    }

    public void ShowTable()
    {
        for (int i=0; i<slots.length; i++)
            System.out.print(slots[i] + " ");
        System.out.println();
    }
}

