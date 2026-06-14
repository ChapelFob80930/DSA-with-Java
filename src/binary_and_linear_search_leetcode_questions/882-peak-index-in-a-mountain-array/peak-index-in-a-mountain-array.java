class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        // Quick intuition
        // If arr[mid] > arr[mid + 1] → you are on the downhill side, so the peak is at mid or to its left.
        // If arr[mid] < arr[mid + 1] → you are on the uphill side, so the peak is definitely to the right.
        // Eventually, start and end meet at the peak index.

        int start = 0;
        int end = arr.length - 1;

        // Binary Search for the peak element
        while (start < end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // You are in the descending part of the mountain.
                // mid can still be the peak, so keep it in the search space.
                end = mid;
            } else {
                // You are in the ascending part of the mountain.
                // Since arr[mid + 1] > arr[mid], the peak must be on the right.
                start = mid + 1;
            }
        }

        // When the loop ends, start == end.
        // Both pointers converge to the peak element's index.
        return start; // or return end;
    }
}