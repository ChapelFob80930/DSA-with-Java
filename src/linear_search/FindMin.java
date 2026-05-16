package linear_search;

import java.util.Scanner;

public class FindMin {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[5];

        for(int i = 0; i<arr.length; i++){
            arr[i] = in.nextInt();
        }

        System.out.println("Minimum value in array is " + findMin(arr));

    }

    static int findMin(int[] arr){
        if(arr.length == 0){
            return Integer.MIN_VALUE;
        }

        int smallest = arr[0];

        for(int i = 0; i< arr.length; i++){
            if(arr[i] < smallest){
                smallest = arr[i];
            }
        }

        return smallest;
    }

}
