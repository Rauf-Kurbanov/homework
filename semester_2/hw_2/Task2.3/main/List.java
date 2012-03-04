/**
  *Написать список в виде класса
  */
package main;

public class List {

    int length = 0;
    private ListElement head;
    private ListElement tail = head;
    
    private class ListElement {

    private Object value;
    private ListElement next;
    
/**
 * element of list
 */    
    ListElement(Object value) {
        this.value = value;
        this.next = null;
    }
}

    public void add(Object value) {
        ListElement newEl = new ListElement(value);
        this.tail.next = newEl;
        this.tail = newEl;
        this.length++;
    }

    public void print() {
        ListElement temp = this.head;
        while (temp.next != null) {
            System.out.println(temp.next.value);
            temp = temp.next;
        }
    }

    public void clear() {
        this.head.next = null;
        this.tail = this.head;
        this.length = 0;
    }

    public boolean contains(int value) {
        ListElement temp = this.head;
        while (temp.next != null) {
            if (temp.next.value == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public Object get(int index) {
        ListElement temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.next.value;
    }

    public int indexOf(Object value) {
        ListElement temp = this.head;
        int i = 0;
        while (temp.next.value != value) {
            i++;
            temp = temp.next;
        }
        return i;
    }

    public boolean isEmpty() {
        return this.head.next == null;
    }

    public void remove(int value) {
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

    public void set(int index, int value) {
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
