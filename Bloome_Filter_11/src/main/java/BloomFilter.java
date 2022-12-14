public class BloomFilter
{
    public int filter_len;
    public int bitStorage;
    private boolean isEmpty;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
        bitStorage = 0;
        isEmpty = true;
    }

    public int hash1(String str1)
    {
        long res = 0;
        int rand = 17;
        long len = str1.length();

        for(int i=0; i<len; i++)
        {
            if (i == 0) continue;
            int code = str1.charAt(i);
            res += (res * rand) + code;
        }
        return ((res > 0) ? (int)(res % len) : -(int)(res % len));
    }

    public int hash2(String str1)
    {
        long res = 0;
        int rand = 223;
        long len = str1.length();

        for(int i=0; i<len; i++)
        {
            if (i == 0) continue;
            int code = str1.charAt(i);
            res += (res * rand) + code;
        }
        return ((res > 0) ? (int)(res % len) : -(int)(res % len));
    }

    public void add(String str1)
    {
        if(str1.length() == 0)
            return;

        int index1 = hash1(str1);
        int index2 = hash2(str1);

        this.bitStorage = this.setBit(bitStorage, index1);
        this.bitStorage = this.setBit(bitStorage, index2);

        isEmpty = false;
    }

    public boolean isValue(String str1)
    {
        if(str1.length() == 0 || isEmpty)
            return false;

        int index1 = hash1(str1);
        int index2 = hash2(str1);

        return (getBit(this.bitStorage, index1) == 1 && getBit(this.bitStorage, index2) == 1);
    }

    public int setBit(int bitStorage, int bitIndex)
    {
        int res = bitStorage;
        res |= (1<<bitIndex);
        return res;
    }

    public int getBit(int bitStorage, int bitIndex)
    {
        int res = bitStorage & (1<<bitIndex);
        return (res > 0) ? 1 : 0;
    }
}
