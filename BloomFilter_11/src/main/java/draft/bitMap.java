package draft;

public class bitMap { // Разбор битовой карты - что это такое
    // https://javarush.com/quests/lectures/questmultithreading.level10.lecture10  - неплохой урок по теме битовой карты
    public static void main(String[] args)
    {
        // Пример хранения логических значений в одном числе
        boolean a = true;
        boolean b = false;
        boolean c = true;
        boolean d = false;

        // Упаковка их в одно число
        int result = 0;
        if(a) result += 1; // 1 == 2^0 - нулевой бит
        if(b) result += 2; // 2 == 2^1 - первый бит
        if(c) result += 4; // 4 == 2^2 - второй бит
        if(d) result += 8; // 8 == 2^3 - третий бит

        // У каждого бита - своя переменная. И если логическая переменная = true, то значит бит = 1
        // 0000 0101 =
        // 0000 dcba
        // a = true, c = true, значит result = 1 + 4 = 5
        System.out.println("result = " + result); // == 5.
    }

}
