package main;

public class StackTest {

    public static void main(String[] args) {
        LinkedStack stack1 = new LinkedStack();
        ArrayStack stack2 = new ArrayStack();
        fill(stack1);
        dump(stack1);
        check(stack1)
                ;
        fill(stack2);
        dump(stack2);
        check(stack2);
    }

    private static void fill(StackInterface stack) {
        for (int i = 0; i < 5; i++) {
            stack.push("el_" + i);
        }
    }

    private static void dump(StackInterface stack) {
        System.out.println("size = " + stack.size());
        while (!stack.isEmpty()) {
            System.out.println(stack.peek() + " " + stack.pop());
        }
    }

    private static void check(StackInterface stack) {
        if (stack.isEmpty()) {
            System.out.println("Empty");
        } else {
            System.out.println("Not empty");
        }
    }
}
