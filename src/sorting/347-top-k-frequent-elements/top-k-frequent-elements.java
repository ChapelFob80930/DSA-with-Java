class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Store frequency of each number
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Store [frequency, number] pairs
        ArrayList<int[]> arr = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }

        // Sort in descending order of frequency
        // Example: [5,7] comes before [3,2]
        arr.sort((a, b) -> b[0] - a[0]);

        int[] ans = new int[k];

        // Take the first k numbers (most frequent)
        for (int i = 0; i < k; i++) {
            ans[i] = arr.get(i)[1];
        }

        return ans;
    }
}