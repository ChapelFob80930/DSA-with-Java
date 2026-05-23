class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0;

        for(int num1: nums){
            int count = 0;
            for(int num2: nums){
                if(num1 > num2){
                    count++;
                }
            }
            ans[i] = count;
            i++;
        }

        return ans;

    }

    // for(int i = 0; i<nums.length; i++){

    //         int count = 0;

    //         for(int j = 0; j<nums.length; j++){

    //             if(i == j){
    //                 continue;
    //             }

    //             if(nums[i] > nums[j]){
    //                 count++;
    //             }
    //         }

    //         ans[i] = count;

    //     }


    //     return ans;
}