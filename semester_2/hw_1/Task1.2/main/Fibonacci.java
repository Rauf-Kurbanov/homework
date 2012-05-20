package main;

import javax.swing.JOptionPane;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Enter fibonacci num");
        String reader = JOptionPane.showInputDialog(args);
        int num = Integer.parseInt(reader);
        System.out.println(fibonacci(num));
    }
    
    private static int fibonacci(int n) {
        if (n < 3)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    } 
}
