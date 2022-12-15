package draft;

public class bitOps {

    public static int setBit(int value, int bitIndex)
    {
        int res = value;
        res |= (1<<bitIndex);
        return res;
    }

    public static int removeBit(int value, int bitIndex)
    {
        int res = value;
        res &= ~(1<<bitIndex);
        return res;
    }

    public static int getBit(int value, int bitIndex)
    {
        int res = value & (1<<bitIndex);
        return (res > 0) ? 1 : 0;
    }

    public static int firstHashFunc()
    {
        int res = 0;

        return res;
    }

    public static int secondHashFunc()
    {
        int res = 0;

        return res;
    }

    public static String toBinaryString(int value) {
        StringBuilder result = new StringBuilder(32);
        for(int i = 0; i < 32; ++i) {
            result.append((value & 1) == 1 ? '1' : '0');
            value >>>= 1;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args)
    {
        // массив m - 32 разрядное число. Это обычный int

        // как перевести int в бинарную систему?
        int m = 42;
        System.out.println(toBinaryString(m));

       // m |= (1<<7);
        m = setBit(m, 7);
        System.out.println(toBinaryString(m));

        System.out.println(getBit(m, 1));

        m = removeBit(m, 1);
        System.out.println(toBinaryString(m));
    }
}
