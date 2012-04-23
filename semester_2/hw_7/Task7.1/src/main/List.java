package main;

import java.util.Iterator;
import java.lang.NullPointerException;
import java.lang.IndexOutOfBoundsException;

/**
 *
 * @author paRRadox
 */
public class List<T> implements Iterable {

    List() {
        this.length = 0;
        ListElement guard = new ListElement(0);
        guard.next = null;
        this.head = guard;
        this.tail = guard;
    }

    /**
     * Appends the specified element to the end of this list
     *
     * @param value // value of added element
     */
    public void add(T value) {
        ListElement newEl = new ListElement(value);
        this.tail.next = newEl;
        this.tail = newEl;
        this.length++;
    }

    /**
     * Prints this list
     */
    public void print() {
        Iterator<T> listIt = iterator();
        while (listIt.hasNext()) {
            System.out.println(listIt.next());
        }
    }

    /**
     * Removes all of the elements from this list
     */
    public void clear() {
        head.next = null;
        tail = this.head;
        length = 0;
    }

    /**
     * Returns true if this list contains all of the elements of the specified
     * collection
     *
     * @param value //value of this element
     * @return //true if this list contains all of the elements of the specified
     * collection
     */
    public boolean contains(T value) {
        Iterator<T> listIt = iterator();
        while (listIt.hasNext()) {
            if (listIt.next() == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if this list is empty
     *
     * @return //true if this list is empty
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Removes the first occurrence in this list of the specified element
     *
     * @param value //value of this element
     */
    public void remove(T value) {
        Iterator<T> listIt = iterator();
        while (listIt.hasNext()) {
            if (listIt.next() == value) {
                listIt.remove();
                return;
            }
        }
    }

    /**
     * Element of list
     */
    private class ListElement<T> {

        private T value;
        private ListElement<T> next;

        ListElement(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private class ListIterator implements Iterator<T> {

        public ListIterator() {
            this.preCurrent = head;
        }

        @Override
        public boolean hasNext() {
            if (preCurrent.next == null) {
                throw new NullPointerException();
            } else {
                return (preCurrent.next.next != null);
            }
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            } else {
                preCurrent = preCurrent.next;
                //now preCurrent become current element
                return preCurrent.next.value;
            }
        }

        @Override
        public void remove() {
            if (hasNext()) {
                preCurrent.next = preCurrent.next.next;
                length--;
            }
        }
        //previous for current element
        private ListElement<T> preCurrent;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }
    private int length = 0;
    private ListElement<T> head;
    private ListElement<T> tail = head;
}
