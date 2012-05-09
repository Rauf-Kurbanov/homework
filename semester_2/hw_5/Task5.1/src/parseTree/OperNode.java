package parseTree;

import java.io.*;

/**
 *
 * @author paRRadox
 */
public class OperNode extends AbstractNode {
    
    @Override
    public float countExpression() throws EmptyNodeException{
        if (operation == null)
            throw new EmptyNodeException();
        
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
            return 0; /// <-- доделать
        }
    }
    
    @Override
    public String printExpression() throws EmptyNodeException{
        String result = "";
        
        if (operation == null)
            throw new EmptyNodeException();
        
        if (left != null) 
            result += "(";
        
        result += operation;
        
        if (left != null) 
            result += left.printExpression();
        if (right != null) 
            result += right.printExpression();
        if (left != null)
            result += ")";
        
        return result;
    }
    
    /*
     * char ch = 0;
	int num = 0;
	Node *parseTree = NULL;
	Node *subTree = NULL;

	while (fscanf(stream, "%c", &ch) != -1)
	{
		if (ch == ' ')
			continue;
		else if (ch == ')')
			return parseTree;
		else if (ch == '(')
			addParseTree(buildTree(stream), parseTree);
		else
			if (ch >= '0' && ch <= '9')
			{
				ungetc(ch, stream);
				ch = NULL;
				(fscanf(stream, "%d", &num));
				subTree = createParseTree(num, ch);
				addParseTree(subTree, parseTree);
			}
			else
			{
				num = NULL;
				subTree = createParseTree(num, ch);
				addParseTree(subTree, parseTree);
			}	
	}
	return parseTree;
     */
    
    
    
    /*fail*/public OperNode(Reader in) throws IOException {
        Reader reader = new PushbackReader(in);
        try {
            int c = 0;
            while ((c = reader.read()) >= 0) {
 
            }
            reader.close();
        } catch (IOException e) {  // there is so difficult construction because .close() can also throw IOException
            try {
                reader.close();
            } catch (IOException ee) {} // ignoring
            throw e;
        }
    }
    
    
    private void copy(AbstractNode node) {
        this.operation = node.getValue();
        this.left = node.left;
        this.right = node.right;
    }
    
    private void addNode(AbstractNode subNode) {
        if (operation == null) {
           copy(subNode);
        } else if (left == null) {
            left = subNode.left;
        } else if (right == null) {
            right = subNode.right;
        } else {
            System.err.println("Adding error"); /// <-- доделать
        }
    }
    
    public OperNode(char operation) {
        this.operation = operation;
    }
    
    @Override
    protected Character getValue() {
        return operation;
    }
    
    private Character operation;
}
