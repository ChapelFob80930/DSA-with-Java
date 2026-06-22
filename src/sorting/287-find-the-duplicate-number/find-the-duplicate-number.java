//amazon
class Solution {
    public int findDuplicate(int[] nums) {

        return cycleSort(nums);
        
    }


    public int cycleSort(int[] nums){
        int i = 0;

        while(i < nums.length){

            int correct = nums[i] - 1;

            if(nums[i] != nums[correct]){

                swap(nums, i, correct);

            }

            else if(nums[i] == nums[correct] && i!=correct){
                return nums[i];
            }

            else{

                i++;
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