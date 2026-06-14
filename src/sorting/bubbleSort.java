package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class bubbleSort {
    public static void main(String[] args){
        int[] arr = new int[5];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 5 elements");
        for(int i = 0; i<5; i++){
            System.out.print("Enter element " + (i+1) + ": ");
            arr[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(arr));

        bubble_sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void bubble_sort(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            int swapped = 0;
            System.out.println("pass "+i);
            for(int j = 1; j < n-i; j++){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = 1;
                }
            }
            if(swapped == 0){
                break;
            }
        }
    }
}
