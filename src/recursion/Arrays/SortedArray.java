package recursion.Arrays;

public class SortedArray {
    public static void main(String[] args) {
        System.out.println(isSorted(new int[] {1, 2, 4, 3, 8, 9}, 0));
    }

    static boolean isSorted(int[] arr, int index){
        //base condition
        if(index == arr.length-1){
            return true;
        }

        return arr[index] < arr[index+1] && isSorted(arr,index+1);
    }
}
