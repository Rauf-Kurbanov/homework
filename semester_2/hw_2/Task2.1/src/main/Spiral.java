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
     * @param array //matrix of numbers to write in line
     */
    public static String matrixToLine(Integer[][] array) {
        Integer cent = array.length / 2; //index of matrix central element 
        StringBuilder result = new StringBuilder(array[cent][cent].toString());

        for (int i = 1; i <= array.length / 2; i++) {
            for (int j = 0; j <= i; j++) {
                result.append(array[cent - i + j][cent + i].toString());
            }
            for (int j = 0; j <= i; j++) {
                result.append(array[cent + i][cent + i - j].toString());
            }
            for (int j = 0; j <= i; j++) {
                result.append(array[cent + i - j][cent - i].toString());
            }
            for (int j = 0; j <= i; j++) {
                result.append(array[cent - i][cent - i + j]);
            }
        }
        return result.toString();
    }
}
