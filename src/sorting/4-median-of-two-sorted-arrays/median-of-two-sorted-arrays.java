class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int total = nums1.length + nums2.length;

        // Always binary search on the smaller array.
        // This guarantees O(log(min(m, n))) time complexity.
        int[] A = nums1;
        int[] B = nums2;

        if (nums1.length > nums2.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int half = total / 2;

        /*
         * i = index of the LAST element included
         *     in the left partition of A.
         *
         * We allow:
         *
         * i = -1
         *
         * Example:
         *
         * A = [1, 2]
         *
         * Partition:
         *
         * | 1 2
         *
         * Meaning:
         * We took 0 elements from A into the left side.
         *
         * Therefore:
         *
         * Aleft  = -infinity
         * Aright = 1
         *
         * This lets us handle edge cases without
         * special logic.
         */
        int l = -1;
        int r = A.length - 1;

        while (l <= r) {

            /*
             * Upper-mid calculation.
             *
             * Example:
             *
             * l = -1
             * r = 0
             *
             * Normal mid:
             * (-1 + 0)/2 = 0
             *
             * Using upper-mid prevents binary search
             * from getting stuck in certain cases.
             */
            int i = l + (r - l + 1) / 2;

            /*
             * Example:
             *
             * A = [1, 2]
             * B = [3, 4]
             *
             * total = 4
             * half  = 2
             *
             * Suppose:
             *
             * i = 0
             *
             * Since i is an INDEX:
             *
             * i = 0 means we took 1 element from A
             * i = 1 means we took 2 elements from A
             *
             * Therefore:
             *
             * Elements taken from A
             * = i + 1
             *
             * Elements taken from B
             * = j + 1
             *
             * Left partition must contain exactly
             * 'half' elements:
             *
             * (i + 1) + (j + 1) = half
             *
             * i + j + 2 = half
             *
             * j = half - i - 2
             *
             * This is where the "-2" comes from.
             */
            int j = half - i - 2;

            /*
             * Elements immediately around the partition:
             *
             * Aleft | Aright
             * Bleft | Bright
             *
             * Example:
             *
             * A = [1,2]
             *       ^
             *       i
             *
             * Aleft  = 1
             * Aright = 2
             *
             * If partition is outside array bounds:
             *
             * Aleft  = -infinity
             * Aright = +infinity
             *
             * This avoids special-case handling.
             */
            int Aleft = (i >= 0) ? A[i] : Integer.MIN_VALUE;
            int Aright = (i + 1 < A.length) ? A[i + 1] : Integer.MAX_VALUE;

            int Bleft = (j >= 0) ? B[j] : Integer.MIN_VALUE;
            int Bright = (j + 1 < B.length) ? B[j + 1] : Integer.MAX_VALUE;

            /*
             * Correct partition condition:
             *
             * Aleft <= Bright
             * Bleft <= Aright
             *
             * Why?
             *
             * Every element on the LEFT side
             * must be <= every element on the RIGHT side.
             *
             * Since both arrays are already sorted,
             * checking these two boundary comparisons
             * is sufficient.
             */
            if (Aleft <= Bright && Bleft <= Aright) {

                /*
                 * Odd length example:
                 *
                 * [1,2 | 3,4,5]
                 *
                 * Median is the first element
                 * on the right side.
                 */
                if (total % 2 == 1) {
                    return Math.min(Aright, Bright);
                }

                /*
                 * Even length example:
                 *
                 * [1,2 | 3,4]
                 *
                 * Middle values are:
                 *
                 * max(Aleft, Bleft)
                 * min(Aright, Bright)
                 *
                 * Median = average of the two.
                 */
                return (
                    Math.max(Aleft, Bleft)
                    + Math.min(Aright, Bright)
                ) / 2.0;
            }

            /*
             * Example:
             *
             * Aleft > Bright
             *
             * 8 | 9
             * 4 | 5
             *
             * 8 > 5
             *
             * We took too many elements from A.
             *
             * Move partition LEFT.
             */
            else if (Aleft > Bright) {
                r = i - 1;
            }

            /*
             * Example:
             *
             * Bleft > Aright
             *
             * 2 | 3
             * 7 | 8
             *
             * 7 > 3
             *
             * We did not take enough elements
             * from A.
             *
             * Move partition RIGHT.
             */
            else {
                l = i + 1;
            }
        }

        return -1;
    }
}