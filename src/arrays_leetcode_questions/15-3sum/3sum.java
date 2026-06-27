/*
INTUITION

We need to find all unique triplets such that:

    nums[i] + nums[j] + nums[k] = 0

Brute Force:
- Try every possible triplet.
- O(n³)

Optimization:
- Sort the array first.
- Fix one element (nums[i]).
- Now find two numbers whose sum equals -nums[i].

This becomes a Two Sum II problem on a sorted array.

--------------------------------------------------

Example:

Original:
[-1, 0, 1, 2, -1, -4]

After sorting:
[-4, -1, -1, 0, 1, 2]

--------------------------------------------------

Iteration 1:

i = -4

Need:
nums[l] + nums[r] = 4

      i   l            r
      ↓   ↓            ↓
[-4, -1, -1, 0, 1, 2]

sum = -4 + (-1) + 2 = -3

Too small -> move l right.

--------------------------------------------------

Iteration 2:

i = -1

Need:
nums[l] + nums[r] = 1

      i   l         r
      ↓   ↓         ↓
[-4, -1, -1, 0, 1, 2]

sum = -1 + (-1) + 2 = 0

Found:
[-1, -1, 2]

Move both pointers inward.

      i       l  r
      ↓       ↓  ↓
[-4, -1, -1, 0, 1, 2]

sum = -1 + 0 + 1 = 0

Found:
[-1, 0, 1]

--------------------------------------------------

Why sorting helps:

Sorted Array:
[-4, -1, -1, 0, 1, 2]

If sum < 0:
Current sum is too small.
Move left pointer right to increase it.

If sum > 0:
Current sum is too large.
Move right pointer left to decrease it.

--------------------------------------------------

Duplicate Handling:

Example:
[-4, -1, -1, 0, 1, 2]

If both -1's are used as i,
the same triplets will be generated twice.

So skip duplicate i values.

Similarly after finding a valid triplet,
skip duplicate left values to avoid duplicate answers.

--------------------------------------------------

TIME COMPLEXITY

Sorting:
O(n log n)

Outer loop:
O(n)

Inner two-pointer traversal:
O(n)

Overall:
O(n²)

Why not O(n² log n)?

Because for each i, the pointers only move
from left to right once and never reset.
Across one iteration of i, l and r together
perform at most O(n) moves.

--------------------------------------------------

SPACE COMPLEXITY

O(1)

Ignoring the output list.

Only a few variables are used:
i, l, r, sum

Result storage is not counted in auxiliary space.
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // Stores all unique triplets
        List<List<Integer>> ans = new ArrayList<>();

        // Sort array for two-pointer traversal
        Arrays.sort(nums);

        // Fix the first element of the triplet
        for (int i = 0; i < nums.length - 1; i++) {

            // Since array is sorted, once nums[i] > 0,
            // all remaining values are also > 0.
            // Three positive numbers cannot sum to 0.
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate first elements
            // Example: [-4, -1, -1, 0, 1, 2]
            // Only process the first -1.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Two pointers for the remaining part of the array
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];

                // Found a valid triplet
                if (sum == 0) {

                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    // Move inward to search for another pair
                    l++;
                    r--;

                    // Skip duplicate left values
                    // Example:
                    // [-2, 0, 0, 0, 2]
                    // Avoid adding [-2,0,2] multiple times.
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }

                // Sum too small -> need a larger value
                else if (sum < 0) {
                    l++;
                }

                // Sum too large -> need a smaller value
                else {
                    r--;
                }
            }
        }

        return ans;
    }
}