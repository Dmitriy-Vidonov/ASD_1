import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class testSet {
    public static void main(String[] args){
        PowerSet pwrSet1 = new PowerSet();
        PowerSet pwrSet2 = new PowerSet();

        PowerSet bigSet1 = new PowerSet();
        PowerSet bigSet2 = new PowerSet();

        PowerSet emptySet = new PowerSet();
        PowerSet emptySet2 = new PowerSet();

        pwrSet1.put("10");
        pwrSet1.put("20");
        pwrSet1.put("30");
        pwrSet1.put("40");

        pwrSet2.put("10");
        pwrSet2.put("20");
        pwrSet2.put("330");
        pwrSet2.put("40");


        pwrSet1.ShowTable();
        System.out.println(pwrSet1.remove("190870"));
        pwrSet1.ShowTable();


     /*   long currTime1 = java.lang.System.currentTimeMillis();
       // long seconds1 = TimeUnit.MILLISECONDS.toSeconds(java.lang.System.currentTimeMillis());
        for(int i=0; i<10000; i++)
            bigSet1.put(String.valueOf(i));
       // long seconds2 = TimeUnit.MILLISECONDS.toSeconds(java.lang.System.currentTimeMillis());
        long currTime2 = java.lang.System.currentTimeMillis();

        for(int i=10000; i<20000; i++)
            bigSet2.put(String.valueOf(i));

       // System.out.println("big set1: "); bigSet1.ShowTable();
      //  System.out.println("big set2: "); bigSet2.ShowTable();

        System.out.println("bigSet1 size = " + bigSet1.size());
        System.out.println("bigset2 size = " + bigSet2.size());

        long currTime3 = java.lang.System.currentTimeMillis();
        System.out.println("union size:" + bigSet1.union(bigSet2).size());
        long currTime4 = java.lang.System.currentTimeMillis();

        PowerSet soBig = bigSet1.union(bigSet2);

        System.out.println("create set: " + ((float)(currTime2 - currTime1) / 1000) + " сек");
        System.out.println("create union: " + ((float)(currTime4 - currTime3) / 1000) + " сек");

        System.out.println();

        PowerSet ps = new PowerSet();
        System.out.println("get from empty: " + ps.get("329847"));
        */
    }
}
