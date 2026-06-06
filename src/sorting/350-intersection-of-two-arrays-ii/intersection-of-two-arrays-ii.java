class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();

        ArrayList<Integer> ans = new ArrayList<>();

        int[] largestArray = (nums1.length>=nums2.length)?nums1:nums2;

        int[] smallestArray = (nums1.length<nums2.length)?nums1:nums2;


        for(int i = 0; i < smallestArray.length; i++){
            map.put(smallestArray[i], map.getOrDefault(smallestArray[i], 0)+1);
        }

        for(int i = 0; i < largestArray.length; i++){
            if(map.get(largestArray[i])!=null && map.get(largestArray[i])>0){
                ans.add(largestArray[i]);
                map.put(largestArray[i], map.getOrDefault(largestArray[i], 0)-1);
            }
        }

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