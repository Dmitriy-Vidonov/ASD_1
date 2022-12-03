package draft2;

public class hashTableTest {
    public static void main(String[] args)
    {
        HashTable hTable = new HashTable(17, 3);

        hTable.ShowTable();

        hTable.put("1");
        hTable.put("2");
        hTable.put("3");
        hTable.put("4");
        hTable.put("5");
        hTable.put("6");
        hTable.put("7");
        hTable.put("8");
        hTable.put("9");
       // hTable.put("10");
        hTable.put("11");
        hTable.put("12");
        hTable.put("13");
        hTable.put("14");
        hTable.put("15");
        hTable.put("16");
        hTable.put("17");

        hTable.ShowTable();

        //  System.out.println("seek - " + hTable.seekSlot("17"));

        System.out.println("find: " + hTable.find("120"));

    }
}
