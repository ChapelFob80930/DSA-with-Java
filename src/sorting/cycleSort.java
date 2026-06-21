package sorting;

import java.util.Arrays;
import java.util.Scanner;


public class cycleSort {

    public static void main(String[] args){

        int[] arr = new int[5];

        Scanner scanner = new Scanner(System.in);

        // Take array input
        System.out.println("Enter 5 elements");

        for(int i = 0; i < 5; i++){
            System.out.print("Enter element " + (i+1) + ": ");
            arr[i] = scanner.nextInt();
        }

        System.out.println();

        System.out.print("Before sorting: ");
        System.out.println(Arrays.toString(arr));

        cycle_sort(arr);

        System.out.print("After sorting: ");
        System.out.println(Arrays.toString(arr));
    }

// If a number is not at its correct index, place it there; otherwise move forward.
// Cyclic Sort
// Idea: Every number from 1 to n has exactly one correct index.
//
// Number : 1 2 3 4 5
// Index  : 0 1 2 3 4
//
// Formula:
// correct index = value - 1
//
// Example:
//
// [3, 5, 2, 1, 4]
//
// i = 0
// arr[0] = 3
// correct = 2
//
// arr[0] != arr[2] (3 != 2)
// -> swap
//
// [2, 5, 3, 1, 4]
//
// Stay at i = 0 because a new number arrived.
//
// arr[0] = 2
// correct = 1
//
// arr[0] != arr[1] (2 != 5)
// -> swap
//
// [5, 2, 3, 1, 4]
//
// Keep doing this until the current index already
// contains the correct value.
//
// Rule:
// If current value != value at its correct position -> swap.
// Otherwise -> move forward.
//
// Works for:
// 1. Numbers from 1 to n
// 2. Also safely handles duplicates.

    public static void cycle_sort(int[] arr){

        int i = 0;

        while(i < arr.length){

            System.out.println();
            printArray(arr, i);

            int correct = arr[i] - 1;

            if(arr[i] != arr[correct]){

                swap(arr, i, correct);
            }

            else{

                i++;
            }
        }
    }

    private static void swap(int arr[], int index1, int index2){

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    // Visualize which index is currently being processed
    public static void printArray(int[] arr, int currentIndex){

        System.out.println(Arrays.toString(arr));

        for(int i = 0; i < arr.length; i++){

            if(i == currentIndex){
                System.out.print(" ^ ");
            }

            else{
                System.out.print("   ");
            }
        }

        System.out.println();
    }
}