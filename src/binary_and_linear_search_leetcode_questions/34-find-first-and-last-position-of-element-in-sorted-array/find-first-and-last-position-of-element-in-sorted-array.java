class Solution { 

    public int[] searchRange(int[] nums, int target) {

        // Default answer if target is not found
        int[] ans = {-1, -1};

        // Find first occurrence of target
        ans[0] = findIndex(nums, target, true);

        if(ans[0] != -1){
            // Find last occurrence of target
            ans[1] = findIndex(nums, target, false);
        }       
        
        return ans;
    }

    // Binary Search helper function
    // findStartIndex = true  -> find first occurrence
    // findStartIndex = false -> find last occurrence
    public int findIndex(int[] arr, int target, boolean findStartIndex) {

        // Stores the current valid answer
        int ans = -1;

        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {

            // Prevents integer overflow
            int mid = start + (end - start) / 2;

            // Target lies on left side
            if(arr[mid] > target){
                end = mid - 1;
            }

            // Target lies on right side
            else if(arr[mid] < target){
                start = mid + 1;
            }

            // Target found
            else{

                // Store current index
                ans = mid;

                // Continue searching on left side
                // to find first occurrence
                if(findStartIndex){
                    end = mid - 1;
                }

                // Continue searching on right side
                // to find last occurrence
                else{
                    start = mid + 1;
                }
            }
        }

        return ans;
    }
}