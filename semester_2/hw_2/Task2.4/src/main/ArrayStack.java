package main;

public final class ArrayStack extends AbstractStack {

    private Object elements[] = new Object[0];

    @Override
    public void push(Object value) {
        ensureCapacity(size + 1);
        elements[size++] = value;
    }

    @Override
    public Object pop() {
        if (size == 0) {
            return null;
        }
        return elements[--size];
    }

    @Override
    public Object peek() {
        if (size == 0) {
            return null;
        }
        return elements[size - 1];
    }

    private void ensureCapacity(int capacity) {
        if (elements.length >= capacity) {
            return;
        }
        Object[] newElements = new Object[capacity * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }
}
