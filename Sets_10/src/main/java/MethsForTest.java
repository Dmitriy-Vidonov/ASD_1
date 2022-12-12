public class MethsForTest {
    public static PowerSet setGenerator(int start)
    {
        PowerSet set = new PowerSet();

        for(int i=start; i<start+10000; i++)
            set.put(String.valueOf(i));

        return set;
    }

    public static void main(String[] args)
    {

        PowerSet set1 = setGenerator(0);
        PowerSet set2 = setGenerator(10000);


        System.out.println("s1 size: " + set1.size());
        System.out.println("s2 size: " + set2.size());
    }
}
