/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return       -1 if num is higher than the picked number
 *                1 if num is lower than the picked number
 *                0 if num is correct
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {

        // Search space: the picked number lies between 1 and n
        int start = 1;
        int end = n;

        // Binary search until the search space is exhausted
        while (start <= end) {

            // Calculate middle safely to avoid integer overflow
            int mid = start + (end - start) / 2;

            // Check how mid compares to the picked number
            int result = guess(mid);

            // Found the correct number
            if (result == 0) {
                return mid;
            }

            // Picked number is greater than mid,
            // so search in the right half
            else if (result == 1) {
                start = mid + 1;
            }

            // Picked number is smaller than mid,
            // so search in the left half
            else if (result == -1) {
                end = mid - 1;
            }
        }

        // This line should never be reached for valid inputs
        return -1;
    }
}