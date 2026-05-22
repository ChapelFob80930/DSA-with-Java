class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        // A 2D matrix is stored row-by-row like a linear 1D sequence in memory.
        // Example:
        // 1 2
        // 3 4
        // becomes -> [1, 2, 3, 4]
        //
        // So instead of moving elements manually,
        // we use the same linear index (idx) in both matrices.
        //
        // oldRow = idx / oldCols
        // oldCol = idx % oldCols
        //
        // newRow = idx / newCols
        // newCol = idx % newCols
        //
        // Changing only the number of columns automatically
        // gives the new reshaped position while preserving order.

        if(r*c != mat.length*mat[0].length){ //check if total number of elements is the same
            return mat;
        }

        int[][] ans = new int[r][c];
        int totalOldCol = mat[0].length;

        for(int i = 0; i<mat.length*mat[0].length; i++){ //iterate over all elements

            ans[i/c][i%c] = mat[i/totalOldCol][i%totalOldCol];

        }
        

        return ans;
    }
}