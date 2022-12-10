import java.util.ArrayList;
import java.util.List;

public class testSet {
    public static void main(String[] args){
        PowerSet pwrSet1 = new PowerSet();
        PowerSet pwrSet2 = new PowerSet();
        PowerSet emptySet = new PowerSet();

        pwrSet1.put("10");
        pwrSet1.put("20");
        pwrSet1.put("40");
        pwrSet1.put("100");
        pwrSet1.put("10");

        pwrSet2.put("50");
        pwrSet2.put("80");
        pwrSet2.put("100");
        pwrSet2.put("20");

        /*pwrSet1.ShowTable();
        pwrSet2.ShowTable();
        emptySet.ShowTable();*/

        //get из пустого множества
        System.out.println("get из пустого множества: " + emptySet.get("10"));

        //get из непустого множества при наличии искомого элемента
        System.out.println("get из непустого множества с искомым: " + pwrSet1.get("10"));

        //get из непустого множества при отсутствии искомого элемента
        System.out.println("get из непустого множества с искомым: " + pwrSet1.get("101"));

        System.out.println();

        //remove из пустого множества
        System.out.println("remove из пустого множества: " + emptySet.remove("10"));

        //remove из непустого множества при наличии искомого элемента
        System.out.println("remove из непустого множества с искомым: " + pwrSet1.remove("10"));
       // pwrSet1.ShowTable();

        //remove из непустого множества при отсутствии искомого элемента
        System.out.println("remove из непустого множества без искомого: " + pwrSet1.remove("101"));
        //pwrSet1.ShowTable();

    }
}
