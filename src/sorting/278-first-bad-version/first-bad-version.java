/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        // Search space contains all possible versions.
        int start = 1;
        int end = n;

        // Continue until the search space shrinks to one version.
        while (start < end) {

            // Prevent integer overflow while finding the middle version.
            int mid = start + (end - start) / 2;

            boolean isBad = isBadVersion(mid);

            if (isBad) {

                // mid could be the first bad version,
                // so keep it in the search space.
                end = mid;
            } else {

                // mid is definitely good,
                // so the first bad version must be after mid.
                start = mid + 1;
            }
        }

        // start and end point to the first bad version.
        return start;
    }
}