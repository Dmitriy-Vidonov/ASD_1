package draft;

public class hash_fun {

    public static long gcd(long a,long b){
        return b == 0 ? a : gcd(b,a % b);
    }


    public static int hashFun(String value, int len) { // Основная функция h1(v)
        int hash;
        hash = 0;

        return hash;
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

    public static void main(String[] args) {

        System.out.println("hashCode ba = " + hashFun2("ba", 17));
        System.out.println("hashCode ab = " + hashFun2("ab", 17));

        String[] strArr = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen"};

        for(int i=0; i<strArr.length; i++)
        {
            System.out.println(hashFun2(strArr[i], strArr.length));
        }
    }
}
