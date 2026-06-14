class Solution {

    public int splitArray(int[] nums, int k) {

        // Minimum possible answer:
        // Largest element in the array.
        // No subarray can have a sum smaller than this.
        int start = 0;

        // Maximum possible answer:
        // Sum of the entire array.
        // Happens when we take the whole array as one subarray.
        int end = 0;

        // Compute search space boundaries
        for (int i = 0; i < nums.length; i++) {

            // Largest element -> minimum possible answer
            if (start < nums[i]) {
                start = nums[i];
            }

            // Sum of all elements -> maximum possible answer
            end += nums[i];
        }

        // Binary Search on the answer space [start, end]
        while (start < end) {

            // Candidate maximum subarray sum
            int mid = start + (end - start) / 2;

            // At least one subarray always exists
            int pieces = 1;

            // Running sum of the current subarray
            int sum = 0;

            // Count how many subarrays are needed
            // if no subarray is allowed to exceed 'mid'
            for (int n : nums) {

                // Current subarray would exceed the allowed limit,
                // so start a new subarray
                if (sum + n > mid) {
                    pieces++;
                    sum = 0;
                }

                sum += n;
            }

            /*
             * Observation:
             *
             * Smaller max allowed sum (mid)
             * -> More subarrays required
             *
             * Larger max allowed sum (mid)
             * -> Fewer subarrays required
             *
             * This creates a monotonic pattern:
             *
             * Invalid Invalid Invalid Valid Valid Valid
             *                         ^
             *                   First Valid Answer
             */

            /*
             * If pieces <= k:
             *
             * We successfully split the array using
             * at most k subarrays.
             *
             * Therefore 'mid' is a VALID answer.
             *
             * Since we want the SMALLEST valid answer,
             * search the left half including mid.
             */
            if (pieces <= k) {
                end = mid;
            }

            /*
             * If pieces > k:
             *
             * More than k subarrays are required.
             *
             * This means 'mid' is too small and
             * cannot be the answer.
             *
             * Increase the allowed maximum sum.
             */
            else {
                start = mid + 1;
            }
        }

        // start == end
        // First valid answer =
        // Minimum possible largest subarray sum
        return start;
    }
}