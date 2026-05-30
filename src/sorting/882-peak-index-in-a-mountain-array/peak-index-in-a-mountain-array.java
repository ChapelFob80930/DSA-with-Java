class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while(start < end) {

            int mid = start + (end - start) / 2;

            if(arr[mid] > arr[mid+1]) {
                // we are in decreasing part of array
                // this may be the answer, but look at left
                // this is why end != mid - 1
                end = mid;
            }

            else {
                // we are in ascending part of array
                start = mid + 1; // beacuse we know that mid + 1 element > mid element
            }

        }

        // in the end start == end and will be pointing to the largest number beause of the 2 checks above
        // start and end are always trying to find max element in the above 2 checks
        // hence, when they are pointing to just one element, that is the max one because that is what the checks say
        // at every point of time for start and end they have the best possible answer till that time
        // and if are saying there is only item remaining, cause of the above line that is the best possible answer
        return start; // or end as both are equal
    }
}