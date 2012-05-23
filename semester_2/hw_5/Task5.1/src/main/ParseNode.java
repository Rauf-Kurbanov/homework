package main;

/**
 *
 * @author paRRadox
 */
public abstract class ParseNode {
    
    public abstract float count() throws EmptyNodeException;
    
    public abstract String print () throws EmptyNodeException;
    
    protected ParseNode left = null;
    
    protected ParseNode right = null;
}
