class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        /*
        * For each row:
        * 1. Flip horizontally (reverse the row)
        * 2. Invert each bit (0 -> 1, 1 -> 0)
        *
        * Instead of doing these in two separate passes,
        * we combine both operations into a single pass.
        */
        
        for (int[] img : image) {

            /*
            * Traverse only until the middle of the row.
            *
            * (length + 1) / 2 ensures:
            * - Even length: processes exactly half the row.
            * - Odd length: processes the middle element as well.
            *
            * Example:
            * length = 4 -> (4 + 1) / 2 = 2
            * length = 5 -> (5 + 1) / 2 = 3
            */

            for (int i = 0; i < (image[0].length + 1) / 2; i++) {

                /*
                * Mirror index of i.
                *
                * Example (length = 5):
                * i = 0 <-> 4
                * i = 1 <-> 3
                * i = 2 <-> 2 (middle element)
                */

                /*
                * Swap the current element with its mirror element
                * while simultaneously inverting both values.
                *
                * XOR with 1 flips a binary bit:
                * 0 ^ 1 = 1
                * 1 ^ 1 = 0
                */

                int temp = img[i] ^ 1;

                img[i] = img[image[0].length - 1 - i] ^ 1;

                img[image[0].length - 1 - i] = temp;
            }
        }
        
        return image;
    }
}