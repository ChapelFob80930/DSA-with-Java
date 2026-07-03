class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        // Number of rows (and columns for this problem)
        int n = image.length;

        /*
         * STEP 1: Flip each row horizontally
         *
         * Example:
         * [1, 1, 0] -> [0, 1, 1]
         *
         * We reverse the row using the two-pointer swapping technique.
         */
        for (int[] img : image) {

            // Only traverse till the middle to avoid swapping twice
            for (int i = 0; i < n / 2; i++) {

                // Swap current element with its mirror element
                int temp = img[i];
                img[i] = img[n - 1 - i];
                img[n - 1 - i] = temp;
            }
        }

        /*
         * STEP 2: Invert every bit
         *
         * 0 -> 1
         * 1 -> 0
         *
         * Example:
         * [0, 1, 1] -> [1, 0, 0]
         */
        for (int[] img : image) {

            for (int i = 0; i < n; i++) {

                // Toggle the bit
                img[i] = (img[i] == 0) ? 1 : 0;
            }
        }

        return image;
    }
}