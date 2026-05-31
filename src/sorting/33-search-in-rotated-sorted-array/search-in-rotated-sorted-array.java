class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int start = 0;
        int end = nums.length-1;

        if(pivot == -1){
            return binarySearch(nums, target, start, end);
        }

        else if(nums[pivot] == target){
            return pivot;
        }

        else if(target >= nums[start]){
            return binarySearch(nums, target, start, pivot - 1);
        }

        // target < nums[start]
        return binarySearch(nums, target, pivot + 1, end);
    }

    public int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end) {

            int mid = start + (end - start) / 2;

            if(arr[mid] > target) {
                end = mid - 1;
            }

            else if(arr[mid] < target) {
                start = mid + 1;
            }

            else {
                return mid;
            }
        }

        return -1;
    }

    public int findPivot(int[] arr){

        int start = 0;
        int end = arr.length - 1;

        while(start<=end){
            int mid = start + (end - start) / 2;

            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }

            else if(mid > start && arr[mid] < arr[mid-1]){
                return mid-1;
            }

            else if(arr[start] >= arr[mid]){
                end = mid-1;
            }

            else if(arr[start] < arr[mid]){
                start = mid+1;
            }

        }

        return -1;

    }
}