import draft.*;
public class testBloom {
    public static void main(String[] args)
    {
        BloomFilter bloom1 = new BloomFilter(32);
        bloom1.add("1234567890");
       // System.out.println(bitOps.toBinaryString(bloom1.bitStorage));
        System.out.println(bloom1.isValue("7890123456")); // выдает неверное true

        bloom1.add("7890123456");
       // System.out.println(bitOps.toBinaryString(bloom1.bitStorage));

        System.out.println(bloom1.hash1("7890123456")); // index = 0
        System.out.println(bloom1.hash2("7890123456")); // index = 0

        String[] testStrings = {"0123456789", "1234567890", "2345678901", "3456789012", "4567890123",
                                "5678901234", "6789012345", "7890123456", "8901234567", "9012345678"};

        int i;

        for(i=0; i<testStrings.length; i++)
        {
            bloom1.add(testStrings[i]);
            System.out.println("контрольный замер [" + i + "]: " + bloom1.isValue(testStrings[i]));

            for(int j=0; j<testStrings.length; j++)
            {
                if(j == i) continue;
                System.out.println(String.valueOf(j) + " : " + bloom1.isValue(testStrings[j]));
            }
            System.out.println("***************");
        }
    }
}
