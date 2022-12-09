public class testSet {
    public static void main(String[] args){
        PowerSet pwrSet1 = new PowerSet();
        PowerSet pwrSet2 = new PowerSet();
        PowerSet emptySet = new PowerSet();
        PowerSet emptySet2 = new PowerSet();

        pwrSet1.put("10");
        pwrSet1.put("20");
        pwrSet1.put("40");
        pwrSet1.put("100");

        pwrSet2.put("50");
        pwrSet2.put("80");
        pwrSet2.put("100");
        pwrSet2.put("20");

        pwrSet1.ShowSet(pwrSet1); System.out.println();
        pwrSet2.ShowSet(pwrSet2); System.out.println();
        emptySet.ShowSet(emptySet); System.out.println();
        pwrSet1.ShowSet(pwrSet1.union(emptySet)); System.out.println();

       // emptySet.ShowSet(emptySet);
        System.out.println("size of empty: " + (emptySet.union(emptySet2)).size());
        System.out.println("size of non-empty: " + (emptySet.union(pwrSet1)).size());
        System.out.println("size of non-empty2: " + (pwrSet1.union(emptySet2)).size());

        System.out.println();
    }
}
