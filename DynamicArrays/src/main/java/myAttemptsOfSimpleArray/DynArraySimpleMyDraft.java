package myAttemptsOfSimpleArray;

public class DynArraySimpleMyDraft {
    public int[] array;
    public int count;
    public int capacity;

    DynArraySimpleMyDraft()
    {
        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        array = new int[new_capacity];
        capacity = new_capacity;


    }
}

