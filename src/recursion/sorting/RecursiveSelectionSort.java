package recursion.sorting;

import java.util.Arrays;

public class RecursiveSelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        recursiveSelectionSort(arr,arr.length-1,0, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void recursiveSelectionSort(int[] arr, int passEnd, int currentIndex, int maxElementIndex){
        if(passEnd==0){
            return;
        }

        if(currentIndex<=passEnd){
            if(arr[currentIndex]>arr[maxElementIndex]){
                maxElementIndex = currentIndex;
            }
            recursiveSelectionSort(arr, passEnd, currentIndex+1, maxElementIndex);
        }
        else{
            swap(arr, passEnd, maxElementIndex);
            recursiveSelectionSort(arr, passEnd-1, 0, 0);
        }
    }

    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
