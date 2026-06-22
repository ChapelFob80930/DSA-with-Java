// Amazon // Microsoft / LeetCode 287 - Find the Duplicate Number
class Solution {

    public int findDuplicate(int[] nums) {

        // Use modified Cycle Sort.
        // Since numbers are in the range [1, n],
        // every number ideally belongs at index (value - 1).
        // If we encounter a number already occupying its correct position,
        // that number is the duplicate.
        return cycleSort(nums);
    }

    public int cycleSort(int[] nums) {

        int i = 0;

        while (i < nums.length) {

            // Correct index where nums[i] should be placed
            int correct = nums[i] - 1;

            // If the current element is not at its correct position
            // and its correct position contains a different value,
            // swap them.
            if (nums[i] != nums[correct]) {

                swap(nums, i, correct);
            }

            // If the current element equals the element at its
            // correct position and they are different indices,
            // we found the duplicate.
            else if (i != correct) {

                return nums[i];
            }

            // Element is already in its proper position.
            else {

                i++;
            }
        }

        // Problem guarantees a duplicate, so this is just a fallback.
        return -1;
    }

    // Utility function to swap two elements
    public static void swap(int[] arr, int index1, int index2) {

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}