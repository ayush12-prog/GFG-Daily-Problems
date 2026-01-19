class Solution {
    public String removeKdig(String s, int k) {
        if (k >= s.length()) {
            return "0";
        }

        Deque<Character> stack = new ArrayDeque<>();
        
        for (char digit : s.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > digit) {
                stack.removeLast();
                k--;
            }
            stack.addLast(digit);
        }
        
        while (k > 0) {
            stack.removeLast();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        
        for (char digit : stack) {
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            sb.append(digit);
        }
        
        if (sb.length() == 0) {
            return "0";
        }
        
        return sb.toString();
    }
}