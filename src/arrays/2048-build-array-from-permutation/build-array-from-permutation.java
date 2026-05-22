class Solution {
    public int[] buildArray(int[] nums) {
        int[] answer = new int[nums.length];
        int i = 0;
        for(int num: nums){
            answer[i] = nums[num];
            i++;
        }
        return answer;
    }
}