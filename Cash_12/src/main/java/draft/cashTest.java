package draft;

public class cashTest {
    public static void main(String[] args)
    {
        NativeCache testCache = new NativeCache<String>(5, String.class);

        testCache.put("one_key", "one_value");
        testCache.put("two_key", "two_value");
        testCache.put("three_key", "three_value");

        testCache.hit("one_key"); testCache.hit("one_key"); testCache.hit("one_key");
        testCache.hit("two_key"); testCache.hit("two_key");
        testCache.hit("three_key");

        testCache.put("four_key", "four_value");
        testCache.put("five_key", "five_value"); // Кандидат на обнуление

        testCache.hit("four_key");

        testCache.put("six_key", "six_value");

        testCache.ShowCache();

        // Тест indexForClearing()
        System.out.println("index for clearing: " + testCache.indexForClearing());
    }
}
