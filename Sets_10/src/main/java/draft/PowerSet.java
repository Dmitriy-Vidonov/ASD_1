package draft;
public class PowerSet
{
    public PowerSet() // Конструктор класса, в котором создается обьект-хранилище
    {
        // ваша реализация хранилища
    }

    public int size() // Возвращаем размер нашего хранилища
    {
        // количество элементов в множестве
        return 0;
    }

    public void put(String value) // Добавление элемента в хранилище с учетом проверки на дубли
    {
        // всегда срабатывает
    }

    public boolean get(String value)
    {
        // возвращает true если value имеется в множестве,
        // иначе false
        return false;
    }

    public boolean remove(String value)
    {
        // возвращает true если value удалено
        // иначе false
        return false;
    }

    public PowerSet intersection(PowerSet set2) // Множество только из элементов, которые есть в обеих множествах
    {
        // пересечение текущего множества и set2
        return null;
    }

    public PowerSet union(PowerSet set2) // Множество из элементов обеих множеств
    {
        // объединение текущего множества и set2
        return null;
    }

    public PowerSet difference(PowerSet set2) // Множ-во из эл-тов, которые входят в основное множ-во и не входят в set2
    {
        // разница текущего множества и set2
        return null;
    }

    public boolean isSubset(PowerSet set2)
    {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        return false;
    }

}
