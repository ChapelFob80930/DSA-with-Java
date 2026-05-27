package binary_search;

import java.util.Scanner;

public class findCeiling {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = {2, 3, 5, 9, 14, 16, 18};

        System.out.println("Target: ");
        int target = in.nextInt();

        int ans = findCeilingFunc(arr, target, 0, arr.length-1);

        if(ans == -1){
            System.out.println("There is no number greater than or equal to "+target+" in the array");
        }
        else{
            System.out.println("ceiling: "+ans);
        }

    }

    static int findCeilingFunc(int[] arr, int target, int left, int right) {
        //NOTE: should return the smallest number greater than or equal to the target number
        if(target > arr[arr.length-1]){
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
        return arr[left];
    }
}
