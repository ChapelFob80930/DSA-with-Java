class Solution { 
    public void setZeroes(int[][] matrix) {

        // These booleans store whether the ORIGINAL
        // first row or first column contained a zero.
        // Needed because first row/column will later
        // be used as marker storage.
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if first row originally contains any 0
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                firstRowZero = true;
            }
        }

        // Check if first column originally contains any 0
        for(int j = 0; j < matrix.length; j++){
            if(matrix[j][0] == 0){
                firstColZero = true;
            }
        }

        // Use first row and first column as markers
        // If matrix[i][j] == 0:
        // mark its entire row and column for zeroing
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){

                if(matrix[i][j] == 0){

                    // Mark column
                    matrix[0][j] = 0;

                    // Mark row
                    matrix[i][0] = 0;
                }
            }
        }

        // Traverse inner matrix again
        // If corresponding row or column marker is 0,
        // make current cell 0
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){

                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // If original first row had a zero,
        // make entire first row zero
        if(firstRowZero){

            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }

        // If original first column had a zero,
        // make entire first column zero
        if(firstColZero){

            for(int j = 0; j < matrix.length; j++){
                matrix[j][0] = 0;
            }
        }
    }
}
