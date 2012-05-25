package parseTree;

/**
 *
 * @author paRRadox
 */
public class NumNode extends ParseNode {

    @Override
    public String print() {
        return value.toString();
    }

    @Override
    public int calculate() {
        return value;
    }

    public NumNode(Integer value) {
        this.value = value;
    }
    private Integer value;
}
