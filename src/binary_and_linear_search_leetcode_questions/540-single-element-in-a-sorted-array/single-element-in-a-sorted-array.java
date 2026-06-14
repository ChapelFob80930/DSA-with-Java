class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        /*
         * Key Observation:
         *
         * Before the single element:
         * Pair starts at even indices
         * (0,1), (2,3), (4,5), ...
         *
         * After the single element:
         * The pattern shifts by one position,
         * so pairs start at odd indices
         * (1,2), (3,4), (5,6), ...
         *
         * We use binary search to find where this shift occurs.
         */

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Force mid to be even so it always points
            // to the first element of a potential pair
            if (mid % 2 == 1) {
                mid--;
            }

            /*
             * If nums[mid] == nums[mid + 1],
             * the pair is intact and we're still in the
             * "before single element" region.
             * So search on the right.
             */
            if (nums[mid] == nums[mid + 1]) {
                start = mid + 2;
            }

            /*
             * Pairing pattern is broken.
             * The single element is at mid or to its left.
             */
            else {
                end = mid;
            }
        }

        // start == end points to the single element
        return nums[start];
    }
}