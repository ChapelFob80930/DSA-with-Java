// Odd -> one step to make it even.
// Even -> one step to cut the number roughly in half.
//
// This is why the complexity is O(log n) rather than O(n).
class Solution {

    /*
     * LeetCode 1342: Number of Steps to Reduce a Number to Zero
     *
     * Rules:
     * 1. If the number is even, divide it by 2.
     * 2. If the number is odd, subtract 1.
     * 3. Count how many operations are needed to reach 0.
     *
     * Recursive Idea:
     * - Each recursive call performs exactly one operation.
     * - Add 1 for the current operation and recursively solve
     *   the smaller subproblem.
     *
     * Example: num = 14
     *
     * 14 -> 7  (divide by 2)
     * 7  -> 6  (subtract 1)
     * 6  -> 3  (divide by 2)
     * 3  -> 2  (subtract 1)
     * 2  -> 1  (divide by 2)
     * 1  -> 0  (subtract 1)
     *
     * Total steps = 6
     *
     * Recursion Tree:
     *
     * numberOfSteps(14)
     * = 1 + numberOfSteps(7)
     * = 1 + 1 + numberOfSteps(6)
     * = 1 + 1 + 1 + numberOfSteps(3)
     * = ...
     * = 6
     *
     * Base Case:
     * When num becomes 0, no more operations are needed.
     *
     * Time Complexity: O(log n)
     * - Even numbers are halved each time.
     * - Odd numbers require one subtraction before becoming even.
     *
     * Space Complexity: O(log n)
     * - Due to recursive call stack.
     */
    public int numberOfSteps(int num) {

        // Reached 0, no more operations needed.
        if (num == 0) {
            return 0;
        }

        // Odd number: subtract 1.
        if (num % 2 != 0) {
            return 1 + numberOfSteps(num - 1);
        }

        // Even number: divide by 2.
        return 1 + numberOfSteps(num / 2);
    }
}