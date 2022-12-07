package draft;

public class TestPowerSet {
    public static void main(String[] args)
    {
        PowerSet pwrSet1 = new PowerSet();
        PowerSet pwrSet2 = new PowerSet();
        PowerSet emptySet = new PowerSet();

        pwrSet1.put("10");
        pwrSet1.put("20");
        pwrSet1.put("40");
        pwrSet1.put("100");

        pwrSet2.put("50");
        pwrSet2.put("80");
        pwrSet2.put("100");
        pwrSet2.put("20");

        pwrSet1.ShowSet(pwrSet1);
        System.out.println();
        pwrSet2.ShowSet(pwrSet2);
        System.out.println();

        emptySet = pwrSet1.union(pwrSet2);
        emptySet.ShowSet(emptySet);

        System.out.println();
        System.out.println("size after union: " + emptySet.size());

       /* System.out.println("issubset = " + pwrSet1.isSubset(pwrSet2));

        pwrSet1.ShowSet(pwrSet1.intersection(pwrSet2));
        System.out.println();

        pwrSet1.ShowSet(pwrSet1.difference(pwrSet2));
        System.out.println();*/
    }
}
