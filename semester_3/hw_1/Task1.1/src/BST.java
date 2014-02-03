import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BST<Key extends Comparable<Key>, Value> implements Iterable<Value> {

    public BST() {
        root = null;
    }

    public void add (Key key, Value value) {
        root = add(root, key, value);
    }

    private Node add(Node x, Key key, Value value) {
        if (x == null)
            return new Node(key, value);

        int cmp = key.compareTo(x.key);
        if(cmp <= 0)
            x.left = add(x.left, key, value);
        else
            x.right = add(x.right, key, value);
        return x;
    }

    public Value search(Key key){
        return search(root, key);
    }

    private Value search(Node x, Key key){
        if (x == null)
            return null;

        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x.value;
        else if (cmp < 0)
            return search(x.left, key);
        else
            return search(x.right, key);
    }

    public void remove(Key key) {
        root = remove(root, key);
    }

    private Node remove(Node x, Key key) {
        if (x == null)
            return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = remove(x.left, key);
        else if (cmp > 0)
            x.right = remove(x.right, key);
        else {
            if (x.left == null && x.right == null)
                return null;
            else if (x.left == null)
                return x.right;
            else if (x.right == null)
                return x.left;
            else {
                if (x.right.left == null) {
                    x.right.left = x.left;
                    return x.right;
                } else {
                    Key newKey = x.right.left.key;
                    Value newValue = x.right.left.value;
                    x.key = newKey;
                    x.value = newValue;
                    x.right = remove(x.right, newKey);
                }
            }
        }
        return x;
    }

    public String print() {
        String output = "";
        Iterator<Value> it = iterator();
        while (it.hasNext())
            output += it.next().toString() + " ";
        return output;
    }

    public void clear() {
        root = null;
    }

    @Override
    public Iterator<Value> iterator() {
        return new InOrderIterator();
    }

    private class Node {

        public Node(Key key, Value value) {
            this.left = null;
            this.right = null;
            this.key = key;
            this.value = value;
        }

        private Node left;
        private Node right;
        private Key key;
        private Value value;
    }

    private class InOrderIterator implements Iterator<Value> {

        public InOrderIterator() {
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
        public Value next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            toRemove = stack.peek().key;
            return stack.pop().value;
        }

        @Override
        public void remove() {
            if (toRemove == null)
                throw new IllegalStateException("Next method has not yet been called, or the remove method has already " +
                        "been called after the last call to the next method");
            BST.this.remove(toRemove);
            toRemove = null;
        }

        private void stackChildren(Node x) {
            Node next = x.right;
            if (next != null) {
                stackChildren(next);
            }
            stack.push(x);
            next = x.left;
            if (next != null) {
                stackChildren(next);
            }
        }

        private Stack<Node> stack = new Stack<>();
        private Key toRemove = null;
    }

    private Node root;
}