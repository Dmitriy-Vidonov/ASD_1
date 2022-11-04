package MyTests;

import java.util.ArrayList;

public class TestIngList {
    public static void main(String[] args) {
        Node n1 = new Node(12); // инициализировали первый узел
        Node n2 = new Node(12); // инициализировали второй узел
        n1.next = n2; // в указатель первого узла занесли второй узел
        Node n3 = new Node(128);
        Node n4 = new Node(128);
        Node n5 = new Node(129);
        Node n6 = new Node(129);
        Node n7 = new Node(12);
        Node _nodeToInsert = new Node(15);

        LinkedList s_list = new LinkedList(); // инициализировали новый список
        s_list.add_in_tail(n1); // в конец списка добавили первый узел, указанный ранее
        s_list.add_in_tail(n2); // в конец списка добавили второй узел, указанный ранее
        s_list.add_in_tail(n3);
        s_list.add_in_tail(n4);
        s_list.add_in_tail(n5);
        s_list.add_in_tail(n6);
        s_list.add_in_tail(n7);

        // перебрать все элементы списка и вывести их на экран - все это в методе checkAll класса LinkedList
        s_list.checkAll(); // вывод на экран всех элементов списка
        System.out.println(); // отступ
        //int k = 2;
        //System.out.println("узел под индексом " + k + " = " + s_list.Get(k).value);

        //System.out.println(s_list.Remove(128));
        //  s_list.checkAll();
        //System.out.println();

        //System.out.println("Список после очистки:");
        //s_list.clear();
        //s_list.checkAll();

        // Тест removeAll
        s_list.removeAll(12);
        s_list.checkAll();
        System.out.println();

        // проверяем заполнение arraylist найденными нодами
        ArrayList<Node> nodes = s_list.findAll(128);
        System.out.println("Список найденных значений: ");
        for(Node node : nodes) System.out.print(node.value + " "); System.out.println();

        // смотрим на длину списка
        System.out.println("Длина связного списка:");
        System.out.println(s_list.count());

        s_list.clear();
        s_list.add_in_tail(n1);

        // вставим _nodeToInsert после n5
        s_list.insertAfter(n1, _nodeToInsert);
        s_list.checkAll();
    }
}
