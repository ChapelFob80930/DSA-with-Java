class Solution {
    public int findMin(int[] nums) {
        // Find the pivot (largest element)
        int pivot = findPivot(nums);

        // If no pivot exists, array is not rotated
        // so the first element is the minimum
        if (pivot == -1) {
            return nums[0];
        }

        // Minimum element is always right after the pivot
        return nums[pivot + 1];
    }

    public int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Case 1:
            // Current element is greater than next element
            // Example: [4,5,6,7,0,1,2]
            //                 ^
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // Case 2:
            // Current element is smaller than previous element
            // Example: [4,5,6,7,0,1,2]
            //                   ^
            // Pivot is previous index
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            // We use <= instead of <
            //
            // Even though this problem does not contain duplicates,
            // using <= ensures that the search space always shrinks.
            //
            // Example (already sorted array):
            // [1,2,3,4,5]
            //
            // start = 3, end = 4, mid = 3
            //
            // nums[start] == nums[mid] (4 == 4)
            //
            // If we only used:
            // if (nums[start] < nums[mid])
            //
            // both conditions would become false,
            // causing start and end to remain unchanged,
            // resulting in an infinite loop.
            //
            // Using <= correctly identifies the left half as sorted
            // and moves start = mid + 1.
            //
            // So <= is needed for correctness, not because of duplicates.
            if (nums[start] <= nums[mid]) {
                start = mid + 1;
            }

            // Right half is sorted,
            // so pivot must lie in the left half
            else {
                end = mid - 1;
            }
        }

        // No pivot found => array is already sorted
        return -1;
    }
}