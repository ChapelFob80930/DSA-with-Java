package backtracking;

import java.util.ArrayList;
import java.util.List;

public class N_Queens_LeetCode_Format {
    /*
===============================================================================
                                N - QUEENS
===============================================================================

Problem
-------
Place N queens on an N × N chessboard such that no two queens attack each other.

A queen attacks:
1. Vertically
2. Horizontally
3. Left diagonal
4. Right diagonal

Example (N = 4)

    Q . . .
    . . Q .
    . . . .
    . . . .

The queen at (0,0) attacks

Vertical:
    Q
    |
    |
    |

Horizontal:
Q - - - -

Diagonals:
Q
 \
  \
   \

and

      /
     /
Q

-------------------------------------------------------------------------------
OBSERVATION
-------------------------------------------------------------------------------

Since we place exactly ONE queen in each recursive call (one row at a time),

Current recursion state:

Row 0   ✔ Queen already placed
Row 1   ✔ Queen already placed
Row 2   <-- currently placing
Row 3   Empty
Row 4   Empty
...

Therefore,

✓ Horizontal checking is NOT required.

Why?

Because each recursive call places only one queen in one row.

There can never be two queens in the same row.

We only need to check:

1. Vertical
2. Upper Left Diagonal
3. Upper Right Diagonal

Notice:
We only check ABOVE the current row because rows below haven't been processed yet.

-------------------------------------------------------------------------------
BACKTRACKING TREE (N = 4)
-------------------------------------------------------------------------------

Start

Row 0

Place at column 0

Q . . .
. . . .
. . . .
. . . .

        |
        V

Row 1

Try column 0 -> unsafe
Try column 1 -> unsafe
Try column 2 -> safe

Q . . .
. . Q .
. . . .
. . . .

        |
        V

Row 2

Try every column

If none works

BACKTRACK

Remove previous queen

Q . . .
. . . .
. . . .
. . . .

Try next column...

This continues until every possibility has been explored.

-------------------------------------------------------------------------------
WHY BACKTRACKING WORKS
-------------------------------------------------------------------------------

At every row we have multiple choices.

Example

Row 0

Q . . .
. Q . .
. . Q .
. . . Q

Each choice creates a completely different future.

Instead of copying the board,

we

1. Place queen
2. Explore
3. Remove queen

This restores the board to its previous state.

This is called BACKTRACKING.

-------------------------------------------------------------------------------
SAFE CHECK
-------------------------------------------------------------------------------

Current cell = (row, col)

Need to verify

1. Same Column

        Q
        |
        |
        X   <- current

2. Upper Left Diagonal

Q
 \
  \
   X

3. Upper Right Diagonal

      Q
     /
    /
   X

No need to check lower cells because they are still empty.

-------------------------------------------------------------------------------
DISPLAY()
-------------------------------------------------------------------------------

Converts boolean[][]

true  -> 'Q'
false -> '.'

Example

Board

true   false false false
false  false true  false
false  false false false
false  true  false false

becomes

[
"Q...",
"..Q.",
"....",
".Q.."
]

This is exactly the format expected by LeetCode.

===============================================================================
RECURRENCE RELATION
===============================================================================

Let T(n) be the time to solve for n remaining rows.

For one row,

we try every column.

There are N choices.

For each valid placement,

we recursively solve the remaining rows.

Ignoring pruning,

T(n) = N * T(n-1) + O(N)

where

O(N)

comes from checking whether the current position is safe.

Why O(N)?

Safe check does

Vertical      -> O(N)
Left diagonal -> O(N)
Right diagonal-> O(N)

Total

O(3N)

which simplifies to

O(N).

-------------------------------------------------------------------------------
HOW THE RECURRENCE IS OBTAINED
-------------------------------------------------------------------------------

Suppose N = 4.

Row 0

Try

Column 0
Column 1
Column 2
Column 3

Total = 4 recursive calls.

Each recursive call solves

remaining 3 rows.

So

T(4)

=

4 × T(3)

+

work done at current row.

Similarly,

T(3)

=

4 × T(2)

+

current work

Hence

T(n)

=

N × T(n-1)

+

O(N)

-------------------------------------------------------------------------------
EXPANDING THE RECURRENCE
-------------------------------------------------------------------------------

T(n)

= N T(n-1)

= N(NT(n-2))

= N²T(n-2)

= ...

= Nⁿ

This is only an upper bound because many branches terminate early.

A tighter analysis gives

N!

because

after placing one queen,

effective choices reduce approximately to

N
N-1
N-2
...

Hence

N × (N-1) × (N-2) ...

= N!

===============================================================================
TIME COMPLEXITY
===============================================================================

Safe Check

O(N)

Each row

tries

N columns

Recursion depth

N

Worst-case search tree

≈ N!

Therefore

Time Complexity

O(N × N!)

The extra N comes from the safety check.

If we optimize safety checking using

boolean[] cols
boolean[] diag1
boolean[] diag2

then safety becomes O(1),

and the complexity becomes

O(N!)

which is the optimal backtracking solution.

===============================================================================
SPACE COMPLEXITY
===============================================================================

Board

O(N²)

Recursion stack

O(N)

Result list

Depends on number of solutions.

Ignoring output,

Auxiliary Space

O(N²)

===============================================================================
ALGORITHM
===============================================================================

queens(board,row)

1. If all rows processed
      convert board into strings
      return one solution

2. For every column

      if safe

           place queen

           solve next row

           remove queen

3. Return all solutions.

===============================================================================
KEY IDEA TO REMEMBER
===============================================================================

One recursive call
=
One row

One loop iteration
=
Trying one possible column

Recursive call
=
Solve remaining rows

Backtracking
=
Undo the choice before trying the next possibility.

===============================================================================
*/
        public List<List<String>> solveNQueens(int n) {
            return queens(new boolean[n][n], 0);
        }

        //-------------------------------------------------------------------------
        // Solves the problem row-by-row using backtracking.
        // Returns all valid board configurations from the current row onward.
        //-------------------------------------------------------------------------
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

        //-------------------------------------------------------------------------
        // Checks whether placing a queen at (row, col) is safe.
        // Since queens are placed row-by-row from top to bottom,
        // we only need to check:
        //   1. Same column
        //   2. Upper-left diagonal
        //   3. Upper-right diagonal
        //-------------------------------------------------------------------------

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


        //-------------------------------------------------------------------------
        // Converts the boolean board into the format expected by LeetCode.
        // true  -> 'Q'
        // false -> '.'
        //-------------------------------------------------------------------------
        static List<String> display(boolean[][] board){


            List<String> boardState = new ArrayList<>();

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
