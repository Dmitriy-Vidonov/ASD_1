public class MethsForTest {
    public static PowerSet setGenerator(int start, int end)
    {
        PowerSet set = new PowerSet();

        for(int i=start; i<=(end-start); i++)
            set.put(String.valueOf(i));

        return set;
    }
}
