class Solution {
    public boolean search(int[] nums, int target) {
        int pivot = findPivotWithDuplicates(nums);

        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        else if (nums[pivot] == target) {
            return true;
        }

        else if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }

        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

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
                if (start<end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // Before skipping end,
                // check whether end - 1 is the pivot.
                //
                // Example:
                // [2,3,4,5,1]
                //        ^
                if (start < end && arr[end - 1] > arr[end]) {
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