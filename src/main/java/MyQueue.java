public class MyQueue {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }
    }

    public MyQueue() {
        size = 0;
    }

    public void add(Object value) {
        Node newNode = new Node(value);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = tail;
        }
        size++;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.value;
    }

    public Object poll() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty");
        }
        Object value = head.value;
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }
        return value;
    }
}