import java.util.HashSet;
import java.util.Set;

public class OrigSets {
    // проверка работы оригинального множества
    public static void main(String[] args)
    {
        Set<String> set1 = new HashSet<>(20000);
        Set<String> set2 = new HashSet<>(20000);
        Set<String> result = new HashSet<>(20000);
        Set<String> emptySet = new HashSet<>(20000);

        set1.add("10");
        set1.add("20");
        set1.add("40");
        set1.add("100");

        set2.add("50");
        set2.add("80");
        set2.add("100");
        set2.add("20");

        System.out.println("set1 = " + set1.toString());
        System.out.println("set2 = " + set2.toString());

        result.clear();
        result.addAll(set1);
        result.addAll(emptySet);

        System.out.println("result = " + result.toString());
    }
}
