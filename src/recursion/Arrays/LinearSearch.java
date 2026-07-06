package recursion.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class LinearSearch {
    public static void main(String[] args) {

        int[] arr = new int[] {1, 8, 4, 3, 8, 9, 2};

        System.out.println(recursiveLinearSearch(arr, 8, 0));
        System.out.println(recursiveLinearSearchIndex(arr, 8, 0));
        System.out.println(recursiveLinearSearchIndexLast(arr, 8, arr.length-1));
        recursiveLinearSearchAllIndex(arr, 8, 0);
        System.out.println(list.toString());
        System.out.println(recursiveLinearSearchAllIndex2(arr, 8, 0, new ArrayList<>()));
    }

    static boolean recursiveLinearSearch(int[] arr, int target, int index){
        //base condition
        if(index == arr.length){
            return false;
        }

        return arr[index] == target || recursiveLinearSearch(arr, target, index+1);
    }

    static int recursiveLinearSearchIndex(int[] arr, int target, int index){
        //base condition
        if(index == arr.length){
            return -1;
        }

        if(arr[index] == target){
            return index;
        }

        return recursiveLinearSearchIndex(arr, target, index+1);
    }

    static int recursiveLinearSearchIndexLast(int[] arr, int target, int index){
        //base condition
        if(index == -1){
            return -1;
        }

        if(arr[index] == target){
            return index;
        }

        return recursiveLinearSearchIndexLast(arr, target, index-1);
    }


    static ArrayList<Integer> list = new ArrayList<>();
    static void recursiveLinearSearchAllIndex(int[] arr, int target, int index){
        //base condition
        if(index == arr.length){
            return;
        }

        if(arr[index] == target){
            list.add(index);
        }

        recursiveLinearSearchAllIndex(arr, target, index+1);
    }

    static ArrayList<Integer> recursiveLinearSearchAllIndex2(int[] arr, int target, int index, ArrayList<Integer> list){
        //base condition
        if(index == arr.length){
            return list;
        }

        if(arr[index] == target){
            list.add(index);
        }

        return recursiveLinearSearchAllIndex2(arr, target, index+1, list);
    }

    static ArrayList<Integer> recursiveLinearSearchAllIndex3(int[] arr, int target, int index){

        ArrayList<Integer> list = new ArrayList<>();

        //base condition
        if(index == arr.length){
            return list;
        }

        // will contain answer for that function call only
        if(arr[index] == target){
            list.add(index);
        }

        ArrayList<Integer> ansFromBelowCalls = recursiveLinearSearchAllIndex3(arr, target, index+1);

        list.addAll(ansFromBelowCalls);

        return list;
    }
}
