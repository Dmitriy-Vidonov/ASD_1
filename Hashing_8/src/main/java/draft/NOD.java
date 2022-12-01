package draft;

public class NOD {
    public static long gcd(long a,long b){
        return b == 0 ? a : gcd(b,a % b);
    }

    public static void main(String[] args)
    {
        System.out.println("НОД - " + gcd(10, 24));
        System.out.println("НОД - " + gcd(12, 24));
        System.out.println("НОД - " + gcd(11, 24));
    }
}
