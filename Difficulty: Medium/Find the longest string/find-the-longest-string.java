class Solution {
    public String longestString(String[] words) {
        // Sort the array lexicographically
        java.util.Arrays.sort(words);
        java.util.Set<String> built = new java.util.HashSet<>();
        String result = "";

        for (String word : words) {
            if (word.length() == 1 || built.contains(word.substring(0, word.length() - 1))) {
                built.add(word);
                if (word.length() > result.length() || 
                    (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }

        return result;
    }
}
