package main;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BST<T extends Comparable<T>> implements Iterable<T> {

    public BST() {
        this.root = new Node(null);
    }

    public void add(T value) {
        this.root.add(value);
    }

    public String print() {
        String output = "";
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            output += it.next().toString() + " ";
        }
        return output;
    }

    @Override
    public Iterator<T> iterator() {
        return new PostOrderIterator();
    }

    private class Node {

        public Node(T value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }

        public void add(T value) {
            if (this.isEmpty()) {
                this.value = value;
                return;
            }
            if (value.compareTo(this.value) <= 0) {
                if (left == null) {
                    left = new Node(value);
                } else {
                    left.add(value);
                }
            } else {
                if (right == null) {
                    right = new Node(value);
                } else {
                    right.add(value);
                }
            }
        }

        public boolean isEmpty() {
            return value == null;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public String print() {
            String output = "";
            if (!left.isEmpty()) {
                output += left.print();
            }
            output += value.toString();
            if (!right.isEmpty()) {
                output += right.print();
            }
            return output;
        }
        private Node left;
        private Node right;
        private T value;
    }

    private class PostOrderIterator implements Iterator<T> {

        public PostOrderIterator() {
            if (root != null) {
                stack.clear();
                stackChildren(root);
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return stack.pop().value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Can not remove from a binary tree");
        }

        private void stackChildren(Node node) {
            Node next = node.getRight();
            if (next != null) {
                stackChildren(next);
            }
            stack.push(node);
            next = node.getLeft();
            if (next != null) {
                stackChildren(next);
            }
        }
        private Stack<Node> stack = new Stack<>();
    }
    private Node root;
}
