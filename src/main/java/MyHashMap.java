public class MyHashMap {
    private class Node {
        Object key;
        Object value;
        Node next;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] table;
    private int size;

    public MyHashMap() {
        table = new Node[16];
        size = 0;
    }

    public void put(Object key, Object value) {
        int index = key.hashCode() % table.length;
        Node newNode = new Node(key, value);
        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node current = table[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            newNode.next = table[index];
            table[index] = newNode;
        }
        size++;
    }

    public void remove(Object key) {
        int index = key.hashCode() % table.length;
        Node current = table[index];
        Node previous = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public void clear() {
        table = new Node[16];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int index = key.hashCode() % table.length;
        Node current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
}
