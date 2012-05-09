package parseTree;

/**
 *
 * @author paRRadox
 */
public interface ParseNode {
    
    public float countExpression() throws EmptyNodeException;
    
    public String printExpression () throws EmptyNodeException;
}
