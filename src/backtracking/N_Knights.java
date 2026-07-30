package backtracking;

public class N_Knights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];

        // Place n knights on an n x n chessboard.
        knight(board, 0, 0, n);
    }

    /**
     * Backtracking function that places the remaining knights on the board.
     *
     * Traversal order:
     * (0,0) -> (0,1) -> ... -> (0,n-1)
     *    ↓
     * (1,0) -> (1,1) -> ...
     *
     * For every cell we have two choices:
     * 1. Place a knight (only if it's safe).
     * 2. Skip the cell.
     *
     * Parameters:
     * row     - current row being explored
     * col     - current column being explored
     * knights - number of knights still left to place
     */
    static void knight(boolean[][] board, int row, int col, int knights) {

        // Base Case:
        // Successfully placed all required knights.
        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }

        // We have finished traversing the entire board
        // and still have knights left.
        // No valid arrangement exists along this path.
        if (row == board.length - 1 && col == board.length) {
            return;
        }

        // End of current row reached.
        // Move to the first column of the next row.
        if (col == board.length) {
            knight(board, row + 1, 0, knights);
            return;
        }

        // Choice 1: Place a knight if it doesn't attack
        // any previously placed knight.
        if (isSafe(board, row, col)) {
            board[row][col] = true;

            // Explore further with one less knight.
            knight(board, row, col + 1, knights - 1);

            // Backtrack:
            // Remove the knight so other possibilities
            // can reuse this cell.
            board[row][col] = false;
        }

        // Choice 2: Skip this cell.
        knight(board, row, col + 1, knights);
    }

    /**
     * Checks whether the given cell lies inside the board.
     * Prevents ArrayIndexOutOfBoundsException while checking
     * knight attack positions.
     */
    static boolean isValid(boolean[][] board, int row, int col) {
        return row >= 0 &&
                row < board.length &&
                col >= 0 &&
                col < board.length;
    }

    /**
     * Determines whether a knight can be safely placed
     * at (row, col).
     *
     * Since we traverse the board from top-left to bottom-right,
     * only previously visited cells can contain knights.
     *
     * Therefore we only check the four attack positions that
     * could already have a knight:
     *
     *      K       K
     *        \   /
     *         (row,col)
     *        /   \
     *      K       K
     *
     * Coordinates checked:
     * (row-2, col-1)
     * (row-2, col+1)
     * (row-1, col-2)
     * (row-1, col+2)
     *
     * The remaining four knight moves point downward,
     * and those cells haven't been visited yet.
     */
    static boolean isSafe(boolean[][] board, int row, int col) {

        if (isValid(board, row - 2, col - 1) &&
                board[row - 2][col - 1]) {
            return false;
        }

        if (isValid(board, row - 2, col + 1) &&
                board[row - 2][col + 1]) {
            return false;
        }

        if (isValid(board, row - 1, col + 2) &&
                board[row - 1][col + 2]) {
            return false;
        }

        if (isValid(board, row - 1, col - 2) &&
                board[row - 1][col - 2]) {
            return false;
        }

        return true;
    }

    /**
     * Prints the current board configuration.
     *
     * K -> Knight
     * . -> Empty square
     */
    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean cell : row) {
                System.out.print(cell ? "K " : ". ");
            }
            System.out.println();
        }
    }
}