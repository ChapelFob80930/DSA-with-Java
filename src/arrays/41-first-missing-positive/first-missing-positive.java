class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        // Hash array to track which numbers are present
        // Size = n + 1 because:
        // we need indices from 0 to n
        // and we only care about numbers from 1 to n
        int[] hash = new int[n + 1];

        // Traverse the original array
        for(int i = 0; i < n; i++){

            // Ignore useless numbers:
            // 1. numbers <= 0
            // 2. numbers > n
            //
            // Why?
            // Because for an array of size n,
            // the first missing positive must lie between 1 and n+1
            if(nums[i] > n || nums[i] <= 0){

                // Replace with dummy value
                // (not really needed for hashing approach,
                // but keeps invalid values separated)
                nums[i] = n + 1;
            }
            else{

                // Mark the number as present
                //
                // Example:
                // nums[i] = 3
                // hash[3] becomes 1
                hash[nums[i]] += 1;
            }
        }

        // Find the first positive number
        // that was never marked
        for(int i = 1; i <= n; i++){

            // Frequency 0 means missing
            if(hash[i] == 0){
                return i;
            }
        }

        // If all numbers from 1 to n exist,
        // then answer must be n+1
        return n + 1;
    }
}