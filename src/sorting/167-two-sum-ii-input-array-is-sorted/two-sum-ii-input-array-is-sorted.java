class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int start = 0;
        int end = numbers.length-1;

        while(start<end){
            System.out.println("start: "+start);
            System.out.println("end: "+end);
            if(numbers[start] + numbers[end] == target){
                return new int[] {start + 1, end + 1};
            }

            else if(numbers[start] + numbers[end] < target){
                start ++;
            }

            else if(numbers[start] + numbers[end] > target){
                end --;
            }
        }

        return new int[] {};

    }
}