class Solution {

    static final int MOD = 1_000_000_007;

    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] dp = new Integer[n+1][target+1];
        return countNumRolls(n, k, target, dp);
    }

    public int countNumRolls(int n, int k, int target, Integer[][] dp){
        
        if(target<0){
            return 0;
        }

        if(n == 0){
            return target == 0 ? 1 : 0;
        }

        if(dp[n][target] != null){
            return dp[n][target];
        }

        long cnt = 0;

        for(int i = 1; i<=k; i++){
            cnt = (cnt + countNumRolls(n-1, k, target - i, dp)) % MOD;
        }

        dp[n][target] = (int)(cnt);

        return dp[n][target];
    }
}