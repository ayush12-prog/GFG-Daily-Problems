class Solution {
    public boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String text = s1 + s1;
        return kmp(text, s2);
    }

    private boolean kmp(String text, String pattern) {
        int[] lps = buildLPS(pattern);
        int i = 0, j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) return true;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
        return false;
    }

    private int[] buildLPS(String p) {
        int[] lps = new int[p.length()];
        int len = 0, i = 1;

        while (i < p.length()) {
            if (p.charAt(i) == p.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        return lps;
    }
}
