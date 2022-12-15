package draft;

public class bitOps {

    // Установить бит в единицу по нужному индексу
    public static int setBit(int value, int bitIndex)
    {
        int res = value;
        res |= (1<<bitIndex);
        return res;
    }

    // Установить бит в ноль по нужному индексу
    public static int removeBit(int value, int bitIndex)
    {
        int res = value;
        res &= ~(1<<bitIndex);
        return res;
    }

    // Получить значение бита по указанному индексу
    public static int getBit(int value, int bitIndex)
    {
        int res = value & (1<<bitIndex);
        return (res > 0) ? 1 : 0;
    }

    // Первая хэш-функция с рандомным числом = 17
    public int hash1(String str1)
    {
        int result = 0;
        // 17
        for(int i=0; i<str1.length(); i++) // цикл до длины строки, рез-тат с предыдущ. итерации на 17 + код символа
        {
            int code = (int)str1.charAt(i);
            // в качестве рез-тата первой итерации использовать ноль
        }
        // реализация ...
        return 0;
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
        int m1 = 0;
        m1 = setBit(m1, 0); // m1 = 1
        m1 = setBit(m1, 1); // m1 = 3
        m1 = setBit(m1, 2); // m1 = 7
        m1 = removeBit(m1, 1); // m1 = 5

        System.out.println("m1 = " + toBinaryString(m1));
        System.out.println("m1 = " + m1);

        int m = 42;
        System.out.println(toBinaryString(m));

       // m |= (1<<7);
        m = setBit(m, 7);
        System.out.println(toBinaryString(m));

        System.out.println(getBit(m, 1));

        m = removeBit(m, 1);
        System.out.println(toBinaryString(m));

        // Тестирование цикла для хэш-функции
        int res = 0;
        String str1 = "three";
        int rand = 17;

        for(int i=0; i<str1.length(); i++)
            System.out.println(String.valueOf(str1.charAt(i)) + " = " + (int)str1.charAt(i));


        // 1-я хэш-функция
        for(int i=0; i<str1.length(); i++)
        {
            if (i == 0) continue;
            res += (res * rand) + (int)str1.charAt(i);
        }
        int index = res % str1.length();

        System.out.println("index = " + index); // index = 3 корректный результат

        // 2-я хэш-функция
        res = 0;
        rand = 223;
        for(int i=0; i<str1.length(); i++)
        {
            if (i == 0) continue;
            res += (res * rand) + (int)str1.charAt(i);
        }
        int index2 = res % str1.length();

        System.out.println("index2 = " + index2); // index2 = 0 корректный результат

    }
}
