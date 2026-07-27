class Solution {
    public List<String> letterCombinations(String digits) {
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

    public List<String> combinations(String p, String up, String[] map){

        ArrayList<String> ans = new ArrayList<>();

        if(up.isEmpty()){
            ans.add(p);
            return ans;
        }

        int digit = up.charAt(0) - '0';

        String padChars = map[digit];

        for(char c: padChars.toCharArray()){
            ans.addAll(combinations(p+c, up.substring(1), map));
        }

        return ans;
    }
}