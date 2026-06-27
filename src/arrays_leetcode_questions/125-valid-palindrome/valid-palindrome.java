class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while(l<r){
            while(l<r && !isAlphaNum(s.charAt(l))){
                l++;
            }

            while(r>l && !isAlphaNum(s.charAt(r))){
                r--;
            }

            if(Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r))){
                return false;
            }            

            l++;
            r--;
        }

        return true;
    }

    public boolean isAlphaNum(char c){
        if(('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z') || '0' <= c && c <= '9'){
            return true;
        } 

        return false;
    }
}