package tmp;

/**
 *
 * @author paRRadox
 */
public class ValueNode extends AbstractNode {
    
    @Override
    public float countExpression() throws EmptyNodeException{
        if (value == null)
            throw new EmptyNodeException();
        
        return value;
    }
    
    @Override
    public String printExpression() throws EmptyNodeException{
         if (value == null)
            throw new EmptyNodeException();
         
        return value.toString();
    }
    
    public ValueNode(int value) {
        this.value = value;
    }
    
    private Integer value;
}
