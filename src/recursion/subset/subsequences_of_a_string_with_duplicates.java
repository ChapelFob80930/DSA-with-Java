package recursion.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsequences_of_a_string_with_duplicates {
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 2};
        List<List<Integer>> ans = subsetDuplicate(arr);
        for(List<Integer> list : ans){
            System.out.println(list);
        }
    }

    static List<List<Integer>> subsetDuplicate(int[] arr){

        // Sorting brings duplicates together so we can detect them easily.
        // Example:
        // [2,1,2,2] -> [1,2,2,2]
        Arrays.sort(arr);

        List<List<Integer>> outer = new ArrayList<>();

        // Start with the empty subset.
        //
        // Initially:
        // [
        //   []
        // ]
        outer.add(new ArrayList<>());

        // 'start' = index from where we begin creating new subsets.
        // 'end'   = last index of the subsets created BEFORE processing
        //           the current number.
        int start = 0;
        int end = 0;

        for(int i = 0; i < arr.length; i++){

            // By default, every new number is added to ALL existing subsets.
            //
            // Example:
            // Current subsets:
            // []
            // [1]
            //
            // New number = 2
            //
            // Copy every subset:
            // []  -> [2]
            // [1] -> [1,2]
            start = 0;

            // If current number is the same as the previous one,
            // DON'T add it to every subset again.
            //
            // Instead, only add it to the subsets that were created
            // in the PREVIOUS iteration.
            //
            // Example:
            //
            // After processing the first 2:
            //
            // Index  Subset
            // -----  ------
            // 0      []
            // 1      [1]
            // 2      [2]      <-- newly created
            // 3      [1,2]    <-- newly created
            //
            // When the second 2 comes:
            //
            // Wrong (start = 0):
            // []    +2 -> [2]      (duplicate)
            // [1]   +2 -> [1,2]    (duplicate)
            // [2]   +2 -> [2,2]
            // [1,2] +2 -> [1,2,2]
            //
            // Correct:
            // Only process indices 2 and 3:
            // [2]   +2 -> [2,2]
            // [1,2] +2 -> [1,2,2]
            //
            // Hence:
            // start = end + 1
            if(i > 0 && arr[i] == arr[i-1]){
                start = end + 1;
            }

            // Remember where the old subsets end BEFORE adding new ones.
            //
            // Example before processing another 2:
            //
            // outer
            // -----
            // 0 -> []
            // 1 -> [1]
            // 2 -> [2]
            // 3 -> [1,2]
            //
            // end = 3
            //
            // After adding new subsets:
            //
            // 4 -> [2,2]
            // 5 -> [1,2,2]
            //
            // 'end' still marks the boundary between
            // old subsets and newly created subsets.
            end = outer.size() - 1;

            int n = outer.size();

            // Duplicate each selected subset and append current number.
            //
            // Example:
            //
            // Existing subset:
            // [1,2]
            //
            // Make a copy:
            // [1,2]
            //
            // Add current element (2):
            // [1,2,2]
            //
            // Append back to outer.
            for(int j = start; j < n; j++){

                List<Integer> internal = new ArrayList<>(outer.get(j));

                internal.add(arr[i]);

                outer.add(internal);
            }

            /*
             * State of outer after each iteration for input [1,2,2]
             *
             * Initial:
             * []
             *
             * -----------------------
             * After processing 1:
             *
             * []
             * [1]
             *
             * -----------------------
             * After processing first 2:
             *
             * []
             * [1]
             * [2]
             * [1,2]
             *
             * -----------------------
             * After processing second 2:
             *
             * []
             * [1]
             * [2]
             * [1,2]
             * [2,2]
             * [1,2,2]
             */
        }

        return outer;
    }
}
