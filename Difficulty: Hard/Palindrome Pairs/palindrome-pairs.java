class Solution {
    public boolean palindromePair(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        for (String s : arr) {
            int len = s.length();
            
            for (int i = 0; i <= len; i++) {
                String prefix = s.substring(0, i);
                String suffix = s.substring(i);
                
                if (isPalindrome(prefix)) {
                    String target = new StringBuilder(suffix).reverse().toString();
                    if (map.containsKey(target)) {
                        if (!target.equals(s) || map.get(s) > 1) {
                            return true;
                        }
                    }
                }
                
                if (isPalindrome(suffix)) {
                    String target = new StringBuilder(prefix).reverse().toString();
                    if (map.containsKey(target)) {
                        if (!target.equals(s) || map.get(s) > 1) {
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}