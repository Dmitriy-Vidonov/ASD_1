package draft3;

public class tableTest {
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
        //hTable.put("10");
        hTable.put("11");
        hTable.put("12");
        hTable.put("13");
        hTable.put("14");
        hTable.put("15");
        hTable.put("16");
        hTable.put("17");

      /*  hTable.slots[1] = "one";
        hTable.slots[4] = "four";
        hTable.slots[7] = "seven";
        hTable.slots[2] = "two";
        hTable.slots[5] = "five";
        hTable.slots[0] = "zero";
        hTable.slots[3] = "three";
        hTable.slots[6] = "six";
        hTable.slots[8] = "eight";
        hTable.slots[9] = "nine";
        hTable.slots[10] = "ten";*/


        hTable.ShowTable();

          System.out.println("seek - " + hTable.seekSlot("17"));

          System.out.println("find: " + hTable.find("169"));

        // Проверка прохода таблицы по шагам

     /*
        String[] slots = new String[10];
        int len = slots.length;

        for(int i=0; i<len; i++) slots[i] = null;

        slots[1] = "one";
        slots[4] = "four";
        slots[7] = "seven";
        slots[2] = "two";
        slots[5] = "five";
        slots[0] = "zero";
        slots[3] = "three";
        slots[6] = "six";


        for(String elem : slots) System.out.print(elem + " "); System.out.println();

        int step = 9; // step не должен быть >= len
        int index = 1; // предположим, чтор это значение мы получили с помощью хэш-функции
        int res = -1;

        for(int i=0; i<len; i++)
        {
            index += step;

            if(index > len-1)
                index-=len;

            if(slots[index] == null)
            {
                res = index;
                break;
            }
        }
        System.out.println("seek = " + res);*/
    }
}
