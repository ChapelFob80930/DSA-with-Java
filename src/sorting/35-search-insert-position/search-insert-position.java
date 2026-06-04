class Solution {
    public int searchInsert(int[] nums, int target) {

        // Search space starts from first element and ends at last element
        int start = 0;
        int end = nums.length - 1;

        // Standard Binary Search
        while (start <= end) {

            // Safe mid calculation to prevent integer overflow
            int mid = start + (end - start) / 2;

            // Target found, return its index
            if (nums[mid] == target) {
                return mid;
            }

            // Target is larger, search in right half
            else if (nums[mid] < target) {
                start = mid + 1;
            }

            // Target is smaller, search in left half
            else {
                end = mid - 1;
            }
        }

        /*
         * If target is not found:
         *
         * At loop termination:
         * - end points to the last element smaller than target
         * - start points to the first element greater than target
         *
         * Example 1:
         * nums = [1,3,5,6], target = 2
         * Final state:
         * end = 0 (value = 1)
         * start = 1 (value = 3)
         * Insert position = 1
         *
         * Example 2:
         * nums = [1,3,5,6], target = 7
         * Final state:
         * end = 3 (value = 6)
         * start = 4 (out of array)
         * Insert position = 4
         *
         * Example 3:
         * nums = [1,3,5,6], target = 0
         * Final state:
         * end = -1
         * start = 0
         * Insert position = 0
         *
         * Therefore:
         * insertion index = end + 1
         * (which is always equal to start)
         */
        return end + 1;
    }
}