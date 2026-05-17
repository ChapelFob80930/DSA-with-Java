package binary_search;

import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[5];

        for(int i = 0; i<arr.length; i++){
            arr[i] = in.nextInt();
        }

        int target = in.nextInt();

        if(binarySearch(arr, target, 0, arr.length-1)){
            System.out.println(target + " exists in the array.");
        }
        else{
            System.out.println(target + " does not exist in the array.");
        }

    }

    static boolean binarySearch(int[] arr, int target, int left, int right) {
        while(left<=right) {
//            int mid = (left + right) / 2;
            int mid = left + (right - left)/2; // to avoid integer overflow
            if (arr[mid] == target) {
                return true;
            }
            else if(arr[mid] > target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return false;
    }

}
