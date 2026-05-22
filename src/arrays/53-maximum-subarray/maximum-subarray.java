class Solution {
    public int maxSubArray(int[] nums) {
        /*
            Kadane's Algorithm

            If the running sum becomes negative,
            start a new subarray from the current element.

            Formula:
            currentSum = max(nums[i], currentSum + nums[i])
            maxSum = max(maxSum, currentSum)

            Time: O(n)
            Space: O(1)
        */

        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i<nums.length; i++){
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = currentSum > maxSum ? currentSum : maxSum;
        }

        return maxSum;
    }
}