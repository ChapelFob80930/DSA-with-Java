//asked in google
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans= new ArrayList<>();

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

        for(int j = 0; j<nums.length; j++){
            if(nums[j] != j+1){
                ans.add(j+1);
            }
        }

        return ans;
    }


    public static void swap(int[] arr, int index1, int index2){

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}