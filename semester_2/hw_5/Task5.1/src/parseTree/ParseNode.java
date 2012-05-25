package parseTree;

/**
 *
 * @author paRRadox
 */
public abstract class ParseNode {
    
    public abstract String print();
    
    public abstract int calculate();
    
    protected ParseNode left;
    
    protected ParseNode right;
    
}
