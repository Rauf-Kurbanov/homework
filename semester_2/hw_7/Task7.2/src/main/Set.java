package main;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author paRRadox
 */
public class Set<E> {

    /**
     * Adds value to the set
     *
     * @param value value to add
     */
    public void add(E value) {
        if (!contains(value)) {
            SetElement newEl = new SetElement(value);
            tail.next = newEl;
            tail = newEl;
        }
    }

    /**
     * Removes the value from the set
     *
     * @param value value to remove
     */
    public void remove(E value) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (it.next() == value) {
                it.remove();
                return;
            }
        }
    }
    
    /**
     * Returns true if this list contains this value
     *
     * @param value value to check
     * @return true if this list contains this value else returnes false
     */
    public boolean contains(E value) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (it.next() == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets union of sets
     *
     * @param set set to unite with this set
     * @return union of sets
     */
    public Set<E> union(Set<E> s) {
        Set<E> result = new Set<E>();
        Iterator<E> itt = s.iterator();
        while (itt.hasNext()) {
            E currValue = itt.next();
            if (s.contains(currValue)) {
                result.add(currValue);
            }
        }
        
        Iterator<E> it = iterator();
        while(it.hasNext()) {
            result.add(it.next());
        }
        return result;
    }

    /**
     * Gets intersection of sets
     *
     * @param set set to intersect with this set
     * @return intersection of sets
     */
    public Set<E> intersection(Set<E> s) {
        Set<E> result = new Set<>();
        
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            E currValue = it.next();
            if (s.contains(currValue)) {
                result.add(currValue);
            }
        }
        return result;
    }

    /**
     * Prints this set
     *
     * @return string to print
     */
    public String print() {
        String result = "";
        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            result += it.next().toString() + " ";
        }
        return result;
    }

    public Set() {
        SetElement guard = new SetElement(0);
        guard.next = null;
        this.head = guard;
        this.tail = guard;
    }

    /**
     * Element of set
     *
     * @param <E> element type
     */
    private class SetElement<E> {

        private E value;
        private SetElement<E> next;

        SetElement(E value) {
            this.value = value;
            this.next = null;
        }
    }

    /**
     * iterator for this set
     */
    public class SetIterator implements Iterator<E> {

        public SetIterator() {
            SetElement beforeHead = new SetElement(0);
            beforeHead.next = head;
            this.preCurrent = beforeHead;
        }

        @Override
        public boolean hasNext() {
            if (preCurrent.next == null) {
                return false;
            } else {
                return (preCurrent.next.next != null);
            }
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            } else {
                preCurrent = preCurrent.next;
                //now preCurrent becomes current element
                return preCurrent.next.value;
            }
        }

        @Override
        public void remove() {
            if (hasNext()) {
                preCurrent.next = preCurrent.next.next;
            }
        }
        //previous for current element
        private SetElement<E> preCurrent;
    }

    public Iterator<E> iterator() {
        return new SetIterator();
    }
    private SetElement<E> head;
    private SetElement<E> tail = head;
}
