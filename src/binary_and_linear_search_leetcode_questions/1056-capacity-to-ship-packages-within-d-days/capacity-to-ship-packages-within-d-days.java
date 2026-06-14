class Solution {

    public int shipWithinDays(int[] weights, int days) {

        // Total weight of all packages.
        // This represents the maximum possible ship capacity
        // (ship everything in one day).
        int totalWeight = sum(weights);

        // Minimum possible capacity must be at least the
        // heaviest package, otherwise that package can never be shipped.
        int start = max(weights);

        // Maximum possible capacity is the sum of all packages.
        int end = totalWeight;

        // Binary search for the smallest valid ship capacity.
        while (start < end) {

            int mid = start + (end - start) / 2;

            // If this capacity can ship all packages within
            // the given number of days, try a smaller capacity.
            if (checkIfValidWeightOfShip(weights, mid, days)) {
                end = mid;
            }

            // Otherwise capacity is too small,
            // search in the larger half.
            else {
                start = mid + 1;
            }
        }

        // start == end => smallest valid capacity.
        return start;
    }

    // Returns the sum of all package weights.
    public int sum(int[] weights) {
        int sum = 0;

        for (int w : weights) {
            sum += w;
        }

        return sum;
    }

    // Returns the weight of the heaviest package.
    public int max(int[] weights) {
        int max = Integer.MIN_VALUE;

        for (int w : weights) {
            if (w > max) {
                max = w;
            }
        }

        return max;
    }

    /*
     * Simulates shipping packages using a ship of capacity shipCapacity.
     *
     * Greedy approach:
     * - Keep loading packages into the current day while they fit.
     * - As soon as the next package doesn't fit, start a new day.
     *
     * If the total days required <= allowed days,
     * then this ship capacity is valid.
     */
    public boolean checkIfValidWeightOfShip(int[] weights,
                                            int shipCapacity,
                                            int days) {

        int currentLoad = 0;

        // We always start with Day 1.
        int daysUsed = 1;

        for (int w : weights) {

            // Package fits in the current day's shipment.
            if (currentLoad + w <= shipCapacity) {
                currentLoad += w;
            }

            // Package doesn't fit.
            // Start a new day and place this package there.
            else {
                daysUsed++;
                currentLoad = w;
            }
        }

        return daysUsed <= days;
    }
}