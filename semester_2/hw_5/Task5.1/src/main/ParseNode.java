package main;

/**
 *
 * @author paRRadox
 */
public class ParseNode {
    
    public float countExpression() {
       
        if (value != null)
            return value;
        
        switch (operation)
	{
	case '+':
		return left.countExpression() + right.countExpression();
	case '-':
		return left.countExpression() - right.countExpression();
	case '*':
		return left.countExpression() * right.countExpression();
	case '/':
		return left.countExpression() / right.countExpression();
        default:
            return 0;
        }
    }
    
    public String printExpression() {
        String result = "";
        
        if (left != null) 
            result += "(";
        
        result += printNode();
        
        if (left != null) 
            result += left.printExpression();
        if (right != null) 
            result += right.printExpression();
        if (left != null)
            result += ")";
        
        return result;
    }

    public ParseNode(String input) {
        char[] inputArr = input.toCharArray();
    }

    private String printNode() {
        String result = "";

        if (value != null) {
            result += value.toString() + " ";
        } else if (operation != null) {
            result += operation + " ";
        }
        return result;
    }
    private Integer value = null;
    private Character operation = null;
    private ParseNode left = null;
    private ParseNode right = null;
}
