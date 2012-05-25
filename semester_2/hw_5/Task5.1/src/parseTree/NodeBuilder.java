package parseTree;

/**
 *
 * @author paRRadox
 */
public class NodeBuilder {

    public void add(ParseNode subNode) {
        if (node == null) {
            node = subNode;
        } else if (node.left == null) {
            node.left = subNode;
        } else if (node.right == null) {
            node.right = subNode;
        }
    }

    public ParseNode value() {
        return node;
    }
    
    public NodeBuilder() {
        this.node = null;
    }
    
    private ParseNode node = null;
}
