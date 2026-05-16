package linear_search;

import java.util.Scanner;

public class SearchInRange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[5];

        for(int i = 0; i<arr.length; i++){
            arr[i] = in.nextInt();
        }

        System.out.println("Enter target: ");
        int target = in.nextInt();
        System.out.println("Enter start index: ");
        int start = in.nextInt();
        System.out.println("Enter end index: ");
        int end = in.nextInt();

        if(linearSearch(arr, target, start, end) >= 1 && linearSearch(arr, target, start, end) < Integer.MAX_VALUE ){
            System.out.println(target + " exists in the array at index " + linearSearch(arr, target, start, end));
        }

        else if(linearSearch(arr, target, start, end) == Integer.MAX_VALUE){
            System.out.println("Array is empty.");
        }

        else{
            System.out.println(target + " does not exist in the array.");
        }

    }

    static int linearSearch(int[] arr, int target, int startIndex, int endIndex){
        if(arr.length == 0){
            return Integer.MIN_VALUE;
        }

        for(int i = startIndex; i<=endIndex; i++){
            if(arr[i] == target){
                return i;
            }
        }

        return -1;
    }

}
