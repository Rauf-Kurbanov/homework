package main;

import java.io.*;

/**
 *
 * @author paRRadox
 */
public class ParseTree {

    public ParseTree(File file) {
        BufferedReader input;
        try {
            input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            root = new OperNode(input.readLine());
        } catch (IOException e) {
            e.getMessage();
        }
    }
    
    public float count() throws EmptyNodeException {
        return root.count();
    }
    
    public String print() throws EmptyNodeException {
        return root.print();
    }
    
    private OperNode root;
}
