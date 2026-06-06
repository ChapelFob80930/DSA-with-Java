class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        // Store all unique elements from nums1
        HashSet<Integer> set = new HashSet<>();

        // Dynamically store intersection elements
        ArrayList<Integer> ans = new ArrayList<>();

        // Add all elements of nums1 to the set
        // Duplicate values are automatically ignored by HashSet
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }

        // Check each element of nums2
        for(int i = 0; i < nums2.length; i++){

            // If the element exists in nums1
            if(set.contains(nums2[i])){

                // Add it to the answer
                ans.add(nums2[i]);

                // Remove it to prevent duplicate entries
                // in the final intersection
                set.remove(nums2[i]);
            }
        }

        // Convert ArrayList<Integer> to int[]
        int[] result = new int[ans.size()];

        for(int i = 0; i < ans.size(); i++){
            result[i] = ans.get(i);
        }

        return result;
    }
}


// 1. Store all unique elements of nums1 in a HashSet.
// 2. Traverse nums2 and check whether each element exists in the set.
// 3. If found:
//    - Add it to the answer.
//    - Remove it from the set to ensure uniqueness.
// 4. Convert the ArrayList to an int[] and return it.

// Time Complexity: O(n + m)
// Space Complexity: O(n)