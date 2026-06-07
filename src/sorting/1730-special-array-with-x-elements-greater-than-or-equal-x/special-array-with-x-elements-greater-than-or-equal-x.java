class Solution {
    public int specialArray(int[] nums) {
        int ans = -1;
        for (int i = 0;i<=nums.length;i++){
            int cnt = 0;
            for(int n:nums){
                if(n>=i){
                    cnt++;
                }
            }
            if(cnt == i && cnt!=0){
                ans = cnt;
                return ans;
            }
        }
        return -1;
    }
}