class Solution {
    public int firstMissingPositive(int[] nums) {

        cycleSort(nums);
        
        // System.out.println(Arrays.toString(nums));

        for(int i = 0; i<nums.length; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }

        return nums.length+1;
    }

    public void cycleSort(int[] arr){
        
        int i = 0;

        while(i<arr.length){
        
            if(arr[i]>0 && arr[i]<=arr.length){
                int correct = arr[i] - 1;

                if(arr[i]!=arr[correct]){
                    swap(arr, i, correct);
                }

                else{
                    i++;
                }
            }

            else{
                i++;
            }
        }
    }

    public static void swap(int[] arr, int index1, int index2){

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}


    // // Optimal Solution
    //     // Time Complexity  -> O(n)
    //     // Space Complexity -> O(1)

    //     int n = nums.length;

    //     // Used to check whether number 1 exists in the array
    //     // because if 1 itself is missing,
    //     // then answer is definitely 1
    //     boolean contains1 = false;

    //     // Step 1:
    //     // Clean the array
    //     //
    //     // Ignore useless values:
    //     // - negative numbers
    //     // - zero
    //     // - numbers greater than n
    //     //
    //     // Why?
    //     // Because for an array of size n,
    //     // the first missing positive must lie between 1 and n+1
    //     for(int i = 0; i < n; i++){

    //         // Check if 1 exists
    //         if(nums[i] == 1){
    //             contains1 = true;
    //         }

    //         // Replace useless values with 1
    //         else if(nums[i] > n || nums[i] <= 0){
    //             nums[i] = 1;
    //         }
    //     }

    //     // If 1 is not present,
    //     // then it is the first missing positive
    //     if(!contains1){
    //         return 1;
    //     }

    //     // Step 2:
    //     // Use index marking (in-place hashing)
    //     //
    //     // Idea:
    //     // index -> represents number
    //     //
    //     // index 1 -> number 1
    //     // index 2 -> number 2
    //     // ...
    //     //
    //     // Since indices go from 0 to n-1,
    //     // we use index 0 specially to represent number n
    //     for(int i = 0; i < n; i++){

    //         // Use absolute value because
    //         // elements may already have been marked negative
    //         int value = Math.abs(nums[i]);

    //         // Number n maps to index 0
    //         if(value == n){

    //             // Mark as present by making negative
    //             nums[0] = -Math.abs(nums[0]);
    //         }
    //         else{

    //             // Mark corresponding index as negative
    //             nums[value] = -Math.abs(nums[value]);
    //         }
    //     }

    //     // Step 3:
    //     // Find first index with positive value
    //     //
    //     // Positive means:
    //     // that number was never marked/present
    //     for(int i = 1; i < n; i++){

    //         if(nums[i] > 0){
    //             return i;
    //         }
    //     }

    //     // If index 0 is still positive,
    //     // then number n is missing
    //     if(nums[0] > 0){
    //         return n;
    //     }

    //     // If all numbers from 1 to n are present,
    //     // answer becomes n+1
    //     return n + 1;



        // --------------------------------------------------
        // Better Solution (Hashing)
        // Time Complexity  -> O(n)
        // Space Complexity -> O(n)
        // --------------------------------------------------

        /*
        int n = nums.length;

        // Hash array to track presence of numbers
        // Size n+1 because we only care about numbers from 1 to n
        int[] hash = new int[n + 1];

        // Traverse original array
        for(int i = 0; i < n; i++){

            // Ignore useless values
            if(nums[i] <= 0 || nums[i] > n){

                // Replace with dummy value
                nums[i] = n + 1;
            }
            else{

                // Mark number as present
                hash[nums[i]]++;
            }
        }

        // Find first missing positive
        for(int i = 1; i <= n; i++){

            // Frequency 0 means missing
            if(hash[i] == 0){
                return i;
            }
        }

        // If all numbers from 1 to n exist
        return n + 1;
        */