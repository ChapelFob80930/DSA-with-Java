class Solution {

    /*
     * Checks whether Koko can finish all piles within h hours
     * if she eats at speed = k bananas/hour.
     *
     * Key observation:
     * For a pile of size p, hours needed =
     * ceil(p / k)
     *
     * Instead of using Math.ceil():
     *
     * ceil(p / k) = (p + k - 1) / k
     *
     * Examples:
     * p = 7, k = 3
     * Hours = ceil(7/3) = 3
     * Formula => (7 + 3 - 1) / 3 = 9/3 = 3
     *
     * p = 6, k = 3
     * Hours = ceil(6/3) = 2
     * Formula => (6 + 3 - 1) / 3 = 8/3 = 2
     *
     * Total hours required =
     * Sum of hours needed for every pile.
     *
     * If total hours <= h,
     * then speed k is valid.
     */
    public boolean checkSpeed(int[] piles, int h, int k) {
        int totalTimeSpent = 0;

        for (int p : piles) {
            totalTimeSpent += (p + k - 1) / k;
        }

        return totalTimeSpent <= h;
    }

    /*
     * Binary search answer range:
     *
     * Minimum possible speed = 1
     * Maximum possible speed = max pile size
     *
     * If Koko can eat an entire largest pile in one hour,
     * any larger speed is unnecessary.
     */
    public int findMax(int[] piles) {
        int max = Integer.MIN_VALUE;

        for (int p : piles) {
            if (p > max) {
                max = p;
            }
        }

        return max;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int start = 1;
        int end = findMax(piles);

        /*
         * Binary Search on the Answer
         *
         * Search space = possible eating speeds.
         *
         * Example:
         * piles = [3,6,7,11]
         * h = 8
         *
         * Possible speeds:
         * 1 2 3 4 5 6 ... 11
         *
         * Observation:
         *
         * Speed too small -> cannot finish in time
         * Speed large enough -> can finish in time
         *
         * F F F F T T T T ...
         *
         * We need the FIRST TRUE
         * (minimum valid eating speed).
         *
         * Lower Bound Binary Search Pattern:
         *
         * If mid works:
         *      try smaller speed
         *      end = mid
         *
         * If mid doesn't work:
         *      need larger speed
         *      start = mid + 1
         */
        while (start < end) {

            int mid = start + (end - start) / 2;

            if (checkSpeed(piles, h, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        /*
         * start == end
         * Both point to the first valid speed.
         */
        return start;
    }
}