class Solution {

    /*
     * Returns the MINIMUM possible total array sum when:
     *
     * nums[index] = value
     *
     * Rules:
     * 1. Every element must be >= 1
     * 2. Adjacent elements can differ by at most 1
     *
     * Why do we need this?
     * ---------------------
     * During binary search we guess:
     *
     * nums[index] = value
     *
     * Then we calculate the SMALLEST array sum possible
     * with that value at index.
     *
     * If even the smallest possible sum exceeds maxSum,
     * then value is impossible.
     *
     * If the smallest possible sum is <= maxSum,
     * then value is feasible.
     *
     * Example:
     * n = 6
     * index = 2
     * value = 4
     *
     * Smallest valid array:
     *
     * [2, 3, 4, 3, 2, 1]
     *
     * sum = 15
     *
     * Any other valid array with nums[index] = 4
     * would have equal or larger sum.
     */
    public long getSum(int index, int value, int n){

        long sum = 0;

        /*
         * =====================================================
         * LEFT SIDE (including index)
         * =====================================================
         *
         * We need the sum of:
         *
         * ?, ?, ..., value
         *
         * while decreasing by 1 each step moving left.
         *
         * There are two possible cases.
         */

        // -----------------------------------------------------
        // CASE 1:
        // value reaches 1 before filling all left positions.
        // -----------------------------------------------------
        //
        // Example:
        //
        // index = 6
        // value = 4
        //
        // Left side positions count = index + 1 = 7
        //
        // Decreasing sequence:
        //
        // 1 2 3 4
        //
        // Only 4 numbers available.
        //
        // Remaining positions must be filled with 1:
        //
        // 1 1 1 2 3 4
        //
        // Arithmetic sequence sum:
        //
        // 1 + 2 + 3 + 4
        //
        // Formula:
        //
        // n*(first+last)/2
        //
        // = 4*(1+4)/2
        // = 10
        //
        // Extra ones:
        //
        // index - value + 1
        //
        // = 6 - 4 + 1
        // = 3
        //
        // Total:
        //
        // 10 + 3 = 13
        //
        if(value <= index){

            // Sum of:
            // 1 + 2 + ... + value
            sum += (long)(value + 1) * value / 2;

            // Remaining positions become 1
            sum += (long)index - value + 1;
        }

        // -----------------------------------------------------
        // CASE 2:
        // value never reaches 1.
        // -----------------------------------------------------
        //
        // Example:
        //
        // index = 2
        // value = 6
        //
        // Left side:
        //
        // 4 5 6
        //
        // Arithmetic progression:
        //
        // first = value - index
        //       = 6 - 2
        //       = 4
        //
        // last = value
        //      = 6
        //
        // count = index + 1
        //       = 3
        //
        // Formula:
        //
        // count*(first+last)/2
        //
        // = 3*(4+6)/2
        // = 15
        //
        else{

            sum += (long)(value + value - index)
                    * (index + 1) / 2;
        }

        /*
         * =====================================================
         * RIGHT SIDE (including index)
         * =====================================================
         *
         * Exactly same logic as left side.
         *
         * Number of positions from index to end:
         *
         * n - index
         */

        // -----------------------------------------------------
        // CASE 1:
        // Sequence reaches 1.
        // -----------------------------------------------------
        //
        // Example:
        //
        // n = 8
        // index = 2
        // value = 3
        //
        // Right side positions:
        //
        // n - index = 6
        //
        // Sequence:
        //
        // 3 2 1
        //
        // Remaining positions:
        //
        // 1 1 1
        //
        // Right side:
        //
        // 3 2 1 1 1 1
        //
        if(value <= n - index){

            // Sum of:
            // 1 + 2 + ... + value
            sum += (long)(value + 1) * value / 2;

            // Remaining positions become 1
            sum += (long)n - index - value;
        }

        // -----------------------------------------------------
        // CASE 2:
        // Sequence never reaches 1.
        // -----------------------------------------------------
        //
        // Example:
        //
        // n = 7
        // index = 2
        // value = 6
        //
        // Right side positions:
        //
        // 5
        //
        // Sequence:
        //
        // 6 5 4 3 2
        //
        // first term:
        //
        // value - (count-1)
        //
        // = 6 - (5-1)
        //
        // = 2
        //
        // Formula:
        //
        // count*(first+last)/2
        //
        // = 5*(2+6)/2
        //
        else{

            sum += (long)((value - n + 1 + index) + value)
                    * (n - index) / 2;
        }

        /*
         * IMPORTANT:
         *
         * Index value was counted twice.
         *
         * Left side includes:
         * ...
         * value
         *
         * Right side includes:
         * value
         * ...
         *
         * So subtract one copy.
         */
        return sum - value;
    }

    public int maxValue(int n, int index, int maxSum) {

        /*
         * Binary Search on answer.
         *
         * Search space:
         *
         * nums[index] can be from:
         *
         * 1 ... maxSum
         *
         * Why maxSum?
         *
         * Because entire array sum cannot exceed maxSum,
         * therefore nums[index] can never exceed maxSum.
         */

        int left = 1;
        int right = maxSum;

        /*
         * We are searching for the LARGEST valid value.
         *
         * Pattern:
         *
         * valid values:
         *
         * 1 2 3 4 5
         *
         * invalid values:
         *
         * 6 7 8 9 ...
         *
         * Monotonic property:
         *
         * If value = 5 works,
         * then 1,2,3,4 also work.
         *
         * If value = 6 fails,
         * then 7,8,9 also fail.
         *
         * Therefore binary search can be used.
         */

        while(left < right){

            /*
             * Upper Mid
             *
             * Why +1?
             *
             * Suppose:
             *
             * left = 4
             * right = 5
             *
             * Normal mid:
             *
             * mid = 4
             *
             * If valid:
             *
             * left = mid
             *
             * left stays 4 forever.
             *
             * Infinite loop.
             *
             * Upper mid:
             *
             * mid = 5
             *
             * If valid:
             *
             * left = 5
             *
             * Loop ends.
             */
            int mid = left + (right - left + 1) / 2;

            /*
             * Check whether mid can be placed at index
             * while keeping total sum <= maxSum.
             */
            if(getSum(index, mid, n) <= maxSum){

                /*
                 * mid works.
                 *
                 * Try larger value.
                 */
                left = mid;
            }
            else{

                /*
                 * mid does not work.
                 *
                 * Search smaller values.
                 */
                right = mid - 1;
            }
        }

        /*
         * left == right
         *
         * Largest feasible value found.
         */
        return left;
    }
}