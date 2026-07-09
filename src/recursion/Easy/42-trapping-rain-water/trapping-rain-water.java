class Solution {
    public int trap(int[] height) {
        int leftMax = height[0];
        int rightMax = height[height.length-1];
        int l = 0;
        int r = height.length-1;
        int res = 0;

        while(l<r){
            if(leftMax <= rightMax){
                l++;
                leftMax = Math.max(leftMax, height[l]);
                int waterAtIndex = leftMax - height[l];
                res += waterAtIndex;
            }

            else{
                r--;
                rightMax = Math.max(rightMax, height[r]);
                int waterAtIndex = rightMax - height[r];
                res += waterAtIndex;
            }
        }

        return res;
        
    }
}