/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityqueue;

/**
 *
 * @author Author
 */
/**
 * This is an example of priority queue class. High priority items have low
 * 'prio' value, i.e. ("str1", 0) > ("str2", 1)
 *
 * @author Author
 * @param <T> type of queue element
 */
public class MyPriorityQueue<T> {

    private class QueueElement {

        /**
         * constructor
         */
        public QueueElement() {
        }

        /**
         * yet another constructor
         *
         * @param v value to add
         * @param p priority of this value
         */
        public QueueElement(T v, int p) {
            next = null;
            value = v;
            prio = p;
        }
        private T value;           // stored value
        private QueueElement next;  // next item
        private int prio;          // item priority
    }

    // constructor
    public MyPriorityQueue() {
        head = new QueueElement();  // create sentinel
    }

    // add item to queue
    public void enqueue(T val, int prio) {
        QueueElement l = head;
        while (l.next != null && l.next.prio < prio) {
            l = l.next;
        }
        QueueElement tmp = new QueueElement(val, prio);
        tmp.next = l.next;
        l.next = tmp;
    }

    /**
     * get item from queue with least priority
     *
     * @return item with least priority
     * @throws EmptyQueueException
     */
    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty!!!");
        }
        QueueElement tmp = head.next;
        head.next = tmp.next;
        return tmp.value;
    }

    /**
     * check, if the queue is empty.
     *
     * @return true if empty; false if not empty
     */
    public boolean isEmpty() {
        return (head.next == null);

    }
    private QueueElement head; // sentinel
}
