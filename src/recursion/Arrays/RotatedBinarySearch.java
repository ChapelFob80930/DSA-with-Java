package recursion.Arrays;

public class RotatedBinarySearch {

    public static void main(String[] args) {

        // Normal rotated array
        int[] arr1 = {5, 6, 7, 8, 9, 1, 2, 3};

        System.out.println(rotatedBinarySearch(arr1, 8, 0, arr1.length - 1));   // 3
        System.out.println(rotatedBinarySearch(arr1, 2, 0, arr1.length - 1));   // 6
        System.out.println(rotatedBinarySearch(arr1, 10, 0, arr1.length - 1));  // -1

        // Rotated array with duplicates
        int[] arr2 = {1, 1, 1, 1, 1, 3, 1};

        System.out.println(rotatedBinarySearch(arr2, 3, 0, arr2.length - 1));   // 5
    }

    static int rotatedBinarySearch(int[] arr, int target, int s, int e) {

        // ====================================================
        // BASE CASE
        // ====================================================
        // Search space exhausted.
        // Target does not exist.
        //
        // Example:
        // s = 8
        // e = 7
        //
        // return -1
        // ====================================================
        if (s > e) {
            return -1;
        }

        int mid = s + (e - s) / 2;

        // ====================================================
        // CASE 1: TARGET FOUND
        // ====================================================
        //
        // Example:
        // [5,6,7,8,9,1,2,3]
        //        ^
        //       mid
        //
        // target = 8
        //
        // return 3
        // ====================================================
        if (arr[mid] == target) {
            return mid;
        }

        // ====================================================
        // CASE 2: DUPLICATES MAKE IT IMPOSSIBLE TO DETERMINE
        // WHICH HALF IS SORTED
        // ====================================================
        //
        // Example:
        //
        // [1,1,1,1,1,3,1]
        //  s     mid    e
        //
        // arr[s] == arr[mid] == arr[e]
        //
        // We cannot determine whether the pivot is
        // on the left or right side.
        //
        // So shrink both boundaries and try again.
        //
        // Worst Case:
        // [1,1,1,1,1,1,1]
        //
        // Complexity degrades to O(n).
        // ====================================================
        if (arr[s] == arr[mid] && arr[mid] == arr[e]) {
            return rotatedBinarySearch(arr, target, s + 1, e - 1);
        }

        // ====================================================
        // CASE 3: LEFT HALF IS SORTED
        // ====================================================
        //
        // Example:
        //
        // [5,6,7,8 | 9,1,2,3]
        //  s     mid
        //
        // Since:
        // arr[s] <= arr[mid]
        //
        // [5,6,7,8] is sorted.
        // ====================================================
        if (arr[s] <= arr[mid]) {

            // ------------------------------------------------
            // CASE 3A:
            // TARGET IS INSIDE SORTED LEFT HALF
            // ------------------------------------------------
            //
            // Example:
            //
            // [5,6,7,8 | 9,1,2,3]
            //
            // target = 6
            //
            // 5 <= 6 <= 8
            //
            // Search left half.
            // ------------------------------------------------
            if (target >= arr[s] && target <= arr[mid]) {
                return rotatedBinarySearch(arr, target, s, mid - 1);
            }

            // ------------------------------------------------
            // CASE 3B:
            // TARGET IS NOT INSIDE SORTED LEFT HALF
            // ------------------------------------------------
            //
            // Example:
            //
            // target = 2
            //
            // 2 is not between 5 and 8.
            //
            // Search right half.
            // ------------------------------------------------
            else {
                return rotatedBinarySearch(arr, target, mid + 1, e);
            }
        }

        // ====================================================
        // CASE 4: RIGHT HALF IS SORTED
        // ====================================================
        //
        // If left half is not sorted,
        // then right half must be sorted.
        //
        // Example:
        //
        // [9,1 | 2,3]
        //      mid
        //
        // Right side:
        // [1,2,3]
        // is sorted.
        // ====================================================

        // ----------------------------------------------------
        // CASE 4A:
        // TARGET IS INSIDE SORTED RIGHT HALF
        // ----------------------------------------------------
        //
        // Example:
        //
        // [9,1,2,3]
        //
        // target = 2
        //
        // 1 <= 2 <= 3
        //
        // Search right half.
        // ----------------------------------------------------
        else if (target >= arr[mid] && target <= arr[e]) {
            return rotatedBinarySearch(arr, target, mid + 1, e);
        }

        // ----------------------------------------------------
        // CASE 4B:
        // TARGET IS NOT INSIDE SORTED RIGHT HALF
        // ----------------------------------------------------
        //
        // Example:
        //
        // [9,1,2,3]
        //
        // target = 9
        //
        // 9 is not between 1 and 3.
        //
        // Search left half.
        // ----------------------------------------------------
        else {
            return rotatedBinarySearch(arr, target, s, mid - 1);
        }
    }
}

/*
========================================================
DECISION TREE
========================================================

mid == target ?
│
├── Yes → Return mid
│
└── No
    │
    ├── arr[s] == arr[mid] == arr[e] ?
    │       │
    │       ├── Yes
    │       │     │
    │       │     └── Shrink boundaries
    │       │         recurse(s+1, e-1)
    │       │
    │       └── No
    │
    ├── Left half sorted ?
    │   │
    │   ├── Yes
    │   │   │
    │   │   ├── Target in left half ?
    │   │   │      │
    │   │   │      ├── Yes → Search left
    │   │   │      │
    │   │   │      └── No  → Search right
    │   │
    │   └── No
    │
    └── Right half sorted
        │
        ├── Target in right half ?
        │      │
        │      ├── Yes → Search right
        │      │
        │      └── No  → Search left

========================================================

Average Time Complexity : O(log n)

Worst Case (many duplicates):
O(n)

Space Complexity (recursive):
O(log n)

========================================================
*/