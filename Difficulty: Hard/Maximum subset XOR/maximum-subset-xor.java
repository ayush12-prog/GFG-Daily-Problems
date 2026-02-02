/*Complete the function below*/

class Solution {
    public int maxSubsetXOR(int[] arr, int n) {
        int index = 0;
        for (int i = 31; i >= 0; i--) {
            int maxElement = Integer.MIN_VALUE;
            int maxIndex = -1;
            
            for (int j = index; j < n; j++) {
                if (((arr[j] >> i) & 1) != 0 && arr[j] > maxElement) {
                    maxElement = arr[j];
                    maxIndex = j;
                }
            }
            
            if (maxElement == Integer.MIN_VALUE) {
                continue;
            }
            
            int temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;
            maxIndex = index;
            
            for (int j = 0; j < n; j++) {
                if (j != maxIndex && ((arr[j] >> i) & 1) != 0) {
                    arr[j] = arr[j] ^ arr[maxIndex];
                }
            }
            index++;
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, res ^ arr[i]);
        }
        return res;
    }
}