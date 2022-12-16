import draft.bitOps;
public class testRightBloom {
    public static void main(String[] args)
    {
        String[] testStrings = {"0123456789", "1234567890", "2345678901", "3456789012", "4567890123",
                "5678901234", "6789012345", "7890123456", "8901234567", "9012345678"};

        BloomFilter bloom2 = new BloomFilter(32);
        System.out.println(bitOps.toBinaryString(bloom2.bitStorage));

        bloom2.add(testStrings[5]);
        System.out.println(bitOps.toBinaryString(bloom2.bitStorage));
        //bloom2.add(testStrings[0]);
        bloom2.add(testStrings[9]);
        System.out.println(bitOps.toBinaryString(bloom2.bitStorage));

        System.out.println("bloom2 isValue(5): " + bloom2.isValue(testStrings[5]));
        //System.out.println("bloom2 isValue(0): " + bloom2.isValue(testStrings[0]));
        System.out.println("bloom2 isValue(9): " + bloom2.isValue(testStrings[9]));

        System.out.println("bloom2 isValue(1): " + bloom2.isValue(testStrings[1]));
        System.out.println("bloom2 isValue(3): " + bloom2.isValue(testStrings[3]));
        System.out.println("bloom2 isValue(7): " + bloom2.isValue(testStrings[7]));

        System.out.println(bitOps.toBinaryString(bloom2.bitStorage));

        BloomFilter bloom1 = new BloomFilter(32);
        BloomFilter bloomEmpty = new BloomFilter(32);

        for(int i=0; i<testStrings.length; i++)
        {
            System.out.println(String.valueOf(i) + " : " + bloomEmpty.isValue(testStrings[i]));
        }
        System.out.println("empty string" + " : " + bloomEmpty.isValue(""));

        System.out.println("----------------");

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
