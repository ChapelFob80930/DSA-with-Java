class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] dp = new Integer[n+1][target+1];
        return countNumRolls(n, k, target, 0, dp);
    }

    public int countNumRolls(int n, int k, int target, int num, Integer[][] dp){
        
        if(num > target){
            return 0;
        }
        
        if(n == 0){
            if(num == target){
                return 1;
            }
            return 0;
        }

        if(dp[n][num] != null){
            return dp[n][num];
        }

        long cnt = 0;

        for(int i = 1; i<=k; i++){
            cnt = (cnt + countNumRolls(n-1, k, target, num + i, dp)) % (long)(Math.pow(10, 9) + 7);
        }

        dp[n][num] = (int)(cnt);

        return dp[n][num];
    }
}