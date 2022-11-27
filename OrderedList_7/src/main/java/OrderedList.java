import java.util.*;


class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
        final String INTEGER = "Integer";
        final String FLOAT = "Float";
        final String DOUBLE = "Double";
        final String STRING = "String";

        if(((v1.getClass().getTypeName().endsWith(INTEGER)) && (v2.getClass().getTypeName().endsWith(INTEGER))
        ) && ((int)v1 < (int)v2)
        ) return -1;

        if(((v1.getClass().getTypeName().endsWith(INTEGER)) && (v2.getClass().getTypeName().endsWith(INTEGER))
        ) && ((int)v1 == (int)v2)
        ) return 0;

        if(((v1.getClass().getTypeName().endsWith(INTEGER)) && (v2.getClass().getTypeName().endsWith(INTEGER))
        ) && ((int)v1 > (int)v2)
        ) return 1;

        if(((v1.getClass().getTypeName().endsWith(FLOAT) || v1.getClass().getTypeName().endsWith(DOUBLE)) &&
                (v2.getClass().getTypeName().endsWith(FLOAT) || v2.getClass().getTypeName().endsWith(DOUBLE))
        ) && ((double)v1 < (double)v2)
        ) return -1;

        if(((v1.getClass().getTypeName().endsWith(FLOAT) || v1.getClass().getTypeName().endsWith(DOUBLE)) &&
                (v2.getClass().getTypeName().endsWith(FLOAT) || v2.getClass().getTypeName().endsWith(DOUBLE))
        ) && ((double)v1 == (double)v2)
        ) return 0;

        if(((v1.getClass().getTypeName().endsWith(FLOAT) || v1.getClass().getTypeName().endsWith(DOUBLE)) &&
                (v2.getClass().getTypeName().endsWith(FLOAT) || v2.getClass().getTypeName().endsWith(DOUBLE))
        ) && ((double)v1 > (double)v2)
        ) return 1;

        if(v1.getClass().getTypeName().endsWith(STRING) && v2.getClass().getTypeName().endsWith(STRING))
        {
            String s1 = "";
            String s2 = "";
            s1 = (String) v1;
            s2 = (String) v2;
            s1 = s1.trim();
            s2 = s2.trim();

            int res = s1.compareTo(s2);

            if(res > 0) return 1;
            if(res == 0) return 0;
            return -1;
        }
        return 0;
    }

    public void add(T value)
    {
        if(this.head == null)
        {
            this.head = new Node<T>(value);
            this.tail = this.head;
            this.head.next = null;
            this.head.prev = null;
            return;
        }

        if(_ascending == true && (compare(value, head.value) == -1 || compare(value, head.value) == 0))
        {
            Node <T> nodeToInsert = new Node<T>(value);

            nodeToInsert.next = this.head;
            this.head.prev = nodeToInsert;
            this.head = nodeToInsert;
            return;
        }

        if(_ascending == true && (compare(value, tail.value) == 1 || compare(value, tail.value) == 0))
        {
            Node <T> nodeToInsert = new Node<>(value);

            this.tail.next = nodeToInsert;
            nodeToInsert.prev = this.tail;
            this.tail = nodeToInsert;
            return;
        }

        if(_ascending == true && compare(value, head.value) == 1 && compare(value, tail.value) == -1)
        {
            Node <T> nodeAfter = this.head;
            Node <T> nodeToInsert = new Node<>(value);

            while (nodeAfter.next != null)
            {
                if(compare(value, nodeAfter.value) == 0 || (compare(value, nodeAfter.value) == 1
                        && compare(value, nodeAfter.next.value) == -1))
                {
                    nodeAfter.next.prev = nodeToInsert;
                    nodeToInsert.prev = nodeAfter;
                    nodeToInsert.next = nodeAfter.next;
                    nodeAfter.next = nodeToInsert;
                    break;
                }
                nodeAfter = nodeAfter.next;
            }
        }

        if(_ascending == false && (compare(value, head.value) == 1 || compare(value, head.value) == 0))
        {
            Node <T> nodeToInsert = new Node<>(value);

            nodeToInsert.next = this.head;
            this.head.prev = nodeToInsert;
            this.head = nodeToInsert;
            return;
        }

        if(_ascending == false && (compare(value, tail.value) == -1 || compare(value, tail.value) == 0))
        {
            Node <T> nodeToInsert = new Node<>(value);

            this.tail.next = nodeToInsert;
            nodeToInsert.prev = this.tail;
            this.tail = nodeToInsert;
            return;
        }

        if(_ascending == false && compare(value, head.value) == -1 && compare(value, tail.value) == 1)
        {
            Node <T> nodeAfter = this.head;
            Node <T> nodeToInsert = new Node<>(value);

            while (nodeAfter.next != null)
            {
                if(compare(value, nodeAfter.value) == 0 || (compare(value, nodeAfter.value) == -1
                        && compare(value, nodeAfter.next.value) == 1))
                {
                    nodeAfter.next.prev = nodeToInsert;
                    nodeToInsert.prev = nodeAfter;
                    nodeToInsert.next = nodeAfter.next;
                    nodeAfter.next = nodeToInsert;
                    break;
                }

                nodeAfter = nodeAfter.next;
            }
        }
    }

    public Node<T> find(T val)
    {
        if(this.head == null)
            return null;

        if(compare(val, this.head.value) == 0)
            return this.head;

        if(this.head.next != null && compare(val, this.tail.value) == 0)
            return this.tail;

        if(_ascending == true && compare(val, this.head.value) == -1)
            return null;

        if(_ascending == true && compare(val, this.head.value) == 1 && compare(val, this.tail.value) == -1)
        {
            Node <T> node = this.head;
            while (node.next != null)
            {
                if(compare(val, node.value) == -1)
                    return null;

                if(compare(val, node.value) == 0)
                    return node;

                node = node.next;
            }
        }

        if(_ascending == false && compare(val, this.head.value) == 1)
            return null;

        if(_ascending == false && compare(val, this.head.value) == -1 && compare(val, this.tail.value) == 1)
        {
            Node <T> node = this.head;
            while (node.next != null)
            {
                if(compare(val, node.value) == 1)
                    return null;

                if(compare(val, node.value) == 0)
                    return node;

                node = node.next;
            }
        }
        return null;
    }

    public void delete(T val)
    {
        if (this.head == null)
            return;

        if (this.head.value == val && this.head.next != null) {
            this.head.next.prev = null;
            this.head = this.head.next;
            this.head.prev = null;
            return;
        } else if (this.head.value == val && this.head.next == null) {
            this.head = null;
            this.tail = null;
            return;
        }

        Node <T> node = this.head;
        while (node.next != null) {
            if (node.value == val) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                return;
            }
            node = node.next;
        }
        if (node.value == val) {
            tail = node.prev;
            tail.next = null;
            node.prev = null;
        }
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        if (this.head != null) {
            Node <T> node = this.head;

            while (node != null) {
                this.head.next = null;
                head = node;
                node = node.next;
            }
            head = null;
            tail = null;
        }
    }

    public int count()
    {
        Node <T> node = this.head;
        int count = 0;
        if (this.head == null) {
            return 0;
        } else {
            while (node != null) {
                count++;
                node = node.next;
            }
        }
        return count;
    }

    ArrayList<Node<T>> getAll()
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}