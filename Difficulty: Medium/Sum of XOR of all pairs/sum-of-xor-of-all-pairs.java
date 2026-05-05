class Solution {
    public long sumXOR(int arr[]) {
        long sum = 0;
        
        for (int i = 0; i < 32; i++) {
            long zeroCount = 0;
            long oneCount = 0;
            
            for (int num : arr) {
                if (((num >> i) & 1) == 1) {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }
            
            sum += zeroCount * oneCount * (1L << i);
        }
        
        return sum;
    }
}