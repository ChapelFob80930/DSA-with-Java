class Solution {
    public int arrangeCoins(int n) {

        // Counts how many complete rows can be formed
        int cnt = 0;

        // Try building rows one by one
        for (int i = 1; i <= n; i++) {

            // If there are not enough coins to form the current row,
            // stop the process
            if ((n - i) < 0) {
                break;
            }

            // Current row is successfully formed
            cnt++;

            // Remove the coins used in the current row
            n = n - i;
        }

        // Return the number of complete rows formed
        return cnt;
    }
}