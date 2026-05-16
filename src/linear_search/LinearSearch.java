package linear_search;

import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[5];

        for(int i = 0; i<arr.length; i++){
            arr[i] = in.nextInt();
        }

        int target = in.nextInt();

        if(linearSearch(arr, target)){
            System.out.println(target + " exists in the array.");
        }
        else{
            System.out.println(target + " does not exist in the array.");
        }

    }

    static Boolean linearSearch(int[] arr, int target){
        if(arr.length == 0){
            return false;
        }

        for(int i = 0; i<arr.length; i++){
            if(arr[i] == target){
                return true;
            }
        }

        return false;
    }

}
