class Solution {
    public ArrayList<Integer> search(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = a.length;
        int m = b.length;

        if (m == 0 || m > n) {
            return result;
        }

        int[] lps = new int[m];
        int len = 0;
        int i = 1;
        while (i < m) {
            if (b[i] == b[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        i = 0; 
        int j = 0; 
        while (i < n) {
            if (b[j] == a[i]) {
                j++;
                i++;
            }
            if (j == m) {
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < n && b[j] != a[i]) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }
}