package backtracking;

public class N_Queens {
    public static void main(String[] args) {

        boolean[][] board = new boolean[4][4];

        System.out.println(queens(board, 0));
    }

    static int queens(boolean[][] board, int row) {
        if(row == board.length){
            display(board);
            System.out.print("\n");
            return 1;
        }

        int count = 0;

        for(int col = 0; col<board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }
        }

        return count;
    }

    static void display(boolean[][] board){
        for(boolean[] row: board){
            for(boolean cell: row){
                System.out.print(cell ? "Q " : ". ");
            }
            System.out.println();
        }
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
}
