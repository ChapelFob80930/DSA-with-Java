package linear_search;

import java.util.Scanner;

public class SearchInStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] arr = new String[5];

        for(int i = 0; i<arr.length; i++){
            arr[i] = in.next();
        }

        String target = in.next();

        if(linearSearch(arr, target)){
            System.out.println(target + " exists in the array.");
        }
        else{
            System.out.println(target + " does not exist in the array.");
        }

    }

    static Boolean linearSearch(String[] arr, String target){
        if(arr.length == 0){
            return false;
        }

        for(int i = 0; i<arr.length; i++){
            if(arr[i].equals(target)){
                return true;
            }
        }

        return false;
    }

}
