public class MethodsForTesting {

    // random LinkedList generation in given range of numbers
    public static LinkedList LLGenerate(int min, int max, int listLength) {
        LinkedList genLL = new LinkedList();
        for (int i = 0; i < listLength; i++) {
            genLL.addInTail(new Node((int) (Math.random() * (max - min)) + min));
        }
        return genLL;
    }

    public static void main(String[] args) {
        LinkedList empty_list = new LinkedList();
        empty_list.addInTail(new Node(15));
        System.out.println("Список после добавления элемента: "); empty_list.checkAll(); System.out.println();

        empty_list.clear();
        System.out.println("Список после очистки: ");  empty_list.checkAll();
        System.out.println(empty_list.tail);
    }
}
