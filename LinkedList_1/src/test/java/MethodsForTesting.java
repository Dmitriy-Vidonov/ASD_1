public class MethodsForTesting {

    // random LinkedList generation in given range of numbers
    public static LinkedList LLGenerate(int min, int max, int listLength)
    {
        LinkedList genLL = new LinkedList();
        for(int i=0; i<listLength; i++)
        {
            genLL.addInTail(new Node((int)(Math.random() * (max - min)) + min));
        }
        return genLL;
    }

    public static void main(String[] args) {
        // Проверочный вывод списка
        LinkedList testLL = LLGenerate(10, 200, 10000);
        System.out.println();
        System.out.println("удалить данные из списка - " + testLL.Remove(150));
    }
}
