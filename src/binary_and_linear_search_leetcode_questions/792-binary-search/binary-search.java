class Solution {
    public int search(int[] nums, int target) {

        // Initialize search space
        int start = 0;
        int end = nums.length - 1;

        // Continue searching while the search space is valid
        while (start <= end) {

            // Calculate middle index safely to avoid integer overflow
            int mid = start + (end - start) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }

            // Target lies in the left half
            else if (nums[mid] > target) {
                end = mid - 1;
            }

            // Target lies in the right half
            else {
                start = mid + 1;
            }
        }

        // Target not present in the array
        return -1;
    }
}