class Solution {
    public int[] findErrorNums(int[] nums) {
        cycleSort(nums);

        for(int i=0; i<nums.length; i++){
            if(nums[i] != i+1){
                return new int[] {nums[i], i+1};
            }
        }

        return new int[] {};
    }

    public void cycleSort(int[] arr){
        
        int i = 0;

        while(i<arr.length){
            
            int correct = arr[i] - 1;

            if(arr[i]!=arr[correct]){
                swap(arr, i, correct);
            }

            else{
                i++;
            }
        }
    }

    public static void swap(int[] arr, int index1, int index2){

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}