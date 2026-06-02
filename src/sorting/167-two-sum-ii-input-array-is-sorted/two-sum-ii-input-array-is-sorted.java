class Solution {
    public int[] twoSum(int[] numbers, int target) {

        // Pointer at the beginning of the sorted array
        int start = 0;

        // Pointer at the end of the sorted array
        int end = numbers.length - 1;

        // Continue until the two pointers meet
        while (start < end) {

            // Calculate the sum of the current pair
            int sum = numbers[start] + numbers[end];

            // If the pair adds up to the target, return 1-based indices
            if (sum == target) {
                return new int[] { start + 1, end + 1 };
            }

            // If the sum is too small, move start right
            // to increase the sum
            else if (sum < target) {
                start++;
            }

            // If the sum is too large, move end left
            // to decrease the sum
            else {
                end--;
            }
        }

        // This line will never be reached because
        // the problem guarantees exactly one solution
        return new int[] {};
    }
}