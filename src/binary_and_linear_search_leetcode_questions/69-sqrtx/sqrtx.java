class Solution {
    public int mySqrt(int x) {

        // Search space for the possible square root lies between 0 and x
        long start = 0;
        long end = x;

        // Binary search on the answer
        while (start <= end) {

            // Calculate middle element safely to avoid overflow
            long mid = start + (end - start) / 2;

            // Square of the current middle value
            long square = mid * mid;

            // Perfect square found
            if (square == x) {
                return (int) mid;
            }

            // If square is too large, search in the left half
            else if (square > x) {
                end = mid - 1;
            }

            // If square is too small, search in the right half
            else {
                start = mid + 1;
            }
        }

        // When the loop ends:
        // end points to the largest number whose square is <= x
        // which is the integer part (floor) of √x
        return (int) end;
    }
}