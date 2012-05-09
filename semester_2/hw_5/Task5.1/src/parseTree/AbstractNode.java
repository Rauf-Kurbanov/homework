package parseTree;

/**
 *
 * @author paRRadox
 */
public abstract class AbstractNode implements ParseNode {
    
    abstract protected Character getValue();
    
    protected ParseNode left = null;
    protected ParseNode right = null;
}
