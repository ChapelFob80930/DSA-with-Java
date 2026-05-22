class Solution {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] answer = new int[2 * len];

        for(int i = 0; i < len; i++){
            answer[i] = nums[i];
            answer[i + len] = nums[i];
        }

        return answer;
    }
}