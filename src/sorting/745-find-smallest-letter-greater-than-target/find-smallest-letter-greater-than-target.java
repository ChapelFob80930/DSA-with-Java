class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        int start = 0;
        int end = letters.length - 1;

        // Alternate method:
        // If target is greater than or equal to the last character,
        // answer will wrap around to the first character
        // Example:
        // letters = ['c','f','j'], target = 'j'
        // return 'c'
        
        // if(target >= letters[end]){
        //     return letters[0];
        // }

        // Binary Search:
        // Find the smallest character greater than target

        while(start <= end) {

            // Prevents integer overflow
            int mid = start + (end - start) / 2;

            // If current character is greater than target,
            // possible answer lies on left side including mid
            if(letters[mid] > target){
                end = mid - 1;
            }

            // Otherwise move right to search for greater character
            else{
                start = mid + 1;
            }
        }

        // start points to the smallest character > target
        // Modulo handles wrap-around case automatically
        // Example:
        // start = letters.length -> returns letters[0]
        return letters[start % letters.length];
    }
}