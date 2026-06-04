class Solution {
    public int arrangeCoins(int n) {
        int start = 1;
        int end = n;

        while(start<=end){
            int mid = start + (end - start) / 2;

            long numOfCoinsForMidNumRows = (long)mid*(mid+1)/2;

            if(numOfCoinsForMidNumRows == n){
                return mid;
            }

            if(numOfCoinsForMidNumRows > n){
                end = mid - 1;
            }

            else if(numOfCoinsForMidNumRows < n){
                start = mid + 1;
            }
        }
        return end;
    }    
}