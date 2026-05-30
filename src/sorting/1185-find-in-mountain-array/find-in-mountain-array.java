/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int searchInAscendingPart = binarySearch(0, peak, target, mountainArr);
        if(searchInAscendingPart != -1){
            return searchInAscendingPart;
        }
        int searchInDescendingPart = binarySearch(peak+1, mountainArr.length()-1, target, mountainArr);
        return searchInDescendingPart;        
    }

    public int findPeak(MountainArray mountainArr){
        int start = 0;
        int end = mountainArr.length() - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public int binarySearch(int start, int end, int target, MountainArray mountainArr) {

        boolean asc = mountainArr.get(start) < mountainArr.get(end);

        while(start<=end) {
            int mid = start + (end - start) / 2; // to avoid integer overflow

            int midVal = mountainArr.get(mid);

            if(midVal == target){
                return mid;
            }

            else if(asc){
                if(target < midVal){
                    end = mid-1;
                }
                else{
                    start = mid + 1;
                }
            }

            else{
                if(target < midVal){
                    start = mid + 1;
                }
                else{
                    end = mid-1;
                }
            }

        }
        return -1;
    }
}