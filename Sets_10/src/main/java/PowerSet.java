public class PowerSet
{
    private int storageSize;
    private java.util.Hashtable<String, String> hashT;
    public PowerSet()
    {
        hashT = new java.util.Hashtable<String, String>(20000);
        storageSize = 0;
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
    }

    public boolean get(String value)
    {
        return (this.hashT.containsKey(value));
    }

    public boolean remove(String value)
    {
        if(this.hashT.remove(value, value) == true)
        {
            storageSize--;
            return true;
        }
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        PowerSet pwrSet = new PowerSet();

        for (Object key : this.hashT.keySet() ) {
            if(set2.hashT.containsKey(key))
                pwrSet.put(String.valueOf(key));
        }

        return pwrSet;
    }

    public PowerSet union(PowerSet set2)
    {
        int mainSize = this.hashT.size();
        int secondSize = set2.hashT.size();

        if(mainSize >= secondSize)
        {
            for (Object key : set2.hashT.keySet())
            {
                if(!this.hashT.containsKey(key))
                    this.hashT.put(String.valueOf(key), String.valueOf(key));
            }
            return this;
        }

        for (Object key : this.hashT.keySet())
        {
            if(!set2.hashT.containsKey(key))
                set2.hashT.put(String.valueOf(key), String.valueOf(key));
        }

        return set2;
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet pwrSet = new PowerSet();

        for (Object key : this.hashT.keySet())
        {
            if(!set2.hashT.containsKey(key))
                pwrSet.hashT.put(String.valueOf(key), String.valueOf(key));
        }

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
    
        return (set2.hashT.size() == counter);
    }
}
