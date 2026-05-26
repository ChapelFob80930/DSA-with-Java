class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;

        // Rotating n times gives the same array
        // So reduce unnecessary rotations
        k = k % n;

        // Step 1:
        // Reverse entire array
        // Example:
        // 1 2 3 4 5 6 7
        // ->
        // 7 6 5 4 3 2 1
        reverse(0, n - 1, nums);

        // Step 2:
        // Reverse first k elements
        // 7 6 5 -> 5 6 7
        reverse(0, k - 1, nums);

        // Step 3:
        // Reverse remaining elements
        // 4 3 2 1 -> 1 2 3 4
        reverse(k, n - 1, nums);
    }

    public void reverse(int left, int right, int[] nums) {

        // Keep swapping until pointers meet
        while(left < right){

            // Swap elements
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            // Move pointers inward
            left++;
            right--;
        }
    }
}