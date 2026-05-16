package linear_search;

import java.util.Arrays;
import java.util.Scanner;

public class SearchIn2DArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] arr = {
                {23, 4, 1},
                {18, 12, 3, 9},
                {78, 99, 34, 56},
                {18, 12}
        };

        System.out.println("Enter target: ");
        int target = in.nextInt();

        if(!Arrays.equals(linearSearch2D(arr, target), new int[]{-1, -1})){
            System.out.println(target + " exists in the array at index " + Arrays.toString(linearSearch2D(arr, target)));
        }
        else{
            System.out.println(target + " does not exist in the array.");
        }

        System.out.println("Max value of the array is " + max(arr));

    }

    static int[] linearSearch2D(int[][] arr, int target) {
        if (arr.length == 0) {
            return new int[]{-1, -1};
        }

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }

    static int max(int[][] arr) {

        int max = Integer.MIN_VALUE;

        for (int[] ints : arr) {

            for (int element : ints) {

                if (element > max) {
                    max = element;
                }
            }
        }

        return max;
    }

}
