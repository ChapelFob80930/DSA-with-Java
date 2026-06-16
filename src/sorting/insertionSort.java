package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class insertionSort {

    public static void main(String[] args){
        int[] arr = new int[5];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 5 elements");
        for(int i = 0; i<5; i++){
            System.out.print("Enter element " + (i+1) + ": ");
            arr[i] = scanner.nextInt();
        }

        System.out.println();
        System.out.print("Before sorting: ");
        System.out.print(Arrays.toString(arr));

        insertion_sort(arr);

        System.out.println();
        System.out.print("After sorting: ");
        System.out.print(Arrays.toString(arr));
        System.out.println();
    }

    public static void insertion_sort(int[] arr){

        for(int i = 0; i < arr.length-1; i++){

            System.out.println();
            System.out.println("Pass " + (i+1));

            for(int j = i+1; j > 0; j--){

                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }

                else{
                    break;
                }

                System.out.println(Arrays.toString(arr));

            }
        }
    }

}
