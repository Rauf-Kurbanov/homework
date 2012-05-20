package main;

public final class LinkedStack extends AbstractStack {

    private Node head;

    private static class Node {

        private Object value;
        private Node next;

        private Node(Node next, Object value) {
            this.next = next;
            this.value = value;
        }
    }

    @Override
    public void push(Object value) {  
        size++;
        head = new Node(head, value);
    }

    @Override
    public Object pop() {
        size--;
        if (head == null) {
            return null;
        }
        Object value = head.value;
        head = head.next;
        return value;
    }
    
    @Override
    public Object peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }
}
