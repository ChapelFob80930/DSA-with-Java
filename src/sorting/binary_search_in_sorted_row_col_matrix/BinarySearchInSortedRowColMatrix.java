package sorting.binary_search_in_sorted_row_col_matrix;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchInSortedRowColMatrix {

    public static void main(String[] args){
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };

        Scanner sc = new Scanner(System.in);

        // Input target element to search
        System.out.print("Target: ");
        int target = sc.nextInt();

        // Find the probable range where target may exist


        // Perform binary search within the found range
        int[] index  = search(arr, target);
        if(index[0] != -1){
            System.out.println(target + " found at index "
                    + Arrays.toString(index));
        }
        else{
            System.out.println(target + " not found in matrix");
        }
    }

    static int[] search(int[][] matrix, int target){
        int r = 0;
        int c = matrix.length - 1;

        while(r < matrix.length && c >= 0){
            if(matrix[r][c] == target){
                return new int[]{r, c};
            }

            else if(matrix[r][c] < target){
                r++;
            }

            else if(matrix[r][c] > target){
                c--;
            }
        }
        return new int[]{-1,-1};
    }
}
