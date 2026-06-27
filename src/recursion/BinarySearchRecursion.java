package recursion;

public class BinarySearchRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 55, 66, 78};
        System.out.println(recursiveBinarySearch(arr, 0, arr.length-1, 78));
    }

    private static boolean recursiveBinarySearch(int[] arr, int start, int end, int target) {
        int mid = start + (end - start) / 2;

        if(start>end){
            return false;
        }

        if(arr[mid] == target){
            return true;
        }

        else if(target < arr[mid]){
            return recursiveBinarySearch(arr,start,mid-1,target);
        }

        else{
            return recursiveBinarySearch(arr,mid+1, end, target);
        }
    }
}
