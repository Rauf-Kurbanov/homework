package tmp;

import parseTree.EmptyNodeException;

/**
 *
 * @author paRRadox
 */
public abstract class AbstractNode {
    
    public abstract float countExpression() throws EmptyNodeException;
    
    public abstract String printExpression () throws EmptyNodeException;
    
    protected AbstractNode left = null;
    protected AbstractNode right = null;
}
