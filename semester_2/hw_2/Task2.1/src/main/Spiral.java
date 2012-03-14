/*
 Дан массив размерностью N x N, N - нечетное число. Вывести элементы массива при обходе его по спирали, 
 начиная с центра
 */
package main;

public class Spiral {

    public static void main(String args[]) {
        Integer[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(matrixToLine(array));

    }

    /**
     * Prints the array elements when traversing it in a spiral from the center
     *
     * @param array
     */
    public static String matrixToLine(Integer[][] array) {
        Integer cent = array.length / 2; //index of matrix central element 
        StringBuilder result = new StringBuilder(array[cent][cent].toString());
        //System.out.print(array[cent][cent] + " "); //center

        for (int i = 1; i <= array.length / 2; i++) {
            for (int j = 0; j <= i; j++) {
                //System.out.print(array[cent - i + j][cent + i] + " "); //up -> down
                result.append(array[cent - i + j][cent + i].toString());
            }
            for (int j = 0; j <= i; j++) {
                //System.out.print(array[cent + i][cent + i - j] + " "); // right->left
                result.append(array[cent + i][cent + i - j].toString());
            }
            for (int j = 0; j <= i; j++) {
                //System.out.print(array[cent + i - j][cent - i] + " "); // down -> up
                result.append(array[cent + i - j][cent - i].toString());
            }
            for (int j = 0; j <= i; j++) {
                //System.out.print(array[cent - i][cent - i + j] + " "); // left -> right
                result.append(array[cent - i][cent - i + j]);
            }
        }
        return result.toString();
    }
}
