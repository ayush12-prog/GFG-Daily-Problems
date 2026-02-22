class Solution {
    public long subarrayXor(int arr[], int k) {
        long count = 0;
        int prefixXor = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        
        freqMap.put(0, 1);
        
        for (int num : arr) {
            prefixXor ^= num;
            
            int target = prefixXor ^ k;
            if (freqMap.containsKey(target)) {
                count += freqMap.get(target);
            }
            
            freqMap.put(prefixXor, freqMap.getOrDefault(prefixXor, 0) + 1);
        }
        
        return count;
    }
}