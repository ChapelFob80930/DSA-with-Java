class Solution {
    public boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;

        while(start<=end){
            int mid = start + (end - start) / 2;
            
            long square = (long)mid * (long)mid;

            if(square == (long)num){
                return true;
            }

            else if(square < (long)num){
                start = mid + 1;
            }

            else{
                end = mid - 1;
            }
        }

        return false;
    }
}