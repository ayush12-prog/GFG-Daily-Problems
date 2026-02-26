class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            if (m1[c1] != m2[c2]) {
                return false;
            }
            
            m1[c1] = i + 1;
            m2[c2] = i + 1;
        }
        
        return true;
    }
}