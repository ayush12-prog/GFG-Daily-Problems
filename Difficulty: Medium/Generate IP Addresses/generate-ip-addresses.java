class Solution {
    public ArrayList<String> generateIp(String s) {
        ArrayList<String> result = new ArrayList<>();
        
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, ArrayList<String> current, ArrayList<String> result) {
        if (current.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }

        int remainingParts = 4 - current.size();
        int remainingLength = s.length() - start;
        
        if (remainingLength < remainingParts || remainingLength > remainingParts * 3) {
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) {
                break;
            }
            
            String part = s.substring(start, start + len);
            
            if (part.length() > 1 && part.startsWith("0")) {
                continue; // Leading zeros are invalid unless the number is just "0"
            }
            
            if (len == 3 && Integer.parseInt(part) > 255) {
                continue; // IP parts cannot exceed 255
            }
            
            current.add(part);
            backtrack(s, start + len, current, result);
            current.remove(current.size() - 1);
        }
    }
}