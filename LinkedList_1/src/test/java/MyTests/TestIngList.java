package MyTests;

public class TestIngList {
    public static void main(String[] args) {
        Node n1 = new Node(12); // инициализировали первый узел
        Node n2 = new Node(55); // инициализировали второй узел
        n1.next = n2; // в указатель первого узла занесли второй узел

        LinkedList s_list = new LinkedList(); // инициализировали новый список
        s_list.add_in_tail(n1); // в конец списка добавили первый узел, указанный ранее
        s_list.add_in_tail(n2); // в конец списка добавили второй узел, указанный ранее
        s_list.add_in_tail(new Node(128)); // в конец списка добавили новый узел. next нового узла == null

        // перебрать все элементы списка и вывести их на экран - все это в методе checkAll класса LinkedList
        s_list.checkAll(); // вывод на экран всех элементов списка
        System.out.println(); // отступ
        int k = 2;
        System.out.println("узел под индексом " + k + " = " + s_list.Get(k).value);

        // найти узел по его значению
        int val = 550;
        System.out.println("По значению " + val + " узел - " + s_list.findByValue(val));
    }
}
