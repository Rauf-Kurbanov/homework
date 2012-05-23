package main;

/**
 *
 * @author paRRadox
 */
public class NumNode extends ParseNode {

    @Override
    public float count() throws EmptyNodeException {
        if (value == null) {
            throw new EmptyNodeException();
        }
        return value;
    }

    @Override
    public String print() throws EmptyNodeException {
        if (value == null) {
            throw new EmptyNodeException();
        }
        return value.toString();
    }

    public NumNode(Integer value) {
        this.value = value;
    }
    private Integer value = null;
}
