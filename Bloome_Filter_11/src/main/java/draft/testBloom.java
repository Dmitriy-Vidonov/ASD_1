package draft;

public class testBloom {
    public static void main(String[] args)
    {
        BloomFilter bloom1 = new BloomFilter(32);
        bloom1.add("three");

        System.out.println(bitOps.toBinaryString(bloom1.bitStorage));
        System.out.println(bloom1.isValue("three"));
    }
}
