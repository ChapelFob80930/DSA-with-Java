package patterns;

/*
=========================================================
                 PATTERN PROBLEMS
=========================================================

Pattern Solving Template

For EVERY pattern, ask these four questions:

1. How many rows are there?
2. How many columns/items should be printed in the current row?
3. What should be printed?
   - *
   - Numbers
   - Alphabets
   - Spaces
4. If the pattern is centered:
   - How many leading spaces are required?

Almost every pattern problem can be solved by answering
these four questions.

=========================================================
*/

public class Pattern {

    public static void main(String[] args) {

        pattern1(5);
        System.out.println();

        pattern2(5);
        System.out.println();

        pattern3(5);
        System.out.println();

        pattern4(5);
        System.out.println();

        pattern5(5);
        System.out.println();

        pattern6(5);
        System.out.println();

        pattern7(5);
        System.out.println();

        pattern8(5);
        System.out.println();

        pattern9(4);
    }

    /*
    =========================================================
    Pattern 1

    *

    * *
    * * *
    * * * *
    * * * * *

    Rows = n
    Columns = current row number

    Formula:
    cols = row
    =========================================================
    */
    private static void pattern1(int n) {

        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    /*
    =========================================================
    Pattern 2

    * * * * *
    * * * * *
    * * * * *
    * * * * *
    * * * * *

    Rows = n
    Columns = n

    Formula:
    cols = n
    =========================================================
    */
    private static void pattern2(int n) {

        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= n; col++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    /*
    =========================================================
    Pattern 3

    * * * * *
    * * * *
    * * *
    * *
    *

    Rows = n

    Columns decrease every row.

    Formula:
    cols = n - row + 1
    =========================================================
    */
    private static void pattern3(int n) {

        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    /*
    =========================================================
    Pattern 4

    1
    1 2
    1 2 3
    1 2 3 4
    1 2 3 4 5

    Same logic as Pattern 1.

    Only change:
    Print column number instead of "*".
    =========================================================
    */
    private static void pattern4(int n) {

        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }

            System.out.println();
        }
    }

    /*
    =========================================================
    Pattern 5

    *
    * *
    * * *
    * * * *
    * * * * *
    * * * *
    * * *
    * *
    *

    Think of it as:

    Upper Half
        columns increase

    Lower Half
        columns decrease

    Formula:

    if(row > n)
        cols = 2*n - row
    else
        cols = row

    Total rows = 2*n - 1
    =========================================================
    */
    private static void pattern5(int n) {

        for (int row = 1; row <= 2 * n - 1; row++) {

            int totalColsInRow =
                    (row > n)
                            ? 2 * n - row
                            : row;

            for (int col = 1; col <= totalColsInRow; col++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    /*
    =========================================================
    Pattern 6

            *
          * *
        * * *
      * * * *
    * * * * *
      * * * *
        * * *
          * *
            *

    Same logic as Pattern 5.

    Step 1
    Find number of stars.

    Step 2
    Remaining width becomes leading spaces.

    spaces = n - stars

    Total rows = 2*n - 1
    =========================================================
    */
    private static void pattern6(int n) {

        for (int row = 1; row <= 2 * n - 1; row++) {

            int totalColsInRow =
                    (row > n)
                            ? 2 * n - row
                            : row;

            int spaces = n - totalColsInRow;

            for (int s = 1; s <= spaces; s++) {
                System.out.print("  ");
            }

            for (int col = 1; col <= totalColsInRow; col++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    /*
    =========================================================
    Pattern 7

            1
          2 1 2
        3 2 1 2 3
      4 3 2 1 2 3 4
    5 4 3 2 1 2 3 4 5

    Solve in THREE parts.

    1. Leading spaces
    2. Descending numbers
    3. Ascending numbers

    Spaces:
    n - row

    Descending:
    row -> 1

    Ascending:
    2 -> row
    =========================================================
    */
    public static void pattern7(int n) {

        for (int row = 1; row <= n; row++) {

            // Leading spaces
            for (int spaces = 1; spaces <= n - row; spaces++) {
                System.out.print("  ");
            }

            // Descending numbers
            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }

            // Ascending numbers
            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }

            System.out.println();
        }
    }

    /*
    =========================================================
    Pattern 8

            1
          2 1 2
        3 2 1 2 3
      4 3 2 1 2 3 4
    5 4 3 2 1 2 3 4 5
      4 3 2 1 2 3 4
        3 2 1 2 3
          2 1 2
            1

    This is simply:

    Pattern 7
          +
    Pattern 7 upside-down

    Use the same trick from Pattern 5
    to calculate the current row size.
    =========================================================
    */
    public static void pattern8(int n) {

        for (int row = 1; row <= 2 * n - 1; row++) {

            int currentRow =
                    (row > n)
                            ? 2 * n - row
                            : row;

            for (int spaces = 1; spaces <= n - currentRow; spaces++) {
                System.out.print("  ");
            }

            for (int col = currentRow; col >= 1; col--) {
                System.out.print(col + " ");
            }

            for (int col = 2; col <= currentRow; col++) {
                System.out.print(col + " ");
            }

            System.out.println();
        }
    }

    /*
    =========================================================
    Pattern 9

    For n = 4

    4 4 4 4 4 4 4 4 4
    4 3 3 3 3 3 3 3 4
    4 3 2 2 2 2 2 3 4
    4 3 2 1 1 1 2 3 4
    4 3 2 1 1 1 2 3 4
    4 3 2 1 1 1 2 3 4
    4 3 2 2 2 2 2 3 4
    4 3 3 3 3 3 3 3 4
    4 4 4 4 4 4 4 4 4

    Intuition:

    Imagine peeling an onion.

    Every layer moving inward decreases by 1.

    So for every cell, ask:

    "How far am I from the nearest border?"

    distance =
        minimum(
            top,
            bottom,
            left,
            right
        )

    value = originalN - distance

    Since the original question wants the
    center to stay 1 instead of 0:

    value = max(1, originalN - distance)

    (If you remove max(), the very center becomes 0.)
    =========================================================
    */
    private static void pattern9(int n) {

        int originalN = n;

        // Grid size becomes (2n+1) x (2n+1)
        n = 2 * n;

        for (int row = 0; row <= n; row++) {

            for (int col = 0; col <= n; col++) {

                // Distance from the nearest border
                int distance = Math.min(
                        Math.min(row, col),
                        Math.min(n - row, n - col)
                );

                // Keep the center as 1
                int value = Math.max(1, originalN - distance);

                // Original version:
                // int value = originalN - distance;

                System.out.print(value + " ");
            }

            System.out.println();
        }
    }
}