package sorting.Amazon_infinite_array_search;

import java.util.Scanner;

public class InfiniteArraySearch {

    public static void main(String args[]) {

        // NOTE:
        // This is a finite array used to simulate the concept
        // of an infinite sorted array.
        //
        // In real infinite-array interview problems:
        // - array size is unknown
        // - arr.length is not available
        // - accessing beyond bounds is assumed possible
        //
        // For some large targets here, Java may throw
        // ArrayIndexOutOfBoundsException because this
        // array is actually finite.

        int[] arr = {3,5,7,9,10,90,100,130,140,160,170};

        Scanner sc = new Scanner(System.in);

        // Input target element to search
        int target = sc.nextInt();

        // Find the probable range where target may exist
        int[] indexes = findStartAndEndIndex(arr, target);

        int start = indexes[0];
        int end = indexes[1];

        // Perform binary search within the found range
        System.out.println(target + " found at index "
                + search(arr, target, start, end));
    }

    public static int[] findStartAndEndIndex(int[] arr, int target) {

        // Initial search window
        int start = 0;
        int end = 1;

        // Expand the search window exponentially
        // until target becomes smaller than or equal
        // to arr[end]
        while(target > arr[end]) {

            // New start becomes previous end + 1
            int temp = end + 1;

            /*
                Doubling the search box size

                Formula:
                newEnd = previousEnd + (sizeOfCurrentBox * 2)

                sizeOfCurrentBox = end - start + 1

                Example growth:
                [0,1]
                [2,5]
                [6,13]
                [14,29]

                This helps achieve O(log n) complexity.
             */
            end = end + ((end - start + 1) * 2);

            // Update start
            start = temp;
        }

        // Return the range where target may exist
        return new int[] {start, end};
    }

    public static int search(int[] arr, int target, int start, int end) {

        // Standard Binary Search
        while(start <= end) {

            // Prevent integer overflow
            int mid = start + (end - start) / 2;

            // Search in left half
            if(arr[mid] > target) {
                end = mid - 1;
            }

            // Search in right half
            else if(arr[mid] < target) {
                start = mid + 1;
            }

            // Target found
            else {
                return mid;
            }
        }

        // Target not present
        return -1;
    }
}