class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        int[] hash = new int[n+1];

        for(int i = 0; i < n; i++){
            if(nums[i]>n || nums[i]<=0){
                nums[i] = n+1;
            }
            else{
                hash[nums[i]] += 1 ;
            }
        }

        for(int i = 1; i<=n; i++){
            if(hash[i] == 0){
                return i;
            }
        }

        return n+1;

    }
}