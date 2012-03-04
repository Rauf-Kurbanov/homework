package main;

import javax.swing.JOptionPane;

public class TestList {

    public static void main(String[] args) {
        List myList = new List();

        check(myList);

        for (int i = 0; i < 5; i++) {
            String reader = JOptionPane.showInputDialog(args);
            int num = Integer.parseInt(reader);
            myList.add(num);
        }
        myList.set(3, 100500);
        myList.print();
        System.out.println();
        if (myList.contains(3)) {
            System.out.println(myList.indexOf(3));
        }
        myList.remove(3);
        System.out.println(myList.get(3));

        check(myList);
        myList.clear();
        check(myList);
    }

    private static void check(List myList) {
        if (myList.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println("not empty");
        }
    }
}
