class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        int currentSize = 0;

        for(int i = 0; i < nums.length; i++){

            if(index[i] < currentSize){
                for(int j = currentSize - 1; j >= index[i]; j--){
                    target[j+1] = target[j];
                }
                
            }
            target[index[i]] = nums[i];
            currentSize++;

            // else{
            //     target[index[i]] = nums[i];
            //     currentSize++;
            // }
            
        }

        return target;

    }

}