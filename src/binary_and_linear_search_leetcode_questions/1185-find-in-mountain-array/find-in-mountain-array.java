class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        // Find the peak of the mountain array
        int peak = findPeak(mountainArr);

        // Search in the ascending part
        int searchInAscendingPart =
                binarySearch(0, peak, target, mountainArr);

        if (searchInAscendingPart != -1) {
            return searchInAscendingPart;
        }

        // If not found, search in the descending part
        return binarySearch(peak + 1, mountainArr.length() - 1, target, mountainArr);
    }

    public int findPeak(MountainArray mountainArr) {

        int start = 0;
        int end = mountainArr.length() - 1;

        // Binary search for the peak element
        while (start < end) {

            int mid = start + (end - start) / 2;

            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                // You are in the descending part,
                // so peak is at mid or to its left
                end = mid;
            } else {
                // You are in the ascending part,
                // so peak lies to the right
                start = mid + 1;
            }
        }

        // start == end == peak index
        return start;
    }

    public int binarySearch(int start, int end,
                            int target, MountainArray mountainArr) {

        // Determine whether current range is ascending or descending
        boolean asc = mountainArr.get(start) < mountainArr.get(end);

        while (start <= end) {

            int mid = start + (end - start) / 2;

            int midVal = mountainArr.get(mid);

            if (midVal == target) {
                return mid;
            }

            if (asc) {

                // Standard binary search for ascending order
                if (target < midVal) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else {

                // Reversed binary search for descending order
                if (target < midVal) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        // Target not present in this range
        return -1;
    }
}