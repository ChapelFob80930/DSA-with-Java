class Solution {
    public int mySqrt(int x) {
        
        long start = 0;
        long end = x;

        while(start<=end){
            long mid = start + (end-start) / 2;
            long square = mid*mid;
            if(square == x){
                return (int)mid;
            }
            else if(square > x){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return (int)end;
    }
}