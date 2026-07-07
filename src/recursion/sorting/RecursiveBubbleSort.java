package recursion.sorting;

import java.util.Arrays;

public class RecursiveBubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        recursiveBubbleSort(arr,arr.length-1,0);
        System.out.println(Arrays.toString(arr));
    }

    static void recursiveBubbleSort(int[] arr, int passEnd, int currentIndex){ //passEnd is technically the number of iterations remaining
        if(passEnd==0){
            return;
        }
        if(currentIndex<passEnd){
            if(arr[currentIndex]>arr[currentIndex+1]){
                swap(arr, currentIndex, currentIndex + 1);
            }
            recursiveBubbleSort(arr,passEnd,currentIndex+1);
        }
        else{
            recursiveBubbleSort(arr, passEnd-1,0);
        }
    }

    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
