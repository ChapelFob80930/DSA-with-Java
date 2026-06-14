class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        // Store Bob's candy sizes for O(1) lookups
        HashSet<Integer> newBobSizes = new HashSet<>();

        for (int i : bobSizes) {
            newBobSizes.add(i);
        }

        /*
         * Let Alice give x and receive y.
         *
         * After swap:
         * sumA - x + y = sumB - y + x
         *
         * Rearranging:
         * y = x + (sumB - sumA) / 2
         *
         * So for every candy x that Alice can give,
         * we only need to check whether the required y
         * exists in Bob's collection.
         */
        int diff = (sum(bobSizes) - sum(aliceSizes)) / 2;

        for (int x : aliceSizes) {

            // Required candy size from Bob to make totals equal
            int y = x + diff;

            // If Bob has the required candy, return the swap pair
            if (newBobSizes.contains(y)) {
                return new int[] { x, y };
            }
        }

        // Problem guarantees an answer, but added as a safeguard
        return new int[] { -1, -1 };
    }

    // Returns the total number of candies in an array
    public int sum(int arr[]) {
        int sum = 0;

        for (int i : arr) {
            sum += i;
        }

        return sum;
    }
}