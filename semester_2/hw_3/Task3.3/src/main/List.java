package main;

public class List {

    int length = 0;
    private ListElement head;
    private ListElement tail = head;

    /**
     * Element of list
     */
    private class ListElement {

        private Object value;
        private ListElement next;

        ListElement(Object value) {
            this.value = value;
            this.next = null;
        }
    }

    /**
     * Appends the specified element to the end of this list
     *
     * @param value // value of added element
     */
    public void add(Object value) {
        ListElement newEl = new ListElement(value);
        this.tail.next = newEl;
        this.tail = newEl;
        this.length++;
    }

    /**
     * Prints this list
     */
    public void print() {
        ListElement temp = this.head;
        while (temp.next != null) {
            System.out.println(temp.next.value);
            temp = temp.next;
        }
    }

    /**
     * Removes all of the elements from this list
     */
    public void clear() {
        this.head.next = null;
        this.tail = this.head;
        this.length = 0;
    }

    /**
     * Returns true if this list contains all of the elements of the specified
     * collection
     *
     * @param value //value of this element
     * @return //true if this list contains all of the elements of the specified
     * collection
     */
    public boolean isContains(Object value) {
        ListElement temp = this.head;
        while (temp.next != null) {
            if (temp.next.value == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * Returns the element at the specified position in this list
     *
     * @param index // index of list element
     * @return // value of this element
     */
    public Object get(int index) {
        if (index >= this.length) {
            return null;
        }
        ListElement temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.next.value;
    }

    /**
     * Returns the index in this list of the first occurrence of the specified
     * element, or -1 if this list does not contain this element
     *
     * @param value //
     * @return //the index in this list of the first occurrence of the specified
     * element, or -1 if this list does not contain this element
     */
    public int indexOf(Object value) {
        ListElement temp = this.head;
        int i = 0;
        while (temp.next != null) {
            if (temp.next.value == value) {
                return i;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }

    /**
     * Returns true if this list is empty
     *
     * @return //true if this list is empty 
     */
    public boolean isEmpty() {
        return this.head.next == null;
    }

    /**
     * Removes the first occurrence in this list of the specified element
     *
     * @param value //value of this element
     */
    public void remove(Object value) {
        ListElement temp = this.head;
        while (temp.next != null) {
            if (temp.next.value == value) {
                temp.next = temp.next.next;
                this.length--;
                return;
            }
            temp = temp.next;
        }
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index //index there element will be replaced. If index is more
     * than list length element won't be replaced.
     * @param value //value of this element
     */
    public void set(int index, Object value) {
        if (index > this.length) {
            return;
        }
        ListElement temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        ListElement newEl = new ListElement(value);
        newEl.next = temp.next;
        temp.next = newEl;
        this.length++;
    }

    List() {
        this.length = 0;
        ListElement guard = new ListElement(0);
        guard.next = null;
        this.head = guard;
        this.tail = guard;
    }
}
