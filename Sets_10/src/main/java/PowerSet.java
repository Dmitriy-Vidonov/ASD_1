public class PowerSet
{
    private final int step;
    protected String [] slots;
    protected java.util.List<Integer> indexes;

    public PowerSet()
    {
        int capacity = 20000;
        step = 8;
        slots = new String[capacity];
        indexes = new java.util.ArrayList<>();
        java.util.Arrays.fill(slots, null);
    }

    public int size()
    {
        return indexes.size();
    }

    public void put(String value)
    {
        int index = seekSlot(value);

        if(index != -1 && !this.get(value))
        {
            slots[index] = value;
            indexes.add(index);
        }
    }

    public boolean get(String value)
    {
        int len = slots.length;
        int index = hashFun(value);

        if(java.util.Objects.equals(slots[index], value))
            return true;

        for(int i=0; i<len; i++)
        {
            index += step;

            if(index > len-1)
                index-=len;

            if(java.util.Objects.equals(slots[index], value))
            {
                return true;
            }
        }
        return false;
    }

    public boolean remove(String value)
    {
        int findIndex = find(value);

        if(findIndex != -1)
        {
            slots[findIndex] = null;
            indexes.remove(Integer.valueOf(findIndex));

            return true;
        }

        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        PowerSet pwrSet = new PowerSet();

        for (Integer index : indexes) {
            if (set2.get(this.slots[index]))
                pwrSet.put(this.slots[index]);
        }

        return pwrSet;
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

        if(mainSize == 0)
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

        for (Integer index : this.indexes) {
            if (!set2.get(this.slots[index]))
                pwrSet.put(this.slots[index]);
        }

        return pwrSet;
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet pwrSet = new PowerSet();

        for (Integer index : this.indexes) {
            if (!set2.get(this.slots[index]))
                pwrSet.put(this.slots[index]);
        }

        return pwrSet;
    }

    public boolean isSubset(PowerSet set2)
    {
        int counter = 0;

        for(int i=0; i<set2.indexes.size(); i++) {
            if(this.get(set2.slots[set2.indexes.get(i)]))
                counter++;
        }

        return (set2.size() == counter);
    }

    public int hashFun(String value)
    {
        int hash;
        hash = value.hashCode();
        String hashStr = Integer.toString(hash);
        hash = hashStr.hashCode();

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

    public int find(String value)
    {
        int res = -1;
        int len = slots.length;
        int index = hashFun(value);

        if(java.util.Objects.equals(slots[index], value))
            return index;

        for(int i=0; i<len; i++)
        {
            index += step;

            if(index > len-1)
                index-=len;

            if(java.util.Objects.equals(slots[index], value))
            {
                res = index;
                break;
            }
        }
        return res;
    }

    public void clone(PowerSet set2)
    {
        for (Integer index : this.indexes) set2.put(this.slots[index]);
    }
}