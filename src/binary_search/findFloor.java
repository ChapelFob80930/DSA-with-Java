package binary_search;

import java.util.Scanner;

public class findFloor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = {2, 3, 5, 9, 14, 16, 18};

        System.out.println("Target: ");
        int target = in.nextInt();

        int ans = findFloorFunc(arr, target, 0, arr.length-1);

        if(ans == -1){
            System.out.println("There is no number less than or equal to "+target+" in the array");
        }
        else{
            System.out.println("floor: "+ans);
        }

    }

    static int findFloorFunc(int[] arr, int target, int left, int right) {
        //NOTE: should return the greatest number less than or equal to the target number
        if(target < arr[0]){
            return -1;
        }

        while(left<=right) {
            int mid = left + (right - left)/2; // to avoid integer overflow
            if (arr[mid] == target) {
                return arr[mid];
            }
            else if(arr[mid] > target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return arr[right];
    }
}
