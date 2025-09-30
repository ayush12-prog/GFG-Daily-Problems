class Solution {
    public ArrayList<String> binstr(int n) {
        ArrayList<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        int totalStrings = 1 << n;

        for (int i = 0; i < totalStrings; i++) {
            String binaryString = Integer.toBinaryString(i);
            String formatSpecifier = "%" + n + "s";
            String paddedString = String.format(formatSpecifier, binaryString).replace(' ', '0');
            result.add(paddedString);
        }
        
        return result;
    }
}