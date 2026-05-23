class Solution {
    public int removeDuplicates(int[] nums) {

        int prev = 0;
        int cnt = 0;
        int[] ans = new int[nums.length];
        int j = 0;

        for(int i = 0; i<nums.length; i++){
            
            if(prev == nums[i] && i!=0){
                continue;
            }

            cnt++;
            prev = nums[i];

            ans[j] = nums[i];
            j++;    

        }

        for(int i = 0; i<cnt; i++){
            nums[i] = ans[i];
        }

        System.out.println(Arrays.toString(ans));

        return cnt;
    }
}