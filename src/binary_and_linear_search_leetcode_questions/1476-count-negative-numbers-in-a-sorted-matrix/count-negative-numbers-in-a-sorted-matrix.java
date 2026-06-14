class Solution {
    public int countNegatives(int[][] grid) {

        // Start from the top-right corner
        int r = 0;
        int c = grid[0].length - 1;

        int cnt = 0;

        // Continue while we're inside the matrix
        while (r < grid.length && c >= 0) {

            // If current element is negative
            if (grid[r][c] < 0) {

                /*
                 * Since the matrix is sorted column-wise in non-increasing order,
                 * every element below grid[r][c] in the same column is also negative.
                 *
                 * Number of negatives in this column from row r onward:
                 * grid.length - r
                 */
                cnt += grid.length - r;

                // Move left to check the next column
                c--;
            } else {

                /*
                 * Current element is non-negative.
                 *
                 * Since the row is sorted in non-increasing order,
                 * every element to the left is >= current element,
                 * so they are also non-negative.
                 *
                 * Therefore, this row cannot contribute any negatives
                 * in the current column or to its left.
                 * Move down to the next row.
                 */
                r++;
            }
        }

        return cnt;
    }
}