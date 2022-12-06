package draft;

public class TestPowerSet {
    public static void main(String[] args)
    {
        PowerSet powerSet = new PowerSet();

        powerSet.put("one");
        powerSet.put("one");
        powerSet.put("two");


        for (Object key : powerSet.keySet() ) {
            System.out.println( key );
        }

        System.out.println("size = " + powerSet.size());
        System.out.println("get value = " + powerSet.get("three"));
        System.out.println("get value = " + powerSet.get("one"));
        System.out.println("remove = " + powerSet.remove("one"));


    }
}
