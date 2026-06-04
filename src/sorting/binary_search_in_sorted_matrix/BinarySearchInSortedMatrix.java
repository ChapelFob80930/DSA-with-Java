package sorting.binary_search_in_sorted_matrix;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchInSortedMatrix {

    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        Scanner sc = new Scanner(System.in);

        // Input target element to search
        System.out.print("Target: ");
        int target = sc.nextInt();

        // Search for the target in the matrix
        int[] index = search(arr, target);

        if (index[0] != -1) {
            System.out.println(target + " found at index "
                    + Arrays.toString(index));
        } else {
            System.out.println(target + " not found in matrix");
        }
    }

    /**
     * Performs binary search on a specific row.
     */
    public static int[] binarySearch(int[][] matrix,
                                     int row,
                                     int colStart,
                                     int colEnd,
                                     int target) {

        while (colStart <= colEnd) {

            int mid = colStart + (colEnd - colStart) / 2;

            if (matrix[row][mid] == target) {
                return new int[]{row, mid};
            }

            else if (matrix[row][mid] < target) {
                colStart = mid + 1;
            }

            else {
                colEnd = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }

    /**
     * Searches a target in a row-wise and column-wise sorted matrix.
     */
    public static int[] search(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Special case: matrix has only one column.
        // Perform binary search vertically on rows.
        if (cols == 1) {

            int rowStart = 0;
            int rowEnd = rows - 1;

            while (rowStart <= rowEnd) {

                int mid = rowStart + (rowEnd - rowStart) / 2;

                if (matrix[mid][0] == target) {
                    return new int[]{mid, 0};
                }

                else if (matrix[mid][0] < target) {
                    rowStart = mid + 1;
                }

                else {
                    rowEnd = mid - 1;
                }
            }

            return new int[]{-1, -1};
        }

        // Special case: matrix has only one row.
        // Apply normal binary search on that row.
        if (rows == 1) {
            return binarySearch(matrix, 0, 0, cols - 1, target);
        }

        int rowStart = 0;
        int rowEnd = rows - 1;
        int colMid = cols / 2;

        // Reduce the matrix to exactly two rows
        // by checking elements in the middle column.
        while (rowStart < (rowEnd - 1)) {

            int mid = rowStart + (rowEnd - rowStart) / 2;

            if (matrix[mid][colMid] == target) {
                return new int[]{mid, colMid};
            }

            // Target must be below this row
            else if (matrix[mid][colMid] < target) {
                rowStart = mid;
            }

            // Target must be above this row
            else {
                rowEnd = mid;
            }
        }

        // At this point only two rows remain:
        // rowStart and rowStart + 1

        // Check the middle column of both rows first
        if (matrix[rowStart][colMid] == target) {
            return new int[]{rowStart, colMid};
        }

        if (matrix[rowStart + 1][colMid] == target) {
            return new int[]{rowStart + 1, colMid};
        }

        /*
                    colMid
                       ↓

            rowStart     [ Q1 | Q2 ]
            rowStart+1   [ Q3 | Q4 ]

           Search only the quadrant that can contain the target.
         */

        // Search in Q1 (top-left)
        if (target <= matrix[rowStart][colMid - 1]) {
            return binarySearch(
                    matrix,
                    rowStart,
                    0,
                    colMid - 1,
                    target
            );
        }

        // Search in Q2 (top-right)
        else if (target >= matrix[rowStart][colMid + 1]
                && target <= matrix[rowStart][cols - 1]) {

            return binarySearch(
                    matrix,
                    rowStart,
                    colMid + 1,
                    cols - 1,
                    target
            );
        }

        // Search in Q3 (bottom-left)
        else if (target <= matrix[rowStart + 1][colMid - 1]) {

            return binarySearch(
                    matrix,
                    rowStart + 1,
                    0,
                    colMid - 1,
                    target
            );
        }

        // Search in Q4 (bottom-right)
        else {

            return binarySearch(
                    matrix,
                    rowStart + 1,
                    colMid + 1,
                    cols - 1,
                    target
            );
        }
    }
}