package stack;

public class LinkedStack<T> implements Stack<T> {

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(T value) {
        size++;
        head = new LinkedStack.Node(head, value);
    }

    @Override
    public T pop() {
        size--;
        if (head == null) {
            return null;
        }
        T value = head.value;
        head = head.next;
        return value;
    }

    @Override
    public T peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }
    
    /**
     * Node of this Stack
     * @param <T> element type
     */
    private static class Node<T> {

        private T value;
        private Node<T> next;

        private Node(LinkedStack.Node next, T value) {
            this.next = next;
            this.value = value;
        }
    }
    private int size = 0;
    private Node<T> head;
}
