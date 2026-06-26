/*
Intuition:
Traverse the board once while keeping track of digits seen in each row,
column, and 3x3 box. If a digit is already present in any of them,
the Sudoku is invalid.
*/
class Solution {
    public boolean isValidSudoku(char[][] board) {

        // row[r]     -> digits already seen in row r
        HashMap<Integer, Set<Character>> row = new HashMap<>();

        // col[c]     -> digits already seen in column c
        HashMap<Integer, Set<Character>> col = new HashMap<>();

        // squares["r/3,c/3"] -> digits already seen in a 3x3 box
        HashMap<String, Set<Character>> squares = new HashMap<>();

        // Traverse every cell once
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                // Ignore empty cells
                if (board[r][c] == '.') {
                    continue;
                }

                // Unique key for the current 3x3 box
                // Example:
                // (1,2) -> "0,0"
                // (5,7) -> "1,2"
                String squareKey = r / 3 + "," + c / 3;

                // Create the set if it doesn't exist, then check
                // whether the current digit has already appeared
                // in the same row, column, or 3x3 box.
                if (row.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
                        col.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) ||
                        squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c])) {
                    return false;
                }

                // First occurrence of this digit.
                // Record it in its row, column, and box.
                row.get(r).add(board[r][c]);
                col.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);
            }
        }

        // No duplicates found anywhere
        return true;
    }
}