/*
--------------------------------------------------
Two Pointers + Character Validation Problem
--------------------------------------------------
Idea:
- Use two pointers from both ends.
- Skip all non-alphanumeric characters.
- Compare characters case-insensitively.
- If any mismatch occurs, it is not a palindrome.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {

            // Skip non-alphanumeric characters from the left
            while (l < r && !isAlphaNum(s.charAt(l))) {
                l++;
            }

            // Skip non-alphanumeric characters from the right
            while (r > l && !isAlphaNum(s.charAt(r))) {
                r--;
            }

            // Compare characters ignoring case
            if (Character.toLowerCase(s.charAt(l)) !=
                Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    // Checks whether a character is a letter or digit
    public boolean isAlphaNum(char c) {
        if (('A' <= c && c <= 'Z') ||
            ('a' <= c && c <= 'z') ||
            ('0' <= c && c <= '9')) {
            return true;
        }

        return false;
    }
}