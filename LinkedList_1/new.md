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
   public boolean Remove(int _value)
    {
        Node node = this.head;
        Node preNode = node;
        // Что если список пустой?
        if(this.head == null)
        {
            return false;
        }
        else
        {
            while(node != null)
            {
                if (this.head.value == _value)
                    this.head = this.head.next;
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
        return false; // если узел был удалён
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


