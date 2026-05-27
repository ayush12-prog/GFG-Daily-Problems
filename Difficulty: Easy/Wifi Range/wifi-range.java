class Solution {
    public boolean wifiRange(String s, int x) {
        int n = s.length();
        int target = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                if (target < i - x) {
                    return false; 
                }
                target = Math.max(target, i + x + 1);
            }
        }
        
        return target >= n;
    }
}