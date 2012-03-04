package main;

public class Factorial {
    public static void main(String[] args) {
        String reader = javax.swing.JOptionPane.showInputDialog(args);
        int num = Integer.parseInt(reader);
        System.out.println(factorial(num));
    }
    
    private static int factorial(int n) {
        if (n == 1)
            return 1;
        return n * factorial(n - 1);
    }
}