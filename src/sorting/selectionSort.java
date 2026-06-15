package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class selectionSort {

    public static void main(String[] args){
        int[] arr = new int[5];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 5 elements");
        for(int i = 0; i<5; i++){
            System.out.print("Enter element " + (i+1) + ": ");
            arr[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(arr));

        selection_sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void selection_sort(int[] arr) {

        for(int i = 0; i<arr.length; i++){
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);

            System.out.println(Arrays.toString(arr));
        }
    }

    private static int getMaxIndex(int[] arr, int start, int end) {
        int maxIndex = 0;

        for(int i = start; i<=end; i++){
            if(arr[i]>arr[maxIndex]){
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    private static void swap(int arr[], int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


}
