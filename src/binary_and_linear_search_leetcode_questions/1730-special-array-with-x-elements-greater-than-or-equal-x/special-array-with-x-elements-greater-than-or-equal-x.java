class Solution {
    public int specialArray(int[] nums) {

        // Try every possible value of x from 0 to n
        for (int x = 0; x <= nums.length; x++) {

            int count = 0;

            // Count how many elements are greater than or equal to x
            for (int num : nums) {
                if (num >= x) {
                    count++;
                }
            }

            // If exactly x elements are >= x,
            // then x is the special value
            if (count == x) {
                return x;
            }
        }

        // No valid x found
        return -1;
    }
}