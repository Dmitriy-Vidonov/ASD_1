package draft;

public class hash_fun {

    public static long gcd(long a,long b){
        return b == 0 ? a : gcd(b,a % b);
    }


    public static int hashFun(String value, int len) { // Основная функция h1(v)
        int hash;
        hash = 0;

        for(int i = 0; i < value.length(); i++)
        {
            hash ^= ((hash << 5) + value.charAt(i) + (hash >> 2));
        }

        hash &= 0x7FFFFFFF;

        return hash %= len;
    }

    public static int hashFun2(String value, int len) // Функция h2(v) для метода двойного хэширования
    {
        int hash;
        hash = Math.abs(value.hashCode());
        hash %= len;

        while (gcd(len, hash) != 1 && hash <= len-1) // Проверяем, чтобы НОД hash-a был взаимно простым с len
            hash+=1;

        return hash;
    }

    public static int hashFun3(String value, int len)
    {
        int hash;
        hash = Math.abs(value.hashCode());
        String hashStr = Integer.toString(hash);
        hash = Math.abs(hashStr.hashCode());

        hash %= len;

        return hash;
    }

    public static int seekSlot(String value, String[] str, int load_count)
    {
        int len = str.length;

        // находит индекс пустого слота для значения, или -1
        int index = hashFun3(value, len);

        int res = 0;

        if(load_count == len)
            return -1;

        if(str[index] == null)
            return index;

        int count = index;
        int step = 3;

        while (str[count] != null && load_count < len) // пока в списке есть свободные места, load_count < len
        {
            if((count + step) > (len-1))
            {
                count = ((count + step) - len);
                continue;
            }

            count+=1;
        }
        return count;

       // return -1;
    }

    public static int find(String value, String[] str)
    {
        int len = str.length;
        int index = hashFun3(value, len);

        if(str[index].equals(value))
            return index;

        int step = 3;
        int counter = 0;

        while ((!str[index].equals(value)) && (counter < len)) // пока в списке есть свободные места, load_count < len
        {
            if((index + step) > (len-1))
            {
                index = ((index + step) - len);
                continue;
            }
            index++;
            counter++;
        }

        if(!str[index].equals(value))
            return -1;

        return index;
        // находит индекс слота со значением, или -1
    }

    public static void main(String[] args) {

        System.out.println("hashCode ba = " + hashFun2("ba", 17));
        System.out.println("hashCode ab = " + hashFun2("ab", 17));

        String[] strArr = {"one", "three", "four", "five", "six", "seven", "ten10", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen"};

        for(int i=0; i<strArr.length; i++)
        {
          //  System.out.println(hashFun3(strArr[i], strArr.length));
        }

        System.out.println("null индекс - " + seekSlot("one", strArr, 17));
        System.out.println("find индекс - " + find("four", strArr));
    }
}
