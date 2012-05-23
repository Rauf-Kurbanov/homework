package main;

/**
 *
 * @author paRRadox
 */
public class OperNode extends ParseNode {

    @Override
    public float count() throws EmptyNodeException {
        if (operation == null) {
            throw new EmptyNodeException();
        }

        switch (operation) {
            case "+":
                return left.count() + right.count();
            case "-":
                return left.count() - right.count();
            case "*":
                return left.count() * right.count();
            case "/":
                return left.count() / right.count();
            default:
                return 0;
        }
    }

    @Override
    public String print() throws EmptyNodeException {
        if (operation == null) {
            throw new EmptyNodeException();
        }

        String result = "";

        if (left != null) 
            result.concat("(");
        result.concat(print());
        if (left != null) 
            result.concat(left.print());
        if (right != null)
            result.concat(right.print());
        if (left != null) 
            result.concat(") ");
        
        return result;
    }

    public OperNode(String inpStr) {
        init(inpStr);
    }

    private void init(String inpStr) {

        String token = inpStr.substring(1, 2);

        switch (token) {
            case "(":
                init(inpStr.substring(1, inpStr.indexOf(")")));
                init(inpStr.substring(inpStr.indexOf(")")));
                return;
            case " ":
                break;
            case ")":
                break;
            default:
                try {
                    Integer value = Integer.parseInt(token);
                    add(value);
                } catch (NumberFormatException e) {
                    add(inpStr);
                }
        }
        init(inpStr.substring(1));
    }

    private void add(String inpStr) {
        if (operation == null) {
            operation = inpStr.substring(1, 2);
        } else if (left == null) {
            left = new OperNode(inpStr.substring(1));
        } else if (right == null) {
            right = new OperNode(inpStr.substring(1)); //<-- тут уже как хочешь
        }
    }

    private void add(Integer value) {
        if (left == null) {
            left = new NumNode(value);
        } else {
        }
    }
    private String operation = null;
}
