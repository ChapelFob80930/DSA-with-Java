class Solution {
    public int[] productExceptSelf(int[] nums) {

        // Output array
        // First it stores exclusive prefix products
        // Later it gets multiplied with suffix products
        int[] ans = new int[nums.length];

        // For index 0 there are no elements on the left
        // So exclusive prefix product = 1
        ans[0] = 1;

        // Build exclusive prefix products
        // ans[i] = product of all elements before i
        //
        // Example:
        // nums = [1,2,3,4]
        // ans  = [1,1,2,6]
        for(int i = 1; i < nums.length; i++)
        {
            // Previous prefix product * previous element
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Stores exclusive suffix product
        // Initially 1 because last index has no elements on the right
        int right = 1;

        // Traverse from right to left
        for(int i = nums.length - 1; i >= 0; i--)
        {
            // Multiply:
            // exclusive prefix product * exclusive suffix product
            ans[i] *= right;

            // Update suffix product for next iteration
            // moving towards left
            right *= nums[i];
        }

        return ans;
    }
}