class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // Stores: sorted string -> list of its anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        // Traverse every word
        for (String s : strs) {

            // Convert the word into a character array
            char[] arr = s.toCharArray();

            // Sort the characters so all anagrams become identical
            Arrays.sort(arr);

            // Create the hashmap key
            String key = new String(arr);

            // Create a new group if this key doesn't exist
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add the original word to its anagram group
            map.get(key).add(s);
        }

        // Return all the groups
        return new ArrayList<>(map.values());
    }
}