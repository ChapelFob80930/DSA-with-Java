class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i<strs.length; i++){
            List<String> temp = new ArrayList<>();
            if("-1".equals(strs[i])){
                continue;
            }
            temp.add(strs[i]);
            for(int j = i+1; j<strs.length; j++){
                if(!"-1".equals(strs[j]) && checkIfAnagram(strs[i],strs[j])){
                    temp.add(strs[j]);
                    strs[j] = "-1";
                }
            }
            ans.add(temp);
        }

        return ans;
    }

    public boolean checkIfAnagram(String s, String t){
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int cnt : count) {
            if (cnt != 0) {
                return false;
            }
        }

        return true;
    }
}