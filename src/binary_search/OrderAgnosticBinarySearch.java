package binary_search;

import java.util.Scanner;

public class OrderAgnosticBinarySearch {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//        int[] arr = {10, 9, 8, 7, 6 ,5, 4, 3, 2, 1};
        int[] arr = {1, 2 ,3 ,4, 5, 6, 7, 8, 9, 10};
//        for(int i = 0; i<arr.length; i++){
//            arr[i] = in.nextInt();
//        }

        int target = in.nextInt();

        if(orderAgnosticbinarySearch(arr, target, 0, arr.length-1)){
            System.out.println(target + " exists in the array.");
        }
        else{
            System.out.println(target + " does not exist in the array.");
        }

    }

    static boolean orderAgnosticbinarySearch(int[] arr, int target, int left, int right) {
        boolean asc = arr[0] < arr[arr.length-1];

        while(left<=right) {
            int mid = left + (right - left) / 2; // to avoid integer overflow

            if(arr[mid] == target){
                return true;
            }

            else if(asc){
                if(target < arr[mid]){
                    right = mid-1;
                }
                else{
                    left = mid + 1;
                }
            }

            else{
                if(target < arr[mid]){
                    left = mid + 1;
                }
                else{
                    right = mid-1;
                }
            }

        }
        return false;
    }
}
