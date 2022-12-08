public class PowerSet
{
    private java.util.HashMap<String, String> hashT;
    public PowerSet()
    {
        hashT = new java.util.HashMap<>(20000);
    }

    public int size()
    {
        return hashT.size();
    }

    public void put(String value)
    {
        if(hashT.containsKey(String.valueOf(value)))
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

        for (Object key : hashT.keySet() ) {
            if(set2.hashT.containsKey(key))
                pwrSet.put(String.valueOf(key));
        }

        return pwrSet;
    }

    public PowerSet union(PowerSet set2)
    {
        int mainSize = hashT.size();
        int secondSize = set2.hashT.size();

      /*  if((secondSize == 0 && mainSize != 0) || (secondSize == 0 && mainSize == 0))
        {
            return this;
        } */

        if(mainSize == 0 && secondSize != 0)
        {
            return set2;
        }

        if(mainSize >= secondSize)
        {
            for (Object key : set2.hashT.keySet())
            {
                if(!hashT.containsKey(key))
                    hashT.put(String.valueOf(key), String.valueOf(key));
            }
            return this;
        }

        for (Object key : hashT.keySet())
        {
            if(!set2.hashT.containsKey(key))
                set2.hashT.put(String.valueOf(key), String.valueOf(key));
        }

        return set2;
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet pwrSet = new PowerSet();

        for (Object key : hashT.keySet())
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
            if(hashT.containsKey(key))
                counter++;
        }

        return (set2.hashT.size() == counter);
    }

    public void ShowSet(PowerSet pwrSet)
    {
        for (Object key : pwrSet.hashT.keySet() ) {
            System.out.print( key + " " );
        }
    }

}
