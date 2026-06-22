// Amazon // Microsoft
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        cycleSort(nums);

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=i+1){
                ans.add(nums[i]);
            }
        }

        return ans;
    }

    public void cycleSort(int[] nums){
        int i = 0;

        while(i < nums.length){

            int correct = nums[i]-1;

            if(nums[i] != nums[correct]){

                swap(nums, i, correct);
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