package recursion.sorting;

import java.util.Arrays;

public class RecursiveMergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 3, 4, 12, 5, 6};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);

    }

    static int[] merge(int[] arr1, int[] arr2) {
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int[] mergedAndSortedArray = new int[arr1.length+arr2.length];

        while(p1<arr1.length && p2<arr2.length){
            if(arr1[p1]<arr2[p2]){
                mergedAndSortedArray[p3++] = arr1[p1++];
            }

            else{
                mergedAndSortedArray[p3++] = arr2[p2++];
            }
        }

        if(p1<arr1.length){
            while(p1<arr1.length){
                mergedAndSortedArray[p3++] = arr1[p1++];
            }
        }

        if(p2<arr2.length){
            while(p2<arr2.length){
                mergedAndSortedArray[p3++] = arr2[p2++];
            }
        }

        return mergedAndSortedArray;
    }
}
