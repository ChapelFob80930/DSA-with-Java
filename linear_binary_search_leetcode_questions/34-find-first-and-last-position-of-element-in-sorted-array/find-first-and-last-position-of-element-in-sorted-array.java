class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = findIndex(nums, target, true);
        ans[1] = findIndex(nums, target, false);

        return ans;         
    }
    
    public int findIndex(int[] arr, int target, boolean findStartIndex){
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {

            int mid = start + (end - start) / 2;

            System.out.println(arr[mid]);

            if(arr[mid] > target){
                end = mid - 1;
            }

            else if(arr[mid] < target){
                start = mid + 1;
            }

            else{
                ans = mid;

                if(findStartIndex){
                    end = mid - 1;
                }

                else{
                    start = mid + 1;
                }
            }

            
        }

        return ans;
    }
}