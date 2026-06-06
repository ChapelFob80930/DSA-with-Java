class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        // HashMap stores:
        // Key   -> Element value
        // Value -> Frequency (count) of that element
        HashMap<Integer, Integer> map = new HashMap<>();

        // Stores the intersection elements before converting to int[]
        ArrayList<Integer> ans = new ArrayList<>();

        int[] smallestArray;
        int[] largestArray;

        // Build the HashMap using the smaller array.
        //
        // Why?
        // The HashMap's size depends on the number of elements
        // we insert into it.
        //
        // Example:
        // nums1 size = 1000
        // nums2 size = 10
        //
        // Building the map from nums2 requires much less memory.
        //
        // Therefore, the extra space used by the HashMap is:
        // O(min(n, m))
        if (nums1.length <= nums2.length) {
            smallestArray = nums1;
            largestArray = nums2;
        } else {
            smallestArray = nums2;
            largestArray = nums1;
        }

        // Count frequencies of all elements in the smaller array.
        //
        // Example:
        // smallestArray = [1, 2, 2, 3]
        //
        // map:
        // 1 -> 1
        // 2 -> 2
        // 3 -> 1
        for (int i = 0; i < smallestArray.length; i++) {
            map.put(
                smallestArray[i],
                map.getOrDefault(smallestArray[i], 0) + 1
            );
        }

        // Traverse the larger array.
        //
        // If the current element exists in the map and its
        // frequency is greater than 0:
        // 1. Add it to the answer.
        // 2. Decrease its frequency by 1.
        //
        // This ensures an element is added only as many times
        // as it appears in BOTH arrays.
        for (int i = 0; i < largestArray.length; i++) {

            if (map.getOrDefault(largestArray[i], 0) > 0) {

                ans.add(largestArray[i]);

                // Consume one occurrence of this element.
                map.put(
                    largestArray[i],
                    map.get(largestArray[i]) - 1
                );
            }
        }

        // Convert ArrayList<Integer> to int[]
        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}

/*
Approach:
1. Store frequencies of all elements from the smaller array
   in a HashMap.
2. Traverse the larger array.
3. If an element's frequency in the map is greater than 0:
   - Add it to the answer.
   - Decrease its frequency by 1.
4. Convert the ArrayList into an int[] and return it.

Example:
nums1 = [1, 2, 2, 1]
nums2 = [2, 2]

Frequency Map:
2 -> 2

Traversal:
2 -> add to answer, frequency becomes 1
2 -> add to answer, frequency becomes 0

Answer:
[2, 2]

Why decrease the frequency?
Without decreasing it, the same element could be added
more times than it appears in both arrays.

Time Complexity:
O(n + m)

Reason:
- O(min(n, m)) to build the frequency map.
- O(max(n, m)) to traverse the other array.
- Combined: O(n + m)

Space Complexity:
O(min(n, m))

Reason:
The HashMap stores frequencies of only the smaller array.
In the worst case, all elements are distinct, so the map
contains min(n, m) entries.

where:
n = nums1.length
m = nums2.length
*/