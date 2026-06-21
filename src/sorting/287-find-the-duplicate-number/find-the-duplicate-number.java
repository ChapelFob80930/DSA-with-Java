class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;

        while(i < nums.length){

            int correct = nums[i];

            if(nums[i] != nums[correct]){

                swap(nums, i, correct);
            }

            else{

                i++;
            }

        }

        for(int j = 0; j<nums.length; j++){
            if(nums[j]!=j+1){
                return nums[j];
            }
        }

        return -1;
    }


    public static void swap(int[] arr, int index1, int index2){

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}