class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int i = 0, j = 0, k = 0;
        int prevCommon = Integer.MIN_VALUE; // To track duplicates
        
        while (i < a.length && j < b.length && k < c.length) {
            // Skip duplicates in array a
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            
            // Skip duplicates in array b
            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }
            
            // Skip duplicates in array c
            if (k > 0 && c[k] == c[k - 1]) {
                k++;
                continue;
            }
            
            // If all three elements are equal
            if (a[i] == b[j] && b[j] == c[k]) {
                // Add to result only if it's not a duplicate of previously added element
                if (a[i] != prevCommon) {
                    result.add(a[i]);
                    prevCommon = a[i];
                }
                i++;
                j++;
                k++;
            }
            // Move the pointer with the smallest element
            else if (a[i] < b[j]) {
                i++;
            }
            else if (b[j] < c[k]) {
                j++;
            }
            else {
                k++;
            }
        }
        
        return result;
    }
}