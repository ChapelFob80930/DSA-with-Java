class Solution {
    public void setZeroes(int[][] matrix) {
        int[] zeroRows = new int[matrix.length];
        int[] zeroCols = new int[matrix[0].length];
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    zeroRows[i] = 1;
                    zeroCols[j] = 1;
                }
            }
        }

        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(zeroRows[i] == 1 || zeroCols[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }

    }
}