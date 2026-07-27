import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {

        // Edge case: no digits means no possible combinations.
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        // Lookup table for the phone keypad.
        // Index = digit, Value = corresponding letters.
        String[] map = {
                "",     // 0
                "",     // 1
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };

        return combinations("", digits, map);
    }

    /**
     * p  -> processed part (letters chosen so far)
     * up -> unprocessed digits remaining to be processed
     */
    public List<String> combinations(String p, String up, String[] map) {

        ArrayList<String> ans = new ArrayList<>();

        // Base case:
        // All digits have been processed, so one valid combination is formed.
        if (up.isEmpty()) {
            ans.add(p);
            return ans;
        }

        // Convert the current digit character (e.g. '2') to its integer value (2).
        int digit = up.charAt(0) - '0';

        // Get all possible letters corresponding to the current digit.
        String padChars = map[digit];

        // Try every possible letter for the current digit.
        for (char c : padChars.toCharArray()) {

            // Append the chosen letter to the processed string
            // and recursively process the remaining digits.
            ans.addAll(combinations(p + c, up.substring(1), map));
        }

        return ans;
    }
}