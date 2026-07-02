class Solution {
    public int maxArea(int[] height) {

        // Start with the widest possible container
        int l = 0;
        int r = height.length - 1;

        // Maximum area found so far
        int area = 0;

        // Keep shrinking the window until pointers meet
        while (l < r) {

            // Water level is limited by the shorter wall
            // Width = distance between the walls
            int new_area = Math.min(height[l], height[r]) * (r - l);

            // Update the best answer
            area = Math.max(area, new_area);

            /*
             * Greedy Choice:
             *
             * The shorter wall is the bottleneck.
             * Moving the taller wall can never help because:
             *   1. Width decreases.
             *   2. The limiting height (shorter wall) stays the same.
             *
             * Therefore, the only chance of finding a larger area
             * is to move the shorter wall inward and hope to find
             * a taller wall that compensates for the reduced width.
             */
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return area;
    }
}