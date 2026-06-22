//amazon
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = (n + 1) * n / 2;
        int actualSum = 0;
        for(int num: nums){
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}