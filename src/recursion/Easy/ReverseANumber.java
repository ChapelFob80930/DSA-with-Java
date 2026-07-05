package recursion.Easy;

public class ReverseANumber {

    // Used by rev1() to store the reversed number.
    static int sum = 0;

    public static void main(String[] args) {
        rev1(1342);
        System.out.println(sum);      // 2431

        System.out.println(rev2(54321)); // 12345
    }

    /*
     * Method 1: Reverse a number using an external variable.
     *
     * Example:
     * 1342
     * sum = 0
     *
     * sum = 0 * 10 + 2 = 2
     * sum = 2 * 10 + 4 = 24
     * sum = 24 * 10 + 3 = 243
     * sum = 243 * 10 + 1 = 2431
     *
     * Time Complexity: O(d)
     * Space Complexity: O(d) due to recursion stack
     *
     * d = number of digits
     */
    private static void rev1(int n) {
        if (n == 0) {
            return;
        }

        int rem = n % 10;      // Extract last digit
        sum = sum * 10 + rem;  // Append digit to reversed number

        rev1(n / 10);          // Process remaining digits
    }

    /*
     * Method 2: Pure recursive approach (no global variable).
     *
     * Idea:
     * Move each last digit to its correct position in the reversed number.
     *
     * Example: rev2(54321)
     *
     * 1 * 10^4 + rev2(5432)
     * 2 * 10^3 + rev2(543)
     * 3 * 10^2 + rev2(54)
     * 4 * 10^1 + rev2(5)
     * 5
     *
     * = 10000 + 2000 + 300 + 40 + 5
     * = 12345
     *
     * digits = total digits currently present in n
     * digits - 1 gives the highest place value.
     *
     * Example:
     * n = 54321
     * digits = 5
     * highest position = 10^(5 - 1) = 10000
     *
     * Base Case:
     * When a single digit remains, return it.
     *
     * Time Complexity: O(d)
     * Space Complexity: O(d)
     */
    private static int rev2(int n) {
        if (n % 10 == n) {
            return n; // Single digit
        }

        int digits = (int) (Math.log10(n)) + 1;

        return (n % 10) * (int) Math.pow(10, digits - 1)
                + rev2(n / 10);
    }
}

// rev1() uses state (global variable)
// rev2() is a pure recursive solution
//
// In interviews, rev2() is usually preferred because it does not
// depend on external state and works independently for every call.