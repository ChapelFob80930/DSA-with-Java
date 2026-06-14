class Solution {
    public boolean isPerfectSquare(int num) {
        
        // Search space: possible square roots lie between 1 and num
        int start = 1;
        int end = num;

        // Binary search for the square root
        while (start <= end) {

            // Find the middle value safely to avoid integer overflow
            int mid = start + (end - start) / 2;

            // Use long to prevent overflow when calculating mid * mid
            long square = (long) mid * (long) mid;

            // If mid² equals num, num is a perfect square
            if (square == (long) num) {
                return true;
            }

            // If mid² is smaller than num,
            // the square root must be on the right side
            else if (square < (long) num) {
                start = mid + 1;
            }

            // If mid² is larger than num,
            // the square root must be on the left side
            else {
                end = mid - 1;
            }
        }

        // No integer square root found
        return false;
    }
}