class Solution {
    public boolean checkIfExist(int[] arr) {

        // Stores all previously seen numbers
        HashSet<Integer> set = new HashSet<>();

        for (int n : arr) {

            /*
             * A valid pair exists if:
             * 1. We have already seen 2 * n
             *    Example: [10, 5] -> when n = 5, 10 is already in the set.
             *
             * 2. n is even and we have already seen n / 2
             *    Example: [5, 10] -> when n = 10, 5 is already in the set.
             *
             * n % 2 == 0 ensures n/2 is an exact integer and
             * avoids incorrect matches caused by integer division.
             */
            if (set.contains(2 * n) || (n % 2 == 0 && set.contains(n / 2))) {
                return true;
            }

            // Add current number for future comparisons
            set.add(n);
        }

        // No valid pair found
        return false;
    }
}