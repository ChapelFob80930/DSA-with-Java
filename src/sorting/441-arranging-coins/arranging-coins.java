class Solution {
    public int arrangeCoins(int n) {

        // Search space for the number of complete rows
        int start = 1;
        int end = n;

        while (start <= end) {

            // Find the middle row count to test
            int mid = start + (end - start) / 2;

            // Calculate the number of coins needed to build 'mid' rows
            // Using long to prevent integer overflow
            long numOfCoinsForMidNumRows = (long) mid * (mid + 1) / 2;

            // Exact match: we can build exactly 'mid' complete rows
            if (numOfCoinsForMidNumRows == n) {
                return mid;
            }

            // If more coins are needed than available,
            // search in the left half
            if (numOfCoinsForMidNumRows > n) {
                end = mid - 1;
            }

            // If fewer coins are needed than available,
            // try building more rows by searching in the right half
            else if (numOfCoinsForMidNumRows < n) {
                start = mid + 1;
            }
        }

        // When the loop ends, 'end' points to the largest
        // valid number of complete rows that can be formed
        return end;
    }
}