package main;

public class Sort {
    public static void main(String[] args) {
        int []array = {5,4,3,2,1};
        bubbleSort(array);
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }
    
    private static void swap(int[] arr, int i, int j) {
         int t = arr[i];
         arr[i] = arr[j];
         arr[j] = t;
    }
    
    private static void bubbleSort(int[] array) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < array.length - 1; i++)
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    flag = true;
                }
        }
    }
}
