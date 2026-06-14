class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        /*
         * We always binary search on the smaller array.
         *
         * Why?
         *
         * Time Complexity:
         * O(log(min(m, n)))
         *
         * This is the required complexity for the problem.
         */
        int[] A = nums1;
        int[] B = nums2;

        if (nums1.length > nums2.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int total = A.length + B.length;

        /*
         * Example:
         *
         * total = 5
         *
         * half = (5 + 1) / 2 = 3
         *
         * Left side gets 3 elements.
         * Right side gets 2 elements.
         *
         * Why +1?
         *
         * For odd lengths, we want the extra element
         * to be on the LEFT side.
         *
         * Example:
         *
         * [1,2,3 | 4,5]
         *
         * Median = 3
         *
         * which is simply:
         *
         * max(Aleft, Bleft)
         *
         * For even lengths:
         *
         * total = 4
         * half = (4 + 1) / 2 = 2
         *
         * Left side = 2 elements
         * Right side = 2 elements
         *
         * So the formula works for both odd and even.
         */
        int half = (total + 1) / 2;

        /*
         * i = number of elements taken from A
         *     into the LEFT partition.
         *
         * Since i is a COUNT, not an index:
         *
         * i = 0 means:
         *
         * | 1 2 3
         *
         * i = 2 means:
         *
         * 1 2 | 3
         *
         * Therefore:
         *
         * i can range from:
         *
         * 0 ... A.length
         *
         * NOT:
         *
         * 0 ... A.length - 1
         */
        int l = 0;
        int r = A.length;

        while (l <= r) {

            /*
             * Number of elements taken from A
             * into the left partition.
             */
            int i = l + (r - l) / 2;

            /*
             * Example:
             *
             * total = 7
             * half = 4
             *
             * If we take:
             *
             * i = 1 element from A
             *
             * then B must contribute:
             *
             * 3 elements
             *
             * because:
             *
             * left partition size must always equal half.
             *
             * Therefore:
             *
             * i + j = half
             *
             * j = half - i
             */
            int j = half - i;

            /*
             * Aleft  = largest element on A's left side
             * Aright = smallest element on A's right side
             *
             * Example:
             *
             * A = [1,3,5,7]
             *
             * i = 2
             *
             * 1 3 | 5 7
             *
             * Aleft  = 3
             * Aright = 5
             *
             * Since i is a COUNT:
             *
             * left side ends at index i-1
             * right side starts at index i
             */
            int Aleft = (i > 0) ? A[i - 1] : Integer.MIN_VALUE;
            int Aright = (i < A.length) ? A[i] : Integer.MAX_VALUE;

            /*
             * Same logic for B.
             */
            int Bleft = (j > 0) ? B[j - 1] : Integer.MIN_VALUE;
            int Bright = (j < B.length) ? B[j] : Integer.MAX_VALUE;

            /*
             * Why MIN_VALUE and MAX_VALUE?
             *
             * Example:
             *
             * A = [1,3]
             *
             * i = 0
             *
             * | 1 3
             *
             * There is no left element.
             *
             * So:
             *
             * Aleft = -infinity
             *
             * represented by Integer.MIN_VALUE.
             *
             * Similarly:
             *
             * i = A.length
             *
             * 1 3 |
             *
             * There is no right element.
             *
             * So:
             *
             * Aright = +infinity
             *
             * represented by Integer.MAX_VALUE.
             */

            /*
             * VALID PARTITION CONDITION
             *
             * Aleft <= Bright
             * Bleft <= Aright
             *
             * Why only these two checks?
             *
             * Because both arrays are already sorted.
             *
             * If these two boundary comparisons hold,
             * then every element on the left side
             * is guaranteed to be <= every element
             * on the right side.
             *
             * Example:
             *
             * [1,2] | [5]
             * [3,4] | [6]
             *
             * Largest left element = 4
             * Smallest right element = 5
             *
             * Partition is correct.
             */
            if (Aleft <= Bright && Bleft <= Aright) {

                /*
                 * ODD LENGTH
                 *
                 * Example:
                 *
                 * [1,2,3 | 4,5]
                 *
                 * Median = 3
                 *
                 * Since we intentionally put the extra
                 * element on the LEFT side using:
                 *
                 * half = (total + 1) / 2
                 *
                 * the median is simply the largest
                 * value on the left side.
                 */
                if (total % 2 == 1) {
                    return Math.max(Aleft, Bleft);
                }

                /*
                 * EVEN LENGTH
                 *
                 * Example:
                 *
                 * [1,2 | 3,4]
                 *
                 * Middle elements:
                 *
                 * Left middle  = 2
                 * Right middle = 3
                 *
                 * Largest value on left:
                 *
                 * max(Aleft, Bleft)
                 *
                 * Smallest value on right:
                 *
                 * min(Aright, Bright)
                 *
                 * Median = average of those two.
                 */
                return (
                    Math.max(Aleft, Bleft)
                    + Math.min(Aright, Bright)
                ) / 2.0;
            }

            /*
             * Example:
             *
             * Aleft = 8
             * Bright = 5
             *
             * 8 > 5
             *
             * We took TOO MANY elements from A.
             *
             * Move partition LEFT.
             */
            else if (Aleft > Bright) {
                r = i - 1;
            }

            /*
             * Example:
             *
             * Bleft = 7
             * Aright = 3
             *
             * 7 > 3
             *
             * We did NOT take enough elements
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