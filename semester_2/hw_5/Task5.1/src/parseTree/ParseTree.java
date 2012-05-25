package parseTree;

import java.io.*;

/**
 *
 * @author paRRadox
 */
public class ParseTree {

    public String print() {
        return root.print();
    }

    public int calculate() {
        return root.calculate();
    }

    public ParseTree(File file) {
        BufferedReader buffer;
        try {
            buffer = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            this.input = buffer.readLine();
            this.root = build();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private ParseNode build() {
        NodeBuilder subTree = new NodeBuilder();

        while (!input.isEmpty()) {
            int pos = 0;
            String token = "";
            while (isNum(input.charAt(pos))) {
                token += input.charAt(pos);
                ++pos;
            }
            if (!token.isEmpty()) {
                input = input.substring(pos);
                subTree.add(new NumNode(Integer.parseInt(token)));
            }

            switch (input.charAt(0)) {
                case ' ':
                    input = input.substring(1);
                    break;
                case '(':
                    input = input.substring(1);
                    subTree.add(build());
                    break;
                case ')':
                    input = input.substring(1);
                    return subTree.value();
                default:
                    if (!isNum(input.charAt(0))) {
                        char operation = input.charAt(0);
                        input = input.substring(1);
                        subTree.add(new OperNode(operation));
                    }
            }
        }
        return subTree.value();
    }

    private boolean isNum(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        } else {
            return false;
        }
    }
    private String input = "";
    private ParseNode root = null;
}
