package sorting.find_the_rotation_count_in_rotated_sorted_array;

import java.util.Scanner;

public class RotationCountInRotatedSortedArray {

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6};

        // Perform binary search within the found range
        int pivot  = findPivot(arr);

        if(pivot != -1){
            System.out.println("Array rotated " + (pivot + 1) + " times");
        }
        else{
            System.out.println("Array not rotated");
        }
    }

    public static int findPivot(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Case 1:
            // Pivot found at mid.
            //
            // Example:
            // [4,5,6,7,0,1,2]
            //        ^
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // Case 2:
            // Pivot found before mid.
            //
            // Example:
            // [4,5,6,7,0,1,2]
            //          ^
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // Case 3:
            // start, mid and end contain the same value.
            //
            // Example:
            // [2,2,2,9,2,2]
            //
            // Here we cannot determine which side is sorted,
            // so we shrink the search space from both ends.
            else if (arr[mid] == arr[start] && arr[mid] == arr[end]) {

                // Before skipping start,
                // check whether start itself is the pivot.
                //
                // Example:
                // [9,1,2,3,4]
                //  ^
                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // Before skipping end,
                // check whether end - 1 is the pivot.
                //
                // Example:
                // [2,3,4,5,1]
                //        ^
                if (arr[end - 1] > arr[end]) {
                    return end - 1;
                }
                end--;
            }

            // Left half is sorted,
            // so pivot must be in the right half.
            //
            // Example:
            // [2,2,2,9,2]
            //  s   m   e
            else if (arr[start] <= arr[mid] && arr[mid] > arr[end]) {
                start = mid + 1;
            }

            // Right half is sorted,
            // so pivot must be in the left half.
            else {
                end = mid - 1;
            }
        }

        // Array is not rotated.
        return -1;
    }
}
