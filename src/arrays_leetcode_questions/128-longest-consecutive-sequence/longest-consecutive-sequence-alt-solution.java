/*
--------------------------------------------------
Pattern: Sorting + Consecutive Sequence Tracking
--------------------------------------------------

Idea:
1. Sort the array so consecutive numbers become adjacent.
2. Track the current expected number (curr).
3. Skip duplicates since they do not affect sequence length.
4. If the next unique number is not the expected number,
   the previous sequence ended and a new one starts.
5. Keep track of the longest streak found.

Time Complexity: O(n log n)   // Sorting
Space Complexity: O(1)        // Ignoring sorting space

--------------------------------------------------
Visualization Example 1
--------------------------------------------------

nums = [100,4,200,1,3,2]

After sorting:
[1,2,3,4,100,200]

curr = 1

1 ✓ -> expect 2 -> streak = 1
2 ✓ -> expect 3 -> streak = 2
3 ✓ -> expect 4 -> streak = 3
4 ✓ -> expect 5 -> streak = 4

100 ✗ (expected 5)
New sequence starts
streak = 1

200 ✗ (expected 101)
New sequence starts
streak = 1

Longest streak = 4

--------------------------------------------------
Visualization Example 2 (Duplicates)
--------------------------------------------------

nums = [1,2,2,3]

After sorting:
[1,2,2,3]

1 ✓ -> streak = 1
2 ✓ -> streak = 2
2 (duplicate) -> skipped
3 ✓ -> streak = 3

Longest streak = 3

--------------------------------------------------
Visualization Example 3
--------------------------------------------------

nums = [2,20,4,10,3,4,5]

After sorting:
[2,3,4,4,5,10,20]

2 ✓ -> streak = 1
3 ✓ -> streak = 2
4 ✓ -> streak = 3
4 (duplicate) -> skipped
5 ✓ -> streak = 4

10 ✗ -> new sequence -> streak = 1
20 ✗ -> new sequence -> streak = 1

Longest streak = 4
*/

class Solution {
    public int longestConsecutive(int[] nums) {

        // Edge case: empty array
        if(nums.length == 0){
            return 0;
        }

        // Sort array so consecutive numbers become adjacent
        Arrays.sort(nums);

        int curr = nums[0];   // Current expected number
        int streak = 0;       // Length of current sequence
        int i = 0;
        int res = 0;          // Longest sequence found

        while(i < nums.length){

            /*
             If nums[i] is not the expected number,
             the previous sequence has ended.
             Start a new sequence from nums[i].

             Example:
             Expected: 5
             Found:    10

             Sequence [1,2,3,4] ended.
             Start new sequence from 10.
            */
            if(curr != nums[i]){
                curr = nums[i];
                streak = 0;
            }

            // Skip all duplicates of the current number
            while(i < nums.length && nums[i] == curr){
                i++;
            }

            // Move to the next expected number
            curr++;

            // Extend current sequence length
            streak++;

            // Update longest sequence found
            res = Math.max(res, streak);
        }

        return res;
    }
}
