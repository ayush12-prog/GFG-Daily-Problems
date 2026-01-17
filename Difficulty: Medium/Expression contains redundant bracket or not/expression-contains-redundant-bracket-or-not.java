class Solution {
    public static boolean checkRedundancy(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                boolean hasOperator = false;
                char top = stack.peek();
                stack.pop();
                
                while (top != '(') {
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        hasOperator = true;
                    }
                    top = stack.peek();
                    stack.pop();
                }
                
                if (!hasOperator) {
                    return true;
                }
            } else {
                stack.push(ch);
            }
        }
        
        return false;
    }
}