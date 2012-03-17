package main;

public abstract class AbstractStack implements StackInterface {

    protected int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
