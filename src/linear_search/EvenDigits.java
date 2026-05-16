package linear_search;

// Link to LeetCode problem :- https://leetcode.com/problems/find-numbers-with-even-number-of-digits/submissions/2004288005/?envType=problem-list-v2&envId=array

public class EvenDigits {

    public int findNumbers(int[] nums) { //2ms
        int count = 0;
        for(int x: nums){
            if(Integer.toString(x).length() % 2 ==0){
                count++;
            }
        }
        return count;
    }

    public int findNumbers2(int[] nums) {  //1ms
        int even = 0;
        for(int x: nums){
            if(x<0)
            {
                x = x*-1;
            }
            if(x==0)
            {
                continue;
            }
            int count = 0;
            while(x>0){
                count++;
                x = x/10;
            }
            if(count % 2 ==0){
                even ++;
            }
        }
        return even;
    }

    public int findNumbers3(int[] nums) { //1ms
        int count = 0;
        for(int x: nums){
            if(x<0)
            {
                x = x*-1;
            }

            if(x==0)
            {
                continue;
            }

            if((int)(Math.log10(x) + 1) % 2 == 0)
            {
                count++;
            }

        }
        return count;
    }

}
