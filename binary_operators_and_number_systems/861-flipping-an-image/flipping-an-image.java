class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        for (int[] img : image) {

            for (int i = 0; i < (image[0].length+1)/ 2; i++) {
                int temp = img[i] ^ 1;
                img[i] = img[image[0].length - 1 - i] ^ 1;
                img[image[0].length - 1 - i] = temp;
            }
        }

        return image;
    }
}