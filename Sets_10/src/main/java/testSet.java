import java.util.ArrayList;
import java.util.List;

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
        pwrSet1.put("10");

        pwrSet2.put("50");
        pwrSet2.put("80");
        pwrSet2.put("100");
        pwrSet2.put("20");

        System.out.println("empty size: " + emptySet.size());

        System.out.println("pwrSet1: ");
        //pwrSet1.ShowTable();
        System.out.println("size pwrSet1: " + pwrSet1.size());

        System.out.println("remove 10: " + pwrSet1.remove("10"));
        System.out.println("remove 101: " + pwrSet1.remove("101"));

        System.out.println("pwrSet1: ");
        //pwrSet1.ShowTable();
        System.out.println("size pwrSet1: " + pwrSet1.size());
    }
}
