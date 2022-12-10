public class MethsForTest {
    public static PowerSet setGenerator(int count)
    {
        PowerSet set = new PowerSet();

        for(int i=0; i<count; i++)
            set.put(String.valueOf(i));

        return set;
    }
}
