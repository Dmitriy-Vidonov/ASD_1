package Additional_Tests;

public class LinkedList<T> {
    // внутри нашего LinkedList мы будем хранить ссылку только на голову
    private Node<T> head;

    // 1-й метод - добавление первого элемента
    public void addFirst(T t) {
        Node<T> firstNode = new Node<>(t); // создаем первый узел
        firstNode.next = head;
        head = firstNode;
    }

    // 2-й метод - добавление последнего элемента
    public void addLast(T t) {
        if (head == null) { // в первую очередь проверяем, что наш LinkedList не пустой
            head = new Node<>(t);
            return;
        }
        // если этого не произошло и LInkedList был не пустой
        Node<T> currentNode = head; // чтобы у нас была возможность пробежаться по элементам LinkedList
        // пробегаемся по элементам нашего списка
        while (currentNode.next != null) {
            currentNode = currentNode.next; // проходимся по всем элементам списка
        }
        currentNode.next = new Node<>(t); // в currentNode.next передаем новый элемент. Так мы добавили элемент в хвост
    }

    // метод для поиска элемента по значению
    public int get(T t) {
        if(head == null) { // если наш список пуст
            return -1; // вернули -1, говоря о том, что такого элемента у нас нет
        }

        if(head == t) { // если элемент head содержит значение, которое мы ищем, вернем 0 как индекс найденного эл-та
            return 0;
        }

        // если этого не произошло, то мы создаем новый узел
        Node<T> currentNode = head; // задали новый узел и установились в начало
        int result = 0;
        while (currentNode.next != null) { // снова цикл по нашему списку
            ++result; // ++n - увеличивает рез-тат и возвращает новый. n++ - увелич. рез-тат и возвращает старый
            if(currentNode.next.value == t) // если значение равно искомому
                return result;
            // если этого не произошло, мы передвигаем свой указатель
            currentNode = currentNode.next;
        }
        return -1; // возвращаем псевдоиндекс нашего элемента или -1, если элемент не найден
    }

    // метод удаления элемента по значению
    public void remove(T t) {
        if(head == null) { // если наш LinkedList пуст, то мы возвращаемся из метода обратно
            return;
        }

        if(head.value == t) { // если head = нашему искомому значению
            head = head.next; // в head помещаем переменную next. выкидываем как бы полностью текущее значение из списка
            return;
        }

        // если этого не произошло, то опять создаем наш currentNode, который равен главному узлу
        Node<T> currentNode = head;
        while (currentNode.next != null) {
            if(currentNode.next.value == t) {
                currentNode.next = currentNode.next.next; // передвигаем указатель next на следующий элемент
                return;
            }
            currentNode = currentNode.next;
        }
    }

    @Override // переопределим метод toString в классе LinkedList для наглядности
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                '}';
    }

    private static class Node<T> { // <T> это дженерик для хранения разных типов данных
        private final T value; // данный класс содержит в себе элемент value любого типа
        private Node<T> next; // ссылка на следующий узел Node любого типа

        public Node (T value){
            this.value = value;
        }

        @Override // переопределим метод toString в классе Node для наглядности
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
