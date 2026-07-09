class Solution {

    /*
     * TRAPPING RAIN WATER - TWO POINTERS
     *
     * Key Formula:
     *
     * waterAtIndex =
     * min(max wall on left, max wall on right)
     * - currentHeight
     *
     * -------------------------------------------------
     * VISUALIZATION
     * -------------------------------------------------
     *
     * Example:
     *
     * height = [4,2,0,3,2,5]
     *
     *         █
     *         █
     * █       █
     * █ ~ ~ █ █
     * █ ~ ~ █ █
     * █ █ █ █ █
     * ----------
     *
     * '~' = trapped water
     *
     * Water at each index:
     *
     * index 1:
     * 4 - 2 = 2
     *
     * index 2:
     * 4 - 0 = 4
     *
     * index 3:
     * 4 - 3 = 1
     *
     * index 4:
     * 4 - 2 = 2
     *
     * Total = 9
     *
     * -------------------------------------------------
     * CORE OBSERVATION
     * -------------------------------------------------
     *
     * Water level is determined by the SMALLER boundary.
     *
     * Example:
     *
     * leftMax = 4
     * rightMax = 7
     *
     * 4            7
     * █            █
     * █            █
     * █    ?       █
     *
     * Water can rise only to height 4.
     *
     * Therefore:
     *
     * min(4,7) = 4
     *
     * The taller wall does not matter.
     *
     * -------------------------------------------------
     * WHY TWO POINTERS WORK
     * -------------------------------------------------
     *
     * If:
     *
     * leftMax <= rightMax
     *
     * then:
     *
     * min(leftMax,rightMax)
     * =
     * leftMax
     *
     * So the water on the left side is already known.
     *
     * We do NOT need more information from the right.
     *
     * Therefore process left side.
     *
     * Similarly:
     *
     * rightMax < leftMax
     *
     * means the right side is already determined.
     *
     * Therefore process right side.
     *
     * -------------------------------------------------
     * DRY RUN
     * -------------------------------------------------
     *
     * height = [4,2,0,3,2,5]
     *
     * l=0 r=5
     * leftMax=4 rightMax=5
     *
     * leftMax <= rightMax
     *
     * Move l -> 1
     * Water = 4 - 2 = 2
     *
     * Move l -> 2
     * Water = 4 - 0 = 4
     *
     * Move l -> 3
     * Water = 4 - 3 = 1
     *
     * Move l -> 4
     * Water = 4 - 2 = 2
     *
     * Total = 9
     *
     * -------------------------------------------------
     * REVISION LINE
     * -------------------------------------------------
     *
     * Smaller boundary determines water level.
     * Process the side whose maximum wall is smaller.
     *
     * Time  : O(n)
     * Space : O(1)
     */

    public int trap(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int l = 0;
        int r = height.length - 1;

        int leftMax = height[l];
        int rightMax = height[r];

        int res = 0;

        while (l < r) {

            if (leftMax <= rightMax) {

                l++;

                leftMax = Math.max(leftMax, height[l]);

                res += leftMax - height[l];

            } else {

                r--;

                rightMax = Math.max(rightMax, height[r]);

                res += rightMax - height[r];
            }
        }

        return res;
    }
}