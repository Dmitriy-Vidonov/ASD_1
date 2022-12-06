package draft;

public class TestPowerSet {
    public static void main(String[] args)
    {
        PowerSet pwrSet1 = new PowerSet();
        PowerSet pwrSet2 = new PowerSet();

        pwrSet1.put("one");
        pwrSet1.put("two");
        pwrSet1.put("three");
        pwrSet1.put("four");
        pwrSet1.put("five");
        pwrSet1.put("six");

        pwrSet2.put("one");
        pwrSet2.put("four");
        pwrSet2.put("five");

        pwrSet1.ShowSet(pwrSet1);
        System.out.println();
        pwrSet2.ShowSet(pwrSet2);
        System.out.println();

        System.out.println("issubset = " + pwrSet1.isSubset(pwrSet2));

        pwrSet1.ShowSet(pwrSet1.intersection(pwrSet2));
        System.out.println();

        pwrSet1.ShowSet(pwrSet1.union(pwrSet2));
        System.out.println();

        pwrSet1.ShowSet(pwrSet1.difference(pwrSet2));
        System.out.println();
    }
}
