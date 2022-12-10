package draft2;

public class testSet {
    public static void main(String[] args)
    {
        PowerSet set1 = new PowerSet();
        PowerSet set2 = new PowerSet();
        PowerSet emptySet1 = new PowerSet();
        PowerSet emptySet2 = new PowerSet();
        PowerSet cloneSet = new PowerSet();

        set1.put("10");
        set1.put("20");
        set1.put("40");
        set1.put("100");

        //set2.put("50");
        //set2.put("80");
        //set2.put("100");
        set2.put("20");
        set2.put("40");

        set1.clone(cloneSet);

        //set1.ShowTable();
        //set2.ShowTable();
        cloneSet.ShowTable();

        System.out.println("size of clone: " + cloneSet.size());

       /* System.out.print("Intersection: "); set1.intersection(set2).ShowTable();
        System.out.print("Union: "); set1.union(set2).ShowTable();
        System.out.print("Union with empty: "); set1.union(emptySet1).ShowTable();*/
        //System.out.print("Union two emptys: "); emptySet1.union(emptySet2).ShowTable();
        //System.out.print("Difference: "); set1.difference(set2).ShowTable();
        System.out.print("Subset: " + set1.isSubset(set2));
    }
}
