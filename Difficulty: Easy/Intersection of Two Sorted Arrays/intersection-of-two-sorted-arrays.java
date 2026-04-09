class Solution {
    public ArrayList<Integer> intersection(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while (i < a.length && j < b.length) {
            // Skip duplicate elements in array 'a'
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            
            // Skip duplicate elements in array 'b'
            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }
            
            // Compare the elements
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                // Elements are equal, add to result and move both pointers
                result.add(a[i]);
                i++;
                j++;
            }
        }
        
        return result;
    }
}