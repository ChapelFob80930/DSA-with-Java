class Solution {

    public int findKthPositive(int[] arr, int k) {

        // Find the first index where the number of missing
        // positive integers becomes >= k.
        int position = findKthMissingPosition(arr, k);

        /*
         * Why is the answer = position + k ?
         *
         * position = number of array elements before the kth missing number.
         *
         * k = number of missing numbers before (and including) the answer.
         *
         * Therefore:
         *
         * answer =
         *      present numbers before answer
         *    + missing numbers before answer
         *
         * = position + k
         */
        return position + k;
    }

    private int findKthMissingPosition(int[] arr, int k) {

        // Binary search on indices, not values.
        int start = 0;
        int end = arr.length - 1;

        /*
         * Goal:
         * Find the FIRST index where
         *
         * missingCount >= k
         *
         * This is a classic "find first true" binary search.
         */
        while (start <= end) {

            int mid = start + (end - start) / 2;

            /*
             * Up to index mid:
             *
             * Number of elements actually present in the array
             * = mid + 1
             *
             * Example:
             * arr = [2,3,4,7,11]
             *
             * mid = 3
             *
             * Elements present:
             * [2,3,4,7]
             *
             * Count = 4 = mid + 1
             */
            int presentNumbers = mid + 1;

            /*
             * Numbers from 1 to arr[mid]
             * should contain arr[mid] values.
             *
             * Example:
             * arr[mid] = 7
             *
             * Expected numbers:
             * 1,2,3,4,5,6,7
             *
             * Total expected count = 7
             *
             * Present count = 4
             *
             * Missing count = 7 - 4 = 3
             *
             * Missing numbers:
             * 1,5,6
             */
            int missingNumbers = arr[mid] - presentNumbers;

            /*
             * If we still have fewer than k missing numbers,
             * the kth missing number must lie further right.
             */
            if (missingNumbers < k) {
                start = mid + 1;
            }

            /*
             * If missingNumbers >= k,
             * mid could be the answer,
             * but there might be an earlier index
             * satisfying the condition.
             *
             * So continue searching on the left side.
             */
            else {
                end = mid - 1;
            }
        }

        /*
         * When the loop ends:
         *
         * start points to the FIRST index where
         *
         * missingNumbers >= k
         *
         * Example:
         *
         * arr = [2,3,4,7,11]
         * k = 5
         *
         * Missing counts:
         *
         * index 0 -> 1
         * index 1 -> 1
         * index 2 -> 1
         * index 3 -> 3
         * index 4 -> 6
         *
         * First index with missingCount >= 5
         * is index 4.
         *
         * Therefore start = 4.
         */
        return start;
    }
}