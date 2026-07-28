class Solution {  
 
    // The problem asks for the answer modulo 1e9+7.
    //
    // Using a constant is much faster than repeatedly calling:
    // (long)(Math.pow(10, 9) + 7)
    //
    // We apply modulo after every addition because:
    // (a + b) % MOD = ((a % MOD) + (b % MOD)) % MOD
    //
    // This keeps the running sum small, prevents overflow, and is the
    // standard pattern used in counting DP problems.
    static final int MOD = 1_000_000_007;

    public int numRollsToTarget(int n, int k, int target) {

        // DP State:
        // dp[diceRemaining][targetRemaining]
        //
        // Stores the number of ways to obtain "targetRemaining"
        // using "diceRemaining" dice.
        //
        // We use Integer instead of int because:
        // null -> state not computed yet
        // value -> already computed
        Integer[][] dp = new Integer[n + 1][target + 1];

        return countNumRolls(n, k, target, dp);
    }

    public int countNumRolls(int n, int k, int target, Integer[][] dp) {

        // ---------------- BASE CASES ----------------

        // Overshot the required target.
        // Since every die contributes at least 1,
        // it is impossible to reach 0 from a negative target.
        if (target < 0) {
            return 0;
        }

        // No dice left.
        //
        // If target is also 0, we've formed a valid combination.
        // Otherwise, this path is invalid.
        if (n == 0) {
            return target == 0 ? 1 : 0;
        }

        // ---------------- MEMOIZATION ----------------

        // If this state has already been computed,
        // simply return the stored answer instead of
        // recomputing the entire recursion tree.
        //
        // State = (diceRemaining, targetRemaining)
        if (dp[n][target] != null) {
            return dp[n][target];
        }

        long cnt = 0;

        // Try every possible face value of the current die.
        //
        // If we roll i,
        // then we have one fewer die remaining,
        // and the remaining target decreases by i.
        for (int i = 1; i <= k; i++) {

            // Keep the running answer modulo MOD.
            //
            // This avoids overflow while producing the
            // same final answer due to modulo arithmetic.
            cnt = (cnt + countNumRolls(n - 1, k, target - i, dp)) % MOD;
        }

        // Store the computed answer so future calls
        // with the same state return instantly.
        dp[n][target] = (int) cnt;

        return dp[n][target];
    }
}