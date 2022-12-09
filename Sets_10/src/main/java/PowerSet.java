public class PowerSet
{
    private final java.util.Hashtable<String, String> hashT;
    public PowerSet()
    {
        hashT = new java.util.Hashtable<>(20000);
    }

    public int size()
    {
        return hashT.size();
    }

    public void put(String value)
    {
        if(hashT.containsKey(value))
            return;

        hashT.put(value, value);
    }

    public boolean get(String value)
    {
        return (hashT.containsKey(value));
    }

    public boolean remove(String value)
    {
        return (hashT.remove(value, value));
    }

    public PowerSet intersection(PowerSet set2)
    {
        PowerSet pwrSet = new PowerSet();

        for (String key : hashT.keySet() ) {
            if(set2.hashT.containsKey(key))
                pwrSet.put(key);
        }

        return pwrSet;
    }

    public PowerSet union(PowerSet set2)
    {
        int mainSize = hashT.size();
        int secondSize = set2.hashT.size();

        if(mainSize == 0 && secondSize != 0)
        {
            return set2;
        }

        if(mainSize >= secondSize)
        {
            for (String key : set2.hashT.keySet())
            {
                if(!hashT.containsKey(key))
                    hashT.put(key, key);
            }
            return this;
        }

        for (String key : hashT.keySet())
        {
            if(!set2.hashT.containsKey(key))
                set2.hashT.put(key, key);
        }

        return set2;
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet pwrSet = new PowerSet();

        for (String key : hashT.keySet())
        {
            if(!set2.hashT.containsKey(key))
                pwrSet.hashT.put(key, key);
        }

        return pwrSet;
    }

    public boolean isSubset(PowerSet set2)
    {
        int counter = 0;
        for (String key : set2.hashT.keySet())
        {
            if(hashT.containsKey(key))
                counter++;
        }

        return (set2.hashT.size() == counter);
    }

    public void ShowSet(PowerSet pwrSet)
    {
        for (String key : pwrSet.hashT.keySet() ) {
            System.out.print( key + " " );
        }
    }

}
