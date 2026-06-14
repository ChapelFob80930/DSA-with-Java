class Solution {
    public boolean search(int[] nums, int target) {

        // Find the pivot (largest element) in the rotated array.
        int pivot = findPivotWithDuplicates(nums);

        // If no pivot exists, the array is not rotated.
        // Search the entire array normally.
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        // Target found at the pivot.
        if (nums[pivot] == target) {
            return true;
        }

        // Target lies in the left sorted half.
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }

        // Otherwise search in the right sorted half.
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    // Standard Binary Search
    public static boolean binarySearch(int[] arr, int target, int start, int end) {

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    // Finds the pivot (largest element)
    // in a rotated sorted array with duplicates.
    public static int findPivotWithDuplicates(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Case 1:
            // Pivot found at mid.
            //
            // Example:
            // [4,5,6,7,0,1,2]
            //        m
            //
            // Since 7 > 0, pivot = 7.
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // Case 2:
            // Pivot found before mid.
            //
            // Example:
            // [4,5,6,7,0,1,2]
            //          m
            //
            // Since 0 < 7, pivot = 7.
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // Case 3:
            // start, mid and end contain the same value.
            //
            // Example:
            // [2,2,2,3,2,2,2]
            //
            // Duplicates make it impossible to determine
            // which side is sorted, so shrink both ends.
            else if (arr[mid] == arr[start] && arr[mid] == arr[end]) {

                // Before skipping start,
                // check whether start itself is the pivot.
                //
                // Example:
                // [3,1,2,3,3]
                //
                // Since 3 > 1, index 0 is the pivot.
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // Before skipping end,
                // check whether end - 1 is the pivot.
                //
                // Example:
                // [1,1,1,5,1]
                //
                // Since 5 > 1, index 3 is the pivot.
                if (start < end && arr[end - 1] > arr[end]) {
                    return end - 1;
                }
                end--;
            }

            // Left half is sorted,
            // so the pivot must be in the right half.
            //
            // Example:
            // [4,5,6,7,0,1,2]
            //  s     m     e
            //
            // Left side is sorted, but mid > end,
            // so rotation exists on the right.
            else if (arr[start] <= arr[mid] && arr[mid] > arr[end]) {
                start = mid + 1;
            }

            // Right half is sorted,
            // so the pivot must be in the left half.
            //
            // Example:
            // [6,7,0,1,2,4,5]
            //  s   m       e
            //
            // Rotation point lies on the left side.
            else {
                end = mid - 1;
            }
        }

        // Array is not rotated.
        return -1;
    }
}