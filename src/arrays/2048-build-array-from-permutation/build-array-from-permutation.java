class Solution {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0;
        for(int num: nums){
            ans[i] = nums[num];
            i++;
        }
        return ans;
    }
}