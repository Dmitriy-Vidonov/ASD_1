package draft;

public class tests {
    public static void main(String[] args)
    {
        ShowType val1 = new ShowType<>("stroka");

        System.out.println(val1.compare("stroka", "stroka1"));
    }
}

class ShowType<T>
{
    public T val;

    ShowType(T _value)
    {
        val = _value;
    }

    public int compare(T v1, T v2)
    {
        // Проверяем, является ли значение числовым
        // Для целочисленных значений
        if(((v1.getClass().getTypeName().endsWith("Integer")) &&
                (v2.getClass().getTypeName().endsWith("Integer"))
                ) && ((int)v1 < (int)v2)
        ) return -1;  // -1 если v1 < v2

        if(((v1.getClass().getTypeName().endsWith("Integer")) &&
                (v2.getClass().getTypeName().endsWith("Integer"))
                ) && ((int)v1 == (int)v2)
        ) return 0; // 0 если v1 == v2

        if(((v1.getClass().getTypeName().endsWith("Integer")) &&
                (v2.getClass().getTypeName().endsWith("Integer"))
                ) && ((int)v1 > (int)v2)
        ) return 1; // +1 если v1 > v2


        // Для чисел с плавающей точкой
        if(((v1.getClass().getTypeName().endsWith("Float") || v1.getClass().getTypeName().endsWith("Double")) &&
                (v2.getClass().getTypeName().endsWith("Float") || v2.getClass().getTypeName().endsWith("Double"))
        ) && ((double)v1 < (double)v2)
        ) return -1;  // -1 если v1 < v2

        if(((v1.getClass().getTypeName().endsWith("Float") || v1.getClass().getTypeName().endsWith("Double")) &&
                (v2.getClass().getTypeName().endsWith("Float") || v2.getClass().getTypeName().endsWith("Double"))
        ) && ((double)v1 == (double)v2)
        ) return 0; // 0 если v1 == v2

        if(((v1.getClass().getTypeName().endsWith("Float") || v1.getClass().getTypeName().endsWith("Double")) &&
                (v2.getClass().getTypeName().endsWith("Float") || v2.getClass().getTypeName().endsWith("Double"))
        ) && ((double)v1 > (double)v2)
        ) return 1; // +1 если v1 > v2

        // Если у нас строки
        if(v1.getClass().getTypeName().endsWith("String") && v2.getClass().getTypeName().endsWith("String"))
        {
            String s1 = "";
            String s2 = "";
            s1 = (String) v1;
            s2 = (String) v2;
            // Очистка строк от начальных и конечных пробелов
            s1 = s1.trim();
            s2 = s2.trim();

            return s1.compareTo(s2);
        }

        return 0;
    }

}