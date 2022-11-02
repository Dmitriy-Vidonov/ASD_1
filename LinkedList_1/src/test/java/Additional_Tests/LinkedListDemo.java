package Additional_Tests;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>(); // создаем LinkedList со строками
        // добавим несколько элементов в конец
        linkedList.addLast("B");
        linkedList.addLast("C");
        linkedList.addLast("D");
        linkedList.addLast("E");
        System.out.println("LL: " + linkedList);

        // после чего попытаемся добавить элемент в начало
        linkedList.addFirst("A");
        System.out.println("LL: " + linkedList);

        // попытаемся найти элементы
        System.out.println("Index of element with value E: " + linkedList.get("E"));
        System.out.println("Index of element with value ZZZ: " + linkedList.get("ZZZ"));

        // попытаемся удалить элемент со значением C
        linkedList.remove("C");
        System.out.println("LL: " + linkedList);
    }
}
