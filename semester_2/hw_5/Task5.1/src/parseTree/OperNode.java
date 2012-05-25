package parseTree;

/**
 *
 * @author paRRadox
 */
public class OperNode extends ParseNode {

    @Override
    public String print() {
        String result = "";

        if (left != null) 
            result += "(";
        result += operation.toString() + " ";
        if (left != null) 
            result += left.print() + " ";
        if (right != null)
            result += right.print();
        if (left != null) 
            result += ")";
        
        return result;
    }

    @Override
    public int calculate() {
        switch (operation) {
            case '+':
                return left.calculate() + right.calculate();
            case '-':
                return left.calculate() - right.calculate();
            case '*':
                return left.calculate() * right.calculate();
            case '/':
                return left.calculate() / right.calculate();
        }
        return 0;
    }

    public OperNode(char operation) {
        this.operation = operation;
    }
    private Character operation;
}
