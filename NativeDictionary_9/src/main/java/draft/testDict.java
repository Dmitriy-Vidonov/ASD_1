package draft;

public class testDict {
    public static void main(String[] args)
    {
        NativeDictionary nativ = new NativeDictionary<>(10, String.class);

        nativ.put("first_key", "first_value");
        nativ.put("second_key", "second_value");
        nativ.put("third_key", "third_value");

        nativ.ShowTable();
        System.out.println("is key: " + nativ.isKey("third_key"));

        System.out.println("get: " + nativ.get("first_key"));

        nativ.put("first_key", "second_value");
        System.out.println("get_2: " + nativ.get("first_key"));

        nativ.ShowTable();
    }
}
