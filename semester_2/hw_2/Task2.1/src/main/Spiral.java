/*
Дан массив размерностью N x N, N - нечетное число. Вывести элементы массива при обходе его по спирали, 
начиная с центра
*/
package main;

public class Spiral {

    public static void main(String args[]) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        spiralPrint(array);

    }

    /**
     * Prints the array elements when traversing it in a spiral from the center
     *
     * @param array
     */
    private static void spiralPrint(int[][] array) {
        int cent = array.length / 2;

        System.out.print(array[cent][cent] + " "); //center

        for (int i = 1; i <= array.length / 2; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(array[cent - i + j][cent + i] + " "); //up -> down
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(array[cent + i][cent + i - j] + " "); // right->left
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(array[cent + i - j][cent - i] + " "); // down -> up
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(array[cent - i][cent - i + j] + " "); // left -> right
            }
        }

    }
}
