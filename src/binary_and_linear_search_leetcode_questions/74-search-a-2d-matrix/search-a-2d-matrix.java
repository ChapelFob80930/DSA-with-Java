class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        // Find the only row that could possibly contain target
        int solRow = findRow(matrix, target);

        // No valid row found => target cannot exist
        if (solRow == -1) {
            return false;
        }

        // Perform binary search within the candidate row
        return binarySearch(matrix[solRow], target);
    }

    /*
     * Since:
     * matrix[i][last] < matrix[i + 1][0]
     *
     * Each row represents a separate sorted range.
     *
     * Example:
     * [ 1,  3,  5,  7]   -> Range [1, 7]
     * [10, 11, 16, 20]   -> Range [10, 20]
     * [23, 30, 34, 60]   -> Range [23, 60]
     *
     * We binary search on these row ranges.
     *
     * --------------------------------------------------
     * CASE 1:
     * matrix[row][0] > target
     *
     * Example:
     * target = 8
     * Current row range = [10, 20]
     *
     * Since:
     * 10 > 8
     *
     * Target cannot be in this row or any row below it,
     * because all those rows start with values >= 10.
     *
     * Move UP:
     * bottom = row - 1
     *
     * --------------------------------------------------
     * CASE 2:
     * matrix[row][last] < target
     *
     * Example:
     * target = 25
     * Current row range = [10, 20]
     *
     * Since:
     * 20 < 25
     *
     * Target cannot be in this row or any row above it,
     * because all those rows end with values <= 20.
     *
     * Move DOWN:
     * top = row + 1
     *
     * --------------------------------------------------
     * CASE 3:
     * matrix[row][0] <= target <= matrix[row][last]
     *
     * Example:
     * target = 16
     * Current row range = [10, 20]
     *
     * Since:
     * 10 <= 16 <= 20
     *
     * This is the ONLY row that can contain target.
     *
     * Return this row.
     *
     * --------------------------------------------------
     * CASE 4: Return -1
     *
     * Example:
     * target = 8
     *
     * Ranges:
     * [1, 7]
     * [10, 20]
     * [23, 60]
     *
     * 8 is not inside any row range.
     *
     * Eventually:
     * top > bottom
     *
     * Therefore no valid row exists.
     *
     * Return -1.
     */
    public int findRow(int[][] matrix, int target) {

        int top = 0;
        int bottom = matrix.length - 1;

        while (top <= bottom) {

            int row = top + (bottom - top) / 2;

            // Target must be in an earlier row
            if (matrix[row][0] > target) {
                bottom = row - 1;
            }

            // Target must be in a later row
            else if (matrix[row][matrix[row].length - 1] < target) {
                top = row + 1;
            }

            // Target lies within this row's range
            else {
                return row;
            }
        }

        // No row can contain target
        return -1;
    }

    /*
     * Standard binary search on a sorted array.
     *
     * Example:
     * [10, 11, 16, 20]
     *
     * target = 16
     *
     * CASE 1:
     * arr[mid] > target
     * Search left half
     *
     * CASE 2:
     * arr[mid] < target
     * Search right half
     *
     * CASE 3:
     * arr[mid] == target
     * Target found
     *
     * Time: O(log n)
     */
    public boolean binarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return true;
            }

            // Search left half
            else if (arr[mid] > target) {
                end = mid - 1;
            }

            // Search right half
            else {
                start = mid + 1;
            }
        }

        return false;
    }
}

/*
 * Time Complexity:
 *
 * Finding candidate row:
 * O(log m)
 *
 * Binary search inside row:
 * O(log n)
 *
 * Total:
 * O(log m + log n)
 * = O(log(m * n))
 *
 * Space Complexity:
 * O(1)
 */