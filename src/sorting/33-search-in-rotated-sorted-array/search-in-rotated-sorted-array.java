class Solution {

    public int search(int[] nums, int target) {

        int pivot = findPivot(nums);

        // Example:
        // nums = [1,2,3,4,5]
        // No rotation exists.
        // pivot = -1
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        // Example:
        // nums = [4,5,6,7,0,1,2]
        //               ^
        //            pivot
        //
        // If target = 7,
        // we found it immediately.
        if (nums[pivot] == target) {
            return pivot;
        }

        // Example:
        // nums = [4,5,6,7,0,1,2]
        //
        // Left sorted part  = [4,5,6,7]
        // Right sorted part = [0,1,2]
        //
        // target = 6
        // Since 6 >= nums[0] (4),
        // target must be in the left half.
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }

        // Example:
        // nums = [4,5,6,7,0,1,2]
        // target = 1
        //
        // Since 1 < nums[0] (4),
        // target must be in the right half.
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    public int binarySearch(int[] arr, int target, int start, int end) {

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] > target) {
                end = mid - 1;
            }

            else if (arr[mid] < target) {
                start = mid + 1;
            }

            else {
                return mid;
            }
        }

        return -1;
    }

    public int findPivot(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        /*
            Pivot = Largest element in the rotated array.

            Example 1:
            [4,5,6,7,0,1,2]
                   ^
                 pivot

            Example 2:
            [6,7,1,2,3,4,5]
                 ^
               pivot

            Key Observation:
            ----------------
            If one half is completely sorted,
            the pivot CANNOT be inside that half.

            Why?

            Because pivot is where order breaks.

            Example:
            [4,5,6,7]

            Every element is increasing.
            No order break exists.
            Therefore pivot is not here.
        */

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Case 1:
            //
            // Example:
            // [4,5,6,7,0,1,2]
            //        m
            //
            // arr[mid] = 7
            // arr[mid+1] = 0
            //
            // Since 7 > 0,
            // order breaks here.
            // Therefore mid is the pivot.
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // Case 2:
            //
            // Example:
            // [4,5,6,7,0,1,2]
            //          m
            //
            // arr[mid] = 0
            // arr[mid-1] = 7
            //
            // Since 0 < 7,
            // order broke before mid.
            // Therefore mid-1 is the pivot.
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // Left half is sorted.
            //
            // Example:
            // [4,5,6,7,0,1,2]
            //  s     m
            //
            // arr[start] = 4
            // arr[mid]   = 6
            //
            // Since 4 <= 6,
            // left half [4,5,6] is sorted.
            //
            // A sorted half cannot contain
            // the pivot because no order break exists.
            //
            // Discard left half and search right.
            if (arr[start] <= arr[mid]) {
                start = mid + 1;
            }

             // Left half is NOT sorted.
            //
            // Example:
            // [6,7,0,1,2,4,5]
            //  s   m
            //
            // arr[start] = 6
            // arr[mid]   = 0
            //
            // Since 6 > 0,
            // order has already broken somewhere
            // between start and mid.
            //
            // Therefore pivot must be on the left side..
            else {
                end = mid - 1;
            }
        }

        // Example:
        // [1,2,3,4,5]
        //
        // No rotation exists.
        return -1;
    }
}