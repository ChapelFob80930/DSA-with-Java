package recursion.sorting;

import java.util.Arrays;

public class RecursiveInPlaceMergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 3, 4, 12, 5, 6};
        System.out.println(Arrays.toString(arr));
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSortInPlace(int[] arr, int s, int e){
        if(e-s == 1){
            return;
        }

        int mid = (s+e) / 2;

        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid, e);

        mergeInPlace(arr, s, mid, e);

    }

    static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int p1 = start;
        int p2 = mid;
        int p3 = 0;
        int[] mergedAndSortedTempArray = new int[end-start];

        while(p1<mid && p2<end){
            if(arr[p1]<arr[p2]){
                mergedAndSortedTempArray[p3++] = arr[p1++];
            }

            else{
                mergedAndSortedTempArray[p3++] = arr[p2++];
            }
        }

        if(p1<mid){
            while(p1<mid){
                mergedAndSortedTempArray[p3++] = arr[p1++];
            }
        }

        if(p2<end){
            while(p2<end){
                mergedAndSortedTempArray[p3++] = arr[p2++];
            }
        }

        for(int i = 0; i<mergedAndSortedTempArray.length; i++){
            arr[start+i] = mergedAndSortedTempArray[i];
        }
    }
}
