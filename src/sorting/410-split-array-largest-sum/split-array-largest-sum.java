class Solution {

    public int splitArray(int[] nums, int k) {

        // Minimum possible answer:
        // If we split into n pieces (each element is its own subarray),
        // the largest subarray sum will be the largest element itself.
        int start = max(nums);

        // Maximum possible answer:
        // If we don't split at all (1 piece),
        // the largest subarray sum will be the sum of the entire array.
        int end = sum(nums);

        // Binary search on the answer space [start, end]
        while (start < end) {

            // Candidate maximum subarray sum
            int mid = start + (end - start) / 2;

            // At least one subarray always exists
            int pieces = 1;

            // Running sum of the current subarray
            int sum = 0;

            // Count how many pieces are needed if
            // no subarray is allowed to exceed 'mid'
            for (int n : nums) {

                // If adding current element exceeds 'mid',
                // start a new subarray
                if (sum + n > mid) {
                    pieces++;
                    sum = 0;
                }

                sum += n;
            }

            /*
             * If pieces <= k:
             *
             * We successfully split the array using at most k subarrays.
             * This means 'mid' is a VALID answer.
             *
             * Since we're looking for the SMALLEST valid answer,
             * search the left half including mid.
             *
             * Example:
             * Answer pattern:
             * Invalid Invalid Invalid Valid Valid Valid
             *                         ^
             *                     first valid
             */
            if (pieces <= k) {
                end = mid;
            }

            /*
             * If pieces > k:
             *
             * We need more than k subarrays.
             * This means 'mid' is too small.
             *
             * Increase the allowed maximum subarray sum.
             */
            else {
                start = mid + 1;
            }
        }

        // start == end
        // Smallest valid maximum subarray sum
        return start;
    }

    public int max(int[] nums) {

        int max = Integer.MIN_VALUE;

        // Find largest element in the array
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }

        return max;
    }

    public int sum(int[] nums) {

        int sum = 0;

        // Sum of all elements
        for (int n : nums) {
            sum += n;
        }

        return sum;
    }
}