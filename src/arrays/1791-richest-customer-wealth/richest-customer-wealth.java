class Solution {
    public int maximumWealth(int[][] accounts) {
        int max_wealth = Integer.MIN_VALUE;;
        for(int customer = 0; customer < accounts.length; customer++){
            int total = 0;
            for(int amt: accounts[customer]){
                total += amt;
            }
            if(total > max_wealth){
                max_wealth = total;
            }
        }
        return max_wealth;
    }
}