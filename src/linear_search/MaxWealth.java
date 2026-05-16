package linear_search;

// Link to LeetCode problem :- https://leetcode.com/problems/richest-customer-wealth/description/?envType=problem-list-v2&envId=array

public class MaxWealth {

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

    public int maximumWealth2(int[][] accounts) {
        int max_wealth = Integer.MIN_VALUE;;
        for (int[] account : accounts) {
            int total = 0;
            for (int amt : account) {
                total += amt;
            }
            if (total > max_wealth) {
                max_wealth = total;
            }
        }
        return max_wealth;
    }

}
