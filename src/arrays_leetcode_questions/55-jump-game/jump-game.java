class Solution {
    public boolean canJump(int[] nums) {
        int furthestIndex = 0;

        for(int i = 0; i<nums.length-1; i++){
            if(i<=furthestIndex){
                if(furthestIndex < i + nums[i]){
                    furthestIndex = i + nums[i];
                    System.out.println(furthestIndex);
                }
            }
            
            if(furthestIndex >= nums.length-1){
                return true;
            }
        }

        if(furthestIndex >= nums.length-1){
                return true;
        }

            return false;
    }
}