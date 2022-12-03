package draft;

public class testDict {
    public static void main(String[] args)
    {
        NativeDictionary nativ = new NativeDictionary<>(7, String.class);

        nativ.put("first_key", "first_value");
        nativ.put("second", "secondary");

        nativ.ShowTable();
        System.out.println("is key: " + nativ.isKey("second1"));
        System.out.println("get: " + nativ.get("first_key"));

        nativ.put("first_key", "second_value");
        System.out.println("get_2: " + nativ.get("first_key"));

        nativ.ShowTable();
    }
}
