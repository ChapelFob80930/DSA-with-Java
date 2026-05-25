class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for(int i = 0; i<matrix[0].length; i++){
            if(matrix[0][i]==0){
                firstRowZero = true;
            }
        }

        for(int j = 0; j<matrix.length; j++){
            if(matrix[j][0]==0){
                firstColZero = true;
            }
        }

        for(int i = 1; i<matrix.length; i++){
            for(int j = 1; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){ // if matrix at (i,j) is zero set markers to 0
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i<matrix.length; i++){
            for(int j = 1; j<matrix[0].length; j++){
                if((matrix[0][j] == 0 || matrix[i][0] == 0) && matrix[i][j] != 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstRowZero){
            for(int i = 0; i<matrix[0].length; i++){
                matrix[0][i]=0;
            }
        }

        if(firstColZero){
            for(int j = 0; j<matrix.length; j++){
                matrix[j][0]=0;
            }   
        }
    }
}