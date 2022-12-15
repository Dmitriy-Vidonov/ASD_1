public class BloomFilter
{
    public int filter_len;
    private int bitStorage;
    private int mainIndex1;
    private int mainIndex2;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
        bitStorage = 0;
    }

    public int hash1(String str1)
    {
        int res = 0;
        int rand = 17;
        int len = str1.length();

        for(int i=0; i<len; i++)
        {
            if (i == 0) continue;
            int code = str1.charAt(i);
            res += (res * rand) + code;
        }
        return res % len;
    }
    
    public int hash2(String str1)
    {
        int res = 0;
        int rand = 223;
        int len = str1.length();

        for(int i=0; i<len; i++)
        {
            if (i == 0) continue;
            int code = str1.charAt(i);
            res += (res * rand) + code;
        }
        return res % len;
    }

    public void add(String str1)
    {
        bitStorage = 0;
        mainIndex1 = 0;
        mainIndex2 = 0;

        if(str1.length() == 0)
            return;

        mainIndex1 = this.hash1(str1);
        mainIndex2 = this.hash2(str1);

        bitStorage = this.setBit(bitStorage, mainIndex1);
        bitStorage = this.setBit(bitStorage, mainIndex2);
    }

    public boolean isValue(String str1)
    {
        int index1 = hash1(str1);
        int index2 = hash2(str1);

        return (index1 == mainIndex1 && index2 == mainIndex2);
    }

    public int setBit(int bitStorage, int bitIndex)
    {
        int res = bitStorage;
        res |= (1<<bitIndex);
        return res;
    }
}
