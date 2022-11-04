// 1. Добавьте в класс LinkedList метод удаления одного узла по его значению. ОК
    public boolean Remove(int _value)
    {
        Node node = this.head;
        Node preNode = node;
        // Что если список пустой?
        if(this.head == null)
        {
            return false;
        }
        // Что если искомое значение в head?
        else if (this.head.value == _value)
        {
            this.head = this.head.next;
            return true;
        }
        else
        {
            while(node != null)
            {
                if(node.value != _value)
                {
                    preNode = node;
                    node = node.next;
                }
                else
                {
                    preNode.next = node.next;
                    node = null;
                    return true;
                }
            }
        }
        return false; // если узел был удалён
    }

***этот метод удалит несколько элементов***
   public void removeAll(int _value)
    {
        Node node = this.head;
        Node preNode = node;
        while(node != null)
        {
            if (this.head.value == _value && this.head.next != null)
                this.head = this.head.next;
            else if(node.value == _value && this.head.next == null)
            {
                this.head = null;
                break;
            }
            else if(node.value != _value)
            {
                preNode = node;
                node = node.next;
            }
            else
            {
                preNode.next = node.next;
                node = preNode.next;
            }
        }
    }

***метод очистки списка***
public void clear()
    {
        Node preNode = this.head;

        while (this.head != null) {
            preNode = this.head;
            this.head = head.next;
            preNode = null;
        }
    }

***метод составления списка на основе найденных значений***
// 4. Добавьте в класс LinkedList метод поиска всех узлов по конкретному значению
    // (возвращается список/массив найденных узлов).
    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head; // Установили ноду в начало
        while(node != null) // проход всех элементов списка
        {
            if(node.value == _value)
            {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

***метод поиска длины списка***
//5. Добавьте в класс LinkedList метод вычисления длины списка.
    public int count()
    {
        Node node = this.head; // устанавливаем узел в начало списка
        int count = 0;
        if(this.head == null) // если список пустой
        {
            return 0;
        }
        else
        {
            while(node != null)
            {
                count++;
                node = node.next;
            }
        }
        return count;
    }

***метод вставляет некий узел после указанного узла***
 /*
    6. Добавьте в класс LinkedList метод вставки нового узла после заданного узла.
    Например, имеется список (a1,a2,a3,a4,a5) и новый узел a7;
    вставляя узел a7 после узла a3, получаем список (a1,a2,a3,a7,a4,a5).
    */
    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
     Node node = this.head;
     // Если изначально список пустой
        if (this.head == null)
        {
            this.head = _nodeToInsert;
            _nodeToInsert.next = null;
        }
        else
        {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
        }
        // здесь будет ваш код вставки узла после заданного

        // если _nodeAfter = null ,
        // добавьте новый элемент первым в списке
    }
