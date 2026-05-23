class Solution {
    public int removeDuplicates(int[] nums) {
        int unique = 1;
        int current = 1;

        while(current < nums.length){
            System.out.println("Current: "+current);
            if(nums[current] != nums[current-1]){
                System.out.println("entered");
                nums[unique] = nums[current];
                unique++;
            }
                                                                           
            current++;
                                                                                            
        }

                                                                                            
        System.out.println(Arrays.toString(nums));
                                                                                                                                
        return unique;

                                                                                            
    }
                                                                                            
}
