class Solution {
    public int[] findRightInterval(int[][] intervals) {

        // Maps each interval's start value to its original index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Stores all start values separately for sorting and binary search
        int[] starts = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
            starts[i] = intervals[i][0];
        }

        // Sort all start values so binary search can be applied
        Arrays.sort(starts);

        int[] ans = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {

            // Find the index of the smallest start value
            // that is greater than or equal to the current interval's end
            int start = binarySearch(starts, intervals[i][1]);

            // No valid right interval exists
            if (start == -1) {
                ans[i] = -1;
            }
            else {

                // Convert the start value back to its original interval index
                ans[i] = map.get(starts[start]);
            }
        }

        return ans;
    }

    public int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // Stores the index of the smallest valid start found so far
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Exact match found
            // Since start values are unique, we can return immediately
            if (arr[mid] == target) {
                return mid;
            }

            // Need a larger value
            else if (arr[mid] < target) {
                start = mid + 1;
            }

            // Valid candidate found
            // Store it and search left for a smaller valid candidate
            else {
                ans = mid;
                end = mid - 1;
            }
        }

        // Returns the index of the smallest value >= target
        // or -1 if no such value exists
        return ans;
    }
}