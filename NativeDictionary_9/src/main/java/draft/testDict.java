package draft;

public class testDict {
    public static void main(String[] args)
    {
        NativeDictionary<Integer> nativ = new NativeDictionary<>(2, Integer.class);

      /*  nativ.put("0_key", 0);
        nativ.put("1_key", 1);
        nativ.put("2_key", 2);
        nativ.put("3_key", 3);
        nativ.put("4_key", 4);
        nativ.put("5_key", 5);
        nativ.put("6_key", 6);
        nativ.put("7_key", 7);
        nativ.put("8_key", 8);
        nativ.put("9_key", 9);*/

        nativ.ShowTable();
        System.out.println("is key: " + nativ.isKey("9_key"));

        System.out.println("get: " + nativ.get("first_key"));

        nativ.put("first_key", 1);
        nativ.put("second_key", 2);
        System.out.println("get_2: " + nativ.get("first_key"));

        nativ.ShowTable();
    }
}
