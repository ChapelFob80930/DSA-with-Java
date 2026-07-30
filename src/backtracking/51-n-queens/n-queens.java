class Solution {
    public List<List<String>> solveNQueens(int n) {
        return queens(new boolean[n][n], 0);
    }

    static List<List<String>> queens(boolean[][] board, int row) {

        List<List<String>> ans = new ArrayList<>();

        if(row == board.length){
            ans.add(display(board));
            return ans;
        }

        for(int col = 0; col<board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = true;
                ans.addAll(queens(board, row + 1));
                board[row][col] = false;
            }
        }

        return ans;
    }

    static boolean isSafe(boolean[][] board, int row, int col){
        // checking vertical row
        for(int r = 0; r<row; r++){
            if(board[r][col]){
                return false;
            }
        }


        // checking left diagonal
        int boundary = Math.min(row, col);

        for(int i = 1; i<=boundary; i++){
            if(board[row-i][col-i]){
                return false;
            }
        }

        // checking right diagonal
        boundary = Math.min(row, board.length - 1 - col);

        for(int i = 1; i<=boundary; i++){
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;
    }

    static ArrayList<String> display(boolean[][] board){

        
        ArrayList<String> boardState = new ArrayList<>();

        for(boolean[] row: board){
            String s = "";
            for(boolean cell: row){
                s = s + (cell ? "Q" : ".");
            }
            boardState.add(s);
        }

        return boardState;
        
    }
}